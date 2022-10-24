package ng.thenorthstar.goldenlist.android.features.navigation.presentation.listings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import io.github.aakira.napier.Napier
import ng.thenorthstar.goldenlist.android.R
import ng.thenorthstar.goldenlist.android.features.GoldenListViewModel
import ng.thenorthstar.goldenlist.android.features.UIState
import ng.thenorthstar.goldenlist.android.theme.blue
import ng.thenorthstar.goldenlist.android.theme.shapes
import ng.thenorthstar.goldenlist.android.theme.typography
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing
import org.koin.androidx.compose.getViewModel
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

@Composable
fun JobListingsRoute(
    navigateToJobsListings: (String) -> Unit,
    viewModel: GoldenListViewModel = getViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val jobListings by viewModel.listings.collectAsState()
//    val coroutineScope = rememberCoroutineScope()
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = { viewModel.refresh() }) {
        Column {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.golden_list),
                    style = typography.h1,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )
            }
            Divider()
            when (uiState) {
                UIState.LOADING -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)
                    ) {
                        CircularProgressIndicator()
                    }
                }
                UIState.NORMAL -> {
                    LazyColumn {
                        items(jobListings!!) {
                            jobListingItem(it,viewModel, navigateToJobsListings)
                        }
                    }
                }
                UIState.ERROR -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Column(Modifier.verticalScroll(rememberScrollState())) {
                            Text(text = "Error occurred loading content!", style = typography.h3)
                        }
                    }
                }
                UIState.EMPTY -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Text(text = "No listings available.", style = typography.h4)

                    }
                }
            }
        }
    }

}

@Composable
fun jobListingItem(jobListing: JobListing?,viewModel: GoldenListViewModel,  navigateToJobsListings: (String) -> Unit) {
    val dateLong = jobListing?.dateCreated?.toLong()
    val createdDate = Date(dateLong ?: Instant.now().epochSecond)
    val formattedDate = SimpleDateFormat("yyyy, MM dd").format(createdDate)
    Card(
        shape = shapes.large,
        backgroundColor = blue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .clickable {
                viewModel.addToFavorites(jobListing!!)
                navigateToJobsListings(jobListing.url)
            }
    ) {
        Column {
            Text(
                text = jobListing?.jobTitle ?: "Not Available",
                Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = typography.body1
            )
            Text(
                text = jobListing?.location ?: "No Location",
                Modifier.padding(start = 16.dp, top = 4.dp),
                style = typography.h4
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
            ) {
                Text(text = formattedDate, modifier = Modifier.padding(end = 16.dp))
            }
        }
    }
}