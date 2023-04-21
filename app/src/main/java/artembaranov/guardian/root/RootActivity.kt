package artembaranov.guardian.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
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
                )

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController, navigationItems = items)
                    },
                    topBar = {
                        TopAppBar(contentPadding = PaddingValues(end = 25.dp)) {
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(modifier = Modifier, imageVector = Icons.Filled.Search, contentDescription = null)
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
