package ng.thenorthstar.goldenlist.android.features.navigation.presentation.favoriteListings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ng.thenorthstar.goldenlist.android.R
import ng.thenorthstar.goldenlist.android.features.GoldenListViewModel
import ng.thenorthstar.goldenlist.android.features.UIState.*
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.listings.jobListingItem
import ng.thenorthstar.goldenlist.android.theme.typography
import org.koin.androidx.compose.getViewModel


@Composable
fun FavoriteListingsRoute(
    navigateToFavorites: (String) -> Unit,
    viewModel: GoldenListViewModel = getViewModel()
) {
    val favoriteListings by viewModel.favoriteJobListings.collectAsState()
    val uiState by viewModel.detailScreenState.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    LaunchedEffect(key1 = Unit, block = {
        viewModel.fetchFavorites()
    })
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = { viewModel.fetchFavorites() }) {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.golden_list_db),
                style = typography.h1,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
        }
        Divider()
        when (uiState) {
            LOADING -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    CircularProgressIndicator()
                }
            }
            NORMAL -> {
                LazyColumn {
                    items(favoriteListings!!) {
                        jobListingItem(it, viewModel, navigateToFavorites)
                    }
                }
            }
            ERROR -> {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Text(text = "Error occurred loading favorite listings!", style = typography.h3)
                }
            }
            EMPTY -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    Text(text = "No favorite listings available.", style = typography.h4)

                }
            }
        }
    }
}