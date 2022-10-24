package ng.thenorthstar.goldenlist.android.features.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Work
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ng.thenorthstar.goldenlist.android.R
import ng.thenorthstar.goldenlist.android.features.navigation.GoldenListNavigationDestination
import ng.thenorthstar.goldenlist.android.features.navigation.TopLevelDestination
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.favoriteListings.FavoriteListingsDestination
import ng.thenorthstar.goldenlist.android.features.navigation.presentation.listings.JobListingsDestination

@Composable
fun rememberGoldenListAppState(
    navController: NavHostController = rememberNavController()
): GoldenListAppState {
    return remember(navController,) {
        GoldenListAppState(navController,)
    }
}

@Stable
class GoldenListAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    /**
     * Top level destinations to be used in the BottomBar and NavRail
     */
    val topLevelDestinations: List<TopLevelDestination> = listOf(
        TopLevelDestination(
            route = JobListingsDestination.route,
            destination = JobListingsDestination.destination,
            selectedIcon = Icons.Filled.Work,
            unselectedIcon = Icons.Outlined.Work,
            iconTextId = R.string.listings
        ),
        TopLevelDestination(
            route = FavoriteListingsDestination.route,
            destination = FavoriteListingsDestination.destination,
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.Favorite,
            iconTextId = R.string.favorites
        ),
    )


    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * Top level destinations have only one copy of the destination of the back stack, and save and
     * restore state whenever you navigate to and from it.
     * Regular destinations can have multiple copies in the back stack and state isn't saved nor
     * restored.
     *
     * @param destination: The [ConfettiNavigationDestination] the app needs to navigate to.
     * @param route: Optional route to navigate to in case the destination contains arguments.
     */
    fun navigate(destination: GoldenListNavigationDestination, route: String? = null) {
        if (destination is TopLevelDestination) {
            navController.navigate(route ?: destination.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        } else {
            navController.navigate(route ?: destination.route)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}