package artembaranov.guardian.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color


@Stable
val Color.Companion.MineShaft: Color
    get() = Color(0xFF222222)

@Stable
val Color.Companion.MineShaftLight: Color
    get() = Color(0xFF2B2B2B)

@Stable
val Color.Companion.PhilippineGray: Color
    get() = Color(0xFF909090)

@Stable
val Color.Companion.Alto: Color
    get() = Color(0xFFDDDDDD)

@Stable
val Color.Companion.Gallery: Color
    get() = Color(0xFFEEEEEE)

@Stable
class GuardianColors(
    primary: Color,
    background: Color,
    onSurface: Color,
    lightThemeEnabled: Boolean
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set

    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set

    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set

    var lightThemeEnabled by mutableStateOf(lightThemeEnabled, structuralEqualityPolicy())
        internal set

    fun copy(
        primary: Color = this.primary,
        background: Color = this.background,
        onSurface: Color = this.onSurface,
        lightThemeEnabled: Boolean = this.lightThemeEnabled,
    ): GuardianColors = GuardianColors(
        primary,
        background,
        onSurface,
        lightThemeEnabled,
    )
}

internal fun guardianLightColors(): GuardianColors = GuardianColors(
    primary = Color.MineShaft,
    background = Color.Gallery,
    onSurface = Color.LightGray,
    lightThemeEnabled = true
)

internal fun guardianDarkColors(): GuardianColors = GuardianColors(
    primary = Color.PhilippineGray,
    background = Color.MineShaftLight,
    onSurface = Color.LightGray,
    lightThemeEnabled = false
)
