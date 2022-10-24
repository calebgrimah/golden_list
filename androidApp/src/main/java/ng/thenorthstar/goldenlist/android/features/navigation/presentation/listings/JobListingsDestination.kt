package ng.thenorthstar.goldenlist.android.features.navigation.presentation.listings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ng.thenorthstar.goldenlist.android.features.navigation.GoldenListNavigationDestination

object JobListingsDestination : GoldenListNavigationDestination {
    override val route = "job_listings_route"
    override val destination = "job_listings_destination"
}

fun NavGraphBuilder.jobListingsGraph(navigateToJobListings: (String) -> Unit) {
    composable(route = JobListingsDestination.route) {
        JobListingsRoute(navigateToJobListings)
    }
}