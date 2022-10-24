package ng.thenorthstar.goldenlist.android

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import ng.thenorthstar.goldenlist.android.features.navigation.GoldenListNavHost
import ng.thenorthstar.goldenlist.android.features.navigation.TopLevelDestination
import ng.thenorthstar.goldenlist.android.features.ui.GoldenListAppState
import ng.thenorthstar.goldenlist.android.features.ui.components.GoldenBackgroundWithImage
import ng.thenorthstar.goldenlist.android.features.ui.rememberGoldenListAppState
import ng.thenorthstar.goldenlist.android.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GoldenListApp(
    appState: GoldenListAppState = rememberGoldenListAppState()
) {
    AppTheme {
        GoldenBackgroundWithImage {
            Scaffold(
                contentColor = MaterialTheme.colors.secondary,
                bottomBar = {
                    GoldenListBottomBar(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigate,
                        currentDestination = appState.currentDestination
                    )
                }
            ) { paddingValues ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                ) {
                    GoldenListNavHost(
                        navController = appState.navController,
                        onBackClick = appState::onBackClick,
                        onNavigateToDestination = appState::navigate,
                        modifier = androidx.compose.ui.Modifier
                            .padding(paddingValues)
                            .consumedWindowInsets(paddingValues)
                    )
                }
            }
        }
    }

}

@Composable
private fun GoldenListBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    BottomAppBar(
        contentColor = GoldenListNavigationDefaults.navigationContentColor(),
        elevation = 0.dp,
    ) {
        destinations.forEach { destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            BottomNavigationItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    Icon(icon, contentDescription = stringResource(destination.iconTextId))
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}

object GoldenListNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colors.surface

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colors.primary

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colors.onPrimary
}