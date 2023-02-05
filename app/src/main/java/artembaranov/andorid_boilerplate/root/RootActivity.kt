package artembaranov.andorid_boilerplate.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import artembaranov.andorid_boilerplate.ui.navigation.BOILERPLATE_SCREEN_1
import artembaranov.andorid_boilerplate.ui.navigation.navGraph
import artembaranov.andorid_boilerplate.ui.theme.BoilerplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BoilerplateTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = BOILERPLATE_SCREEN_1 ,
                ){
                    navGraph(navController)
                }
            }
        }
    }
}
