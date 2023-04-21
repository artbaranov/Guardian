package artembaranov.guardian.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import artembaranov.guardian.R
import artembaranov.guardian.ui.screens.home.Home
import artembaranov.guardian.ui.screens.threat.ThreatDetails
import artembaranov.guardian.ui.screens.threat.ThreatDetailsViewModel

fun NavGraphBuilder.navGraph(
    navController: NavController,
) {
    composable(Screen.Home.route) {
        Home(viewModel = hiltViewModel(),
            onThreatClicked = { threat ->
                navController.navigate("THREAT/${threat.id}")
            }
        )
    }
    composable(
        THREAT_DETAILS,
        arguments = listOf(navArgument(ThreatDetailsViewModel.SavedStateKeys.THREAT_ID) { type = NavType.LongType })
    ) {
        ThreatDetails(modifier = Modifier.fillMaxSize(), viewModel = hiltViewModel())
    }
}

sealed class Screen(val route: String, @StringRes val stringId: Int, val imageVector: ImageVector) {
    object Home : Screen(HOME, R.string.bottom_navigation_item_home, Icons.Filled.Home)
}

const val HOME = "HOME"
const val THREAT_DETAILS = "THREAT/{threatId}"
