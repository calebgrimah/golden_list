package ng.thenorthstar.goldenlist.android.features.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.favoriteListings.favoriteListingsGraph
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.listingDetail.ListingDetailsDestination
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.listingDetail.listingDetailsGraph
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.listings.JobListingsDestination
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.listings.jobListingsGraph

@Composable
fun GoldenListNavHost(
    navController: NavHostController,
    onNavigateToDestination: (GoldenListNavigationDestination, String) -> Unit = { _, _ -> },
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    startDestination: String = JobListingsDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        jobListingsGraph(
            navigateToJobListings = {
                onNavigateToDestination(
                    ListingDetailsDestination,
                    ListingDetailsDestination.createNavigationRoute(it)
                )
            })
        favoriteListingsGraph(navigateToFavoriteListings = {
            onNavigateToDestination(
                ListingDetailsDestination,
                ListingDetailsDestination.createNavigationRoute(it)
            )
        }
        )
        listingDetailsGraph(onBackClick)
    }
}