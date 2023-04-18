package artembaranov.guardian.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import artembaranov.guardian.R
import artembaranov.guardian.ui.screens.home.Home

fun NavGraphBuilder.navGraph(
    navController: NavController,
) {
    composable(Screen.Home.route) { Home(viewModel = viewModel()) }
}

sealed class Screen(val route: String, @StringRes val stringId: Int, val imageVector: ImageVector) {
    object Home : Screen(HOME, R.string.bottom_navigation_item_home, Icons.Filled.Home)
}

const val HOME = "HOME"
