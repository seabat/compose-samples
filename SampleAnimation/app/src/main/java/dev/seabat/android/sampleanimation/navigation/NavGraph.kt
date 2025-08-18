package dev.seabat.android.sampleanimation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.seabat.android.sampleanimation.HomeScreen
import dev.seabat.android.sampleanimation.ui.screens.Sample1Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample2Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample3Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample4Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample5Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample6Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample7Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample8Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample9Screen
import dev.seabat.android.sampleanimation.ui.screens.Sample10Screen

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
        
        composable(Screen.Sample4.route) {
            Sample4Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Sample5.route) {
            Sample5Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Sample6.route) {
            Sample6Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Sample7.route) {
            Sample7Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Sample8.route) {
            Sample8Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Sample9.route) {
            Sample9Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Sample10.route) {
            Sample10Screen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
} 