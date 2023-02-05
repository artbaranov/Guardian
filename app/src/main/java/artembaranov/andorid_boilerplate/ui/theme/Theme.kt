package artembaranov.andorid_boilerplate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Created by Artem Baranov on 05.02.2023.
 */

private val DarkColorPalette = darkColors(
    primary = Color.ExampleColor1,
    primaryVariant = Color.ExampleColor2,
)

private val LightColorPalette = lightColors(
    primary = Color.ExampleColor2,
    primaryVariant = Color.ExampleColor1,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BoilerplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = BoilerplateTypography,
        shapes = BoilerplateShapes,
        content = content
    )
}
