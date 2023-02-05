package artembaranov.andorid_boilerplate.ui.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Stable
val Color.Companion.ExampleColor1: Color
    get() = Color(0xFF008493)

@Stable
val Color.Companion.ExampleColor2: Color
    get() = Color(0xFF21DCD9)

@Stable
class BoilerplateColors(
    primary: Color,
    lightThemeEnabled: Boolean
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set

    var lightThemeEnabled by mutableStateOf(lightThemeEnabled, structuralEqualityPolicy())
        internal set

    fun copy(
        primary: Color = this.primary,
        lightThemeEnabled: Boolean = this.lightThemeEnabled
    ): BoilerplateColors = BoilerplateColors(
        primary,
        lightThemeEnabled,
    )
}

internal fun boilerplateLightColors(): BoilerplateColors = BoilerplateColors(
    primary = Color.ExampleColor1,
    lightThemeEnabled = true
)

internal fun boilerplateDarkColors(): BoilerplateColors = BoilerplateColors(
    primary = Color.ExampleColor2,
    lightThemeEnabled = false
)
