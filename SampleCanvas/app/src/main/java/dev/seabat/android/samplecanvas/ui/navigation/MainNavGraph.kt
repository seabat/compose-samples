package dev.seabat.android.samplecanvas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import dev.seabat.android.samplecanvas.ui.screens.HomeScreen
import dev.seabat.android.samplecanvas.ui.screens.Sample1Screen
import dev.seabat.android.samplecanvas.ui.screens.Sample2Screen

@Composable
fun MainNavGraph(
    backStack: MutableList<Screen>,
    modifier: Modifier = Modifier
) {
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screen.Home> {
                HomeScreen(
                    onNavigate = { key ->
                        backStack.add(key)
                    }
                )
            }
            entry<Screen.Sample1> {
                Sample1Screen(
                    onNavigateBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
            entry<Screen.Sample2> {
                Sample2Screen(
                    onNavigateBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        },
        modifier = modifier
    )
}