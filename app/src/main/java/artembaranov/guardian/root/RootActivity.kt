package artembaranov.guardian.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import artembaranov.guardian.ui.navigation.HOME_SCREEN
import artembaranov.guardian.ui.navigation.navGraph
import artembaranov.guardian.ui.theme.GuardianTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GuardianTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = HOME_SCREEN,
                ){
                    navGraph(navController)
                }
            }
        }
    }
}
