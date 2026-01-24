package dev.seabat.android.samplecanvas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.seabat.android.samplecanvas.ui.screens.HomeScreen
import dev.seabat.android.samplecanvas.ui.screens.Sample1Screen

@Composable
fun MainNavGraph(
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
    }
}