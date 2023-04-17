package artembaranov.guardian.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import artembaranov.guardian.ui.screens.HomeScreen

fun NavGraphBuilder.navGraph(
    navController: NavController,
){
    composable(HOME_SCREEN){
        HomeScreen(modifier = Modifier.fillMaxSize())
    }
}

const val HOME_SCREEN = "HOME"
