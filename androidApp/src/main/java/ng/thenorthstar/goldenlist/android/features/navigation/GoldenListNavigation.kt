package ng.thenorthstar.goldenlist.android.features.navigation

/**
 * Interface for describing the Confetti navigation destinations
 * author : https://github.com/joreilly/Confetti
 */

interface GoldenListNavigationDestination {
    /**
     * Defines a specific route this destination belongs to.
     * Route is a String that defines the path to your composable.
     * You can think of it as an implicit deep link that leads to a specific destination.
     * Each destination should have a unique route.
     */
    val route: String

    /**
     * Defines a specific destination ID.
     * This is needed when using nested graphs via the navigation DLS, to differentiate a specific
     * destination's route from the route of the entire nested graph it belongs to.
     */
    val destination: String
}
