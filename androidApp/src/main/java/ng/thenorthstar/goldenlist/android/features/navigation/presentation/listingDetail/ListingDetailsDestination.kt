package ng.thenorthstar.goldenlist.android.features.navigation.presentation.listingDetail

import android.net.Uri
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ng.thenorthstar.goldenlist.android.features.navigation.GoldenListNavigationDestination

object ListingDetailsDestination : GoldenListNavigationDestination {
    const val listingIdArg = "listingId"
    override val route = "listing_details_route/{$listingIdArg}"
    override val destination = "listing_details_destination"

    fun createNavigationRoute(listingId: String): String {
        val encodedId = Uri.encode(listingId)
        return "listing_details_route/$encodedId"
    }

    fun fromNavArgs(entry: NavBackStackEntry): String {
        val encodedId = entry.arguments?.getString(listingIdArg)!!
        return Uri.decode(encodedId)
    }
}

fun NavGraphBuilder.listingDetailsGraph(onBackClick: () -> Unit) {
    composable(
        route = ListingDetailsDestination.route,
        arguments = listOf(
            navArgument(ListingDetailsDestination.listingIdArg) { type = NavType.StringType }
        )
    ) {
        ListingDetailsRoute(
            onBackClick,
            it.arguments?.getString((ListingDetailsDestination.listingIdArg))
        )
    }
}