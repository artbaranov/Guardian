package artembaranov.andorid_boilerplate.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import artembaranov.andorid_boilerplate.ui.BoilerplateScreen1

fun NavGraphBuilder.navGraph(
    navController: NavController,
){
    composable(BOILERPLATE_SCREEN_1){
        BoilerplateScreen1(modifier = Modifier.fillMaxSize())
    }
}

const val BOILERPLATE_SCREEN_1 = "BOILERPLATE_SCREEN_1"
