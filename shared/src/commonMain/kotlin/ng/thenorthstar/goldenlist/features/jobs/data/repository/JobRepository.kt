package ng.thenorthstar.goldenlist.features.jobs.data.repository

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.single
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class JobRepository internal constructor(
    private val jobRemoteSource: JobRemoteSource,
    private val jobLocalSource: JobLocalSource,
) : KoinComponent {
    private val appSettings: AppSettings by inject()

    suspend fun fetchJobListings() =
        jobRemoteSource.fetchJobListings()

    suspend fun fetchFavoriteListings() =
        jobLocalSource.jobs.first()
    suspend fun markFavorite(jobListing: JobListing) =
        jobLocalSource.insert(jobListing)

    init {

    }

    suspend fun setHasViewedOnboarding(hasViewedOnboarding: Boolean) =
        appSettings.updateOnboardingState(hasViewedOnboarding)

    suspend fun hasViewedOnboarding() = appSettings.hasViewedOnboarding

}