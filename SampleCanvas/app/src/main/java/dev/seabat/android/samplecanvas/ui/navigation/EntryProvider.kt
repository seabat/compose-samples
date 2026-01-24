package dev.seabat.android.samplecanvas.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import dev.seabat.android.samplecanvas.ui.screens.HomeScreen
import dev.seabat.android.samplecanvas.ui.screens.Sample1Screen
import dev.seabat.android.samplecanvas.ui.screens.Sample2Screen

/**
 * エントリビルダー関数
 * Navigation 3 のモジュール化パターンに従って、エントリ定義を分離
 */
fun EntryProviderScope<Screen>.homeEntryBuilder(
    onNavigate: (Screen) -> Unit,
) {
    entry<Screen.Home> {
        HomeScreen(
            onNavigate = onNavigate
        )
    }
}

fun EntryProviderScope<Screen>.sampleEntryBuilder(
    onNavigateBack: () -> Unit
) {
    entry<Screen.Sample1> {
        Sample1Screen(
            onNavigateBack = onNavigateBack
        )
    }
    entry<Screen.Sample2> {
        Sample2Screen(
            onNavigateBack = onNavigateBack
        )
    }
}