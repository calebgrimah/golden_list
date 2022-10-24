package ng.thenorthstar.goldenlist.android.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobRepository
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing
import ng.thenorthstar.goldenlist.features.jobs.domain.usecases.FetchFavoriteJobListingsUseCase
import ng.thenorthstar.goldenlist.features.jobs.domain.usecases.FetchJobListingsUseCase
import ng.thenorthstar.goldenlist.features.jobs.domain.usecases.MarkJobListingAsFavoriteUseCase
import ng.thenorthstar.goldenlist.features.jobs.domain.usecases.SetOnboardingStateAsViewedUseCase

class GoldenListViewModel(
    private val jobRepository: JobRepository,
    private val fetchJobListingsUseCase: FetchJobListingsUseCase,
    private val markJobListingAsFavoriteUseCase: MarkJobListingAsFavoriteUseCase,
    private val setOnboardingStateAsViewedUseCase: SetOnboardingStateAsViewedUseCase,
    private val fetchFavoriteJobListingsUseCase: FetchFavoriteJobListingsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(UIState.LOADING)
    val state: StateFlow<UIState> = _state
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing
    private val _events = MutableSharedFlow<Event>()
    val events: SharedFlow<Event> = _events

    private val _jobListings = MutableStateFlow<List<JobListing?>?>(emptyList())
    val listings: StateFlow<List<JobListing?>?> = _jobListings

    private val _favoriteJobListings = MutableStateFlow<List<JobListing?>?>(emptyList())
    val favoriteJobListings: StateFlow<List<JobListing?>?> = _favoriteJobListings
//var favoriteListings  =
    private val _detailScreenState = MutableStateFlow(UIState.LOADING)
    val detailScreenState: StateFlow<UIState> = _detailScreenState

    init {
        loadJobListings()
    }


    private fun loadJobListings() {
        _state.value = UIState.LOADING
        viewModelScope.launch {
            _state.value = try {
                val listings = fetchJobListingsUseCase.invoke()
                _jobListings.value = listings
                UIState.NORMAL
            } catch (e: Exception) {
                UIState.ERROR
            }
            _isRefreshing.value = false
        }
    }

    fun fetchFavorites() {
        _detailScreenState.value = UIState.LOADING
        _isRefreshing.value = true
        viewModelScope.launch {
            _detailScreenState.value = try {
                val listings = fetchFavoriteJobListingsUseCase.invoke()
                _favoriteJobListings.value  =
                    listings
                UIState.NORMAL
            } catch (e: Exception) {
                UIState.ERROR
            }
            _isRefreshing.value = false
        }
    }

    fun addToFavorites(listing: JobListing) {
        viewModelScope.launch {
            jobRepository.markFavorite(listing)
        }
    }

    fun refresh() {
        loadJobListings()
    }


}


enum class UIState {
    LOADING, NORMAL, ERROR, EMPTY
}

enum class Event {
    Error
}