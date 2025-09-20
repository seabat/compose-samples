package dev.seabat.android.compose.samplelist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.seabat.android.compose.samplelist.screens.HomeScreen
import dev.seabat.android.compose.samplelist.screens.Sample1Screen
import dev.seabat.android.compose.samplelist.screens.Sample2Screen
import dev.seabat.android.compose.samplelist.screens.Sample3Screen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToSample = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(Screen.Sample1.route) {
            Sample1Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Sample2.route) {
            Sample2Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Sample3.route) {
            Sample3Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}