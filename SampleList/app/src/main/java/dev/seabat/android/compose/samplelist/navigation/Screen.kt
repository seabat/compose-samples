package dev.seabat.android.compose.samplelist.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object LazyVerticalGrid : Screen("LazyVerticalGrid")
    object StaggeredGrid : Screen("StaggeredGrid")
    object FlowRow : Screen("FlowRow")
    object AnimateExpandableList : Screen("AnimateExpandableList")
    object StickyHeader : Screen("StickyHeader")

}