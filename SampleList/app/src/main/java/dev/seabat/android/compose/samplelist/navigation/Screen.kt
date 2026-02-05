package dev.seabat.android.compose.samplelist.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object LazyVerticalGrid : Screen("LazyVerticalGrid")
    object StaggeredGrid : Screen("StaggeredGrid")
    object FlowRow : Screen("FlowRow")
    object AnimateExpandableList : Screen("AnimateExpandableList")
    object StickyHeader : Screen("StickyHeader")

    /** ホーム画面から遷移可能なサンプル画面一覧（Home 除く）。追加・削除すると HomeScreen のボタンが自動で増減する。 */
    companion object {
        val sampleScreens: List<Screen> = listOf(
            LazyVerticalGrid,
            StaggeredGrid,
            FlowRow,
            AnimateExpandableList,
            StickyHeader
        )
    }
}