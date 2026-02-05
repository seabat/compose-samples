package dev.seabat.android.compose.samplelist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.seabat.android.compose.samplelist.screens.HomeScreen
import dev.seabat.android.compose.samplelist.screens.LazyVerticalGridScreen
import dev.seabat.android.compose.samplelist.screens.StaggeredGridScreen
import dev.seabat.android.compose.samplelist.screens.FlowRowScreen
import dev.seabat.android.compose.samplelist.screens.StickyHeaderScreen
import dev.seabat.android.expandablelist.AnimateExpandableListScreen

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

        composable(Screen.LazyVerticalGrid.route) {
            LazyVerticalGridScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.StaggeredGrid.route) {
            StaggeredGridScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.FlowRow.route) {
            FlowRowScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.AnimateExpandableList.route) {
            AnimateExpandableListScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.StickyHeader.route) {
            StickyHeaderScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}