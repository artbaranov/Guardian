package artembaranov.guardian.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import artembaranov.guardian.R
import artembaranov.guardian.ui.screens.home.Home

fun NavGraphBuilder.navGraph(
    navController: NavController,
) {
    composable(Screen.Home.route) { Home() }
//    composable(Screen.Settings.route) { Settings() }
}

sealed class Screen(val route: String, @StringRes val stringId: Int, val imageVector: ImageVector) {
    object Home : Screen(HOME, R.string.bottom_navigation_item_home, Icons.Filled.Home)
//    object Settings : Screen(SETTINGS, R.string.bottom_navigation_item_settings, Icons.Filled.Settings)
}

const val HOME = "HOME"
//const val SETTINGS = "SETTINGS"
