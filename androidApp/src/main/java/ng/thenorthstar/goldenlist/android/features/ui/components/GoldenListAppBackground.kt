package ng.thenorthstar.goldenlist.android.features.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

/**
 * A class to model background color and tonal elevation values
 */
@Immutable
data class BackgroundTheme(
    val color: Color = Color.Unspecified,
    val tonalElevation: Dp = Dp.Unspecified
)

/**
 * A composition local for [BackgroundTheme].
 */
val LocalBackgroundTheme = staticCompositionLocalOf { BackgroundTheme() }


/**
 * The main background for the app.
 * Uses [LocalBackgroundTheme] to set the color and tonal elevation of a [Box].
 *
 * @param modifier Modifier to be applied to the background.
 * @param content The background content.
 */
@Composable
fun GoldenListBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val color = LocalBackgroundTheme.current.color
    val tonalElevation = LocalBackgroundTheme.current.tonalElevation
    Surface(
        color = if (color == Color.Unspecified) Color.Transparent else color,
        modifier = modifier.fillMaxSize(),
    ) {
        CompositionLocalProvider() {
            content()
        }
    }
}

@Composable
fun GoldenBackgroundWithImage(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
//    val currentTopColor by rememberUpdatedState(topColor)
//    val currentBottomColor by rememberUpdatedState(bottomColor)
    GoldenListBackground(modifier) {
        Box(
            Modifier
                .fillMaxSize()
//                .drawWithCache {
//                    // Compute the start and end coordinates such that the gradients are angled 11.06
//                    // degrees off the vertical axis
//                    val offset = size.height * tan(
//                        Math
//                            .toRadians(11.06)
//                            .toFloat()
//                    )
//
//                    val start = Offset(size.width / 2 + offset / 2, 0f)
//                    val end = Offset(size.width / 2 - offset / 2, size.height)
//
//                    // Create the top gradient that fades out after the halfway point vertically
//                    val topGradient = Brush.linearGradient(
//                        0f to if (currentTopColor == Color.Unspecified) {
//                            Color.Transparent
//                        } else {
//                            currentTopColor
//                        },
//                        0.724f to Color.Transparent,
//                        start = start,
//                        end = end,
//                    )
//                    // Create the bottom gradient that fades in before the halfway point vertically
//                    val bottomGradient = Brush.linearGradient(
//                        0.2552f to Color.Transparent,
//                        1f to if (currentBottomColor == Color.Unspecified) {
//                            Color.Transparent
//                        } else {
//                            currentBottomColor
//                        },
//                        start = start,
//                        end = end,
//                    )
//
//                    onDrawBehind {
//                        // There is overlap here, so order is important
//                        drawRect(topGradient)
//                        drawRect(bottomGradient)
//                    }
//                }
        ) {
            Image(
                painter = painterResource(id = ng.thenorthstar.goldenlist.android.R.drawable.app_background),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize()
            )
            content()
        }
    }
}