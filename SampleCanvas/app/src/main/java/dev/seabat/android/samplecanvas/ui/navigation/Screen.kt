package dev.seabat.android.samplecanvas.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Sample1 : Screen("sample1")
}