package ng.thenorthstar.goldenlist.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
//    val colors = if (darkTheme) {
//        darkColors().copy(
//            primary = turquoise,
//            primaryVariant = turquoiseDark,
//            secondary = navy,
//            secondaryVariant = black80,
//            onPrimary = grey
//        )else {
//
//        }
//    }

    MaterialTheme(
        colors = lightColors().copy(
            primary = orange,
            primaryVariant = blue,
            secondary = navy,
            secondaryVariant = black80,
            onPrimary = grey
        ),
        shapes = shapes,
        typography = typography,
        content = content
    )
}