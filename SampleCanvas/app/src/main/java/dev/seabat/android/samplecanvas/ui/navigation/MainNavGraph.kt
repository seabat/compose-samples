package dev.seabat.android.samplecanvas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay

@Composable
fun MainNavGraph(
    backStack: MutableList<Screen>,
    modifier: Modifier = Modifier
) {
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            homeEntryBuilder(
                onNavigate = { key ->
                    backStack.add(key)
                }
            )
            sampleEntryBuilder(
                onNavigateBack = {
                    backStack.removeLastOrNull()
                }
            )
        },
        modifier = modifier
    )
}