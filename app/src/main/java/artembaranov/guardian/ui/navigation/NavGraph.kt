package artembaranov.guardian.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import artembaranov.guardian.R
import artembaranov.guardian.ui.screens.home.Home

fun NavGraphBuilder.navGraph(
    navController: NavController,
) {
    composable(HOME) {
        Home(modifier = Modifier.fillMaxSize())
    }
}

sealed class Screen(val route: String, @StringRes val stringId: Int, val imageVector: ImageVector) {
    object Home : Screen(HOME, R.string.bottom_navigation_item_home, Icons.Filled.Home)
    object Settings : Screen(SETTINGS, R.string.bottom_navigation_item_settings, Icons.Filled.Settings)
}

const val HOME = "HOME"
const val SETTINGS = "SETTINGS"
