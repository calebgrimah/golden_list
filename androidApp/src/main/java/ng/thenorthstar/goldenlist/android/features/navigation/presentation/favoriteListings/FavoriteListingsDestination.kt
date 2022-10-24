package ng.thenorthstar.goldenlist.android.features.navigation.presentation.favoriteListings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ng.thenorthstar.goldenlist.android.features.navigation.GoldenListNavigationDestination


object FavoriteListingsDestination : GoldenListNavigationDestination {
    override val route = "favorite_listings_route"
    override val destination = "favorite_listings_destination"
}

fun NavGraphBuilder.favoriteListingsGraph(navigateToFavoriteListings: (String) -> Unit) {
    composable(route = FavoriteListingsDestination.route) {
        FavoriteListingsRoute(navigateToFavoriteListings)
    }
}