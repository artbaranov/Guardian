package artembaranov.guardian.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Created by Artem Baranov on 05.02.2023.
 */

private val DarkColorPalette = guardianDarkColors()

private val LightColorPalette = guardianLightColors()

internal val LocalReplacementColors = staticCompositionLocalOf {
    guardianLightColors()
}

object GuardianTheme {
    val colors: GuardianColors
        @Composable
        @ReadOnlyComposable
        get() = LocalReplacementColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = GuardianTypography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = GuardianShapes
}

@Composable
fun GuardianTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(
        LocalReplacementColors provides colors
    ) {
        MaterialTheme(
            typography = GuardianTypography,
            shapes = GuardianShapes,
            content = content
        )
    }
}
