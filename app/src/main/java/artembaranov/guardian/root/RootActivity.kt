package artembaranov.guardian.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import artembaranov.guardian.ui.components.BottomNavigationBar
import artembaranov.guardian.ui.navigation.HOME
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

                val bottomBarVisible = remember { mutableStateOf(true) }
                val topBarVisible = rememberSaveable { mutableStateOf(true) }

                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestinationRoute = backStackEntry?.destination?.route

                when (currentDestinationRoute) {
                    HOME -> {
                        bottomBarVisible.value = true
                        topBarVisible.value = true
                    }

                    "THREAT/{threatId}" -> {
                        bottomBarVisible.value = false
                        topBarVisible.value = false
                    }
                }

                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            visible = bottomBarVisible.value,
                            enter = slideInVertically(initialOffsetY = { it }),
                            exit = slideOutVertically(targetOffsetY = { it }),
                        ) {
                            BottomNavigationBar(navController = navController, navigationItems = items)
                        }
                    },
                    topBar = {
                        AnimatedVisibility(
                            visible = topBarVisible.value,
                            enter = slideInVertically(initialOffsetY = { -it }),
                            exit = slideOutVertically(targetOffsetY = { -it }),
                        ) {
                            TopAppBar(
                                contentPadding = PaddingValues(end = 25.dp),
                            ) {
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(modifier = Modifier, imageVector = Icons.Filled.Search, contentDescription = null)
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
