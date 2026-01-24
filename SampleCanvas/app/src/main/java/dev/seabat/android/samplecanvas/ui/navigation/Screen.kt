package dev.seabat.android.samplecanvas.ui.navigation

// Navigation 3 のキー定義
sealed interface Screen {
    data object Home : Screen
    data object Sample1 : Screen
    data object Sample2 : Screen
}