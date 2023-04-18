package artembaranov.guardian.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import artembaranov.guardian.ui.components.BottomNavigationBar
import artembaranov.guardian.ui.navigation.Screen
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

                val items = listOf(
                    Screen.Home,
                    Screen.Settings,
                )

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController, navigationItems = items)
                    },
                    topBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        if (currentDestination?.route == Screen.Home.route) {
                            TopAppBar(modifier = Modifier.background(Color.Black)) {

                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
                        navGraph(navController)
                    }
                }
            }
        }
    }
}
