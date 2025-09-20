package dev.seabat.android.compose.samplelist.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Sample1 : Screen("LazyVerticalGrid")
    object Sample2 : Screen("StaggeredGrid")
    object Sample3 : Screen("sample3")
}