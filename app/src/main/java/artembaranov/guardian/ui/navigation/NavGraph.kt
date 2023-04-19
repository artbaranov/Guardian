package artembaranov.guardian.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import artembaranov.guardian.R
import artembaranov.guardian.ui.screens.home.Home
import artembaranov.guardian.ui.screens.threat.ThreatDetails

fun NavGraphBuilder.navGraph(
    navController: NavController,
) {
    composable(Screen.Home.route) {
        Home(viewModel = viewModel(),
            onThreatClicked = { threat ->
                navController.navigate("THREAT/${threat.id}")
            }
        )
    }
    composable(
        THREAT_DETAILS,
        arguments = listOf(navArgument("threatId") { type = NavType.LongType })
    ) {
        ThreatDetails(viewModel())
    }
}

sealed class Screen(val route: String, @StringRes val stringId: Int, val imageVector: ImageVector) {
    object Home : Screen(HOME, R.string.bottom_navigation_item_home, Icons.Filled.Home)
}

const val HOME = "HOME"
const val THREAT_DETAILS = "THREAT/{threatId}"
