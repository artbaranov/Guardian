package artembaranov.guardian.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color


@Stable
class GuardianColors(
    onSurface: Color,
    lightThemeEnabled: Boolean
) {
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set

    var lightThemeEnabled by mutableStateOf(lightThemeEnabled, structuralEqualityPolicy())
        internal set

    fun copy(
        onSurface: Color = this.onSurface,
        lightThemeEnabled: Boolean = this.lightThemeEnabled,
    ): GuardianColors = GuardianColors(
        onSurface,
        lightThemeEnabled,
    )
}

internal fun guardianLightColors(): GuardianColors = GuardianColors(
    onSurface = Color.Gray,
    lightThemeEnabled = true
)

internal fun guardianDarkColors(): GuardianColors = GuardianColors(
    onSurface = Color.LightGray,
    lightThemeEnabled = false
)
