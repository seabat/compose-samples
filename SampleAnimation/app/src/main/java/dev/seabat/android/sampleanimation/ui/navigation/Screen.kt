package dev.seabat.android.sampleanimation.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Sample1 : Screen("sample1")
    object Sample2 : Screen("sample2")
    object Sample3 : Screen("sample3")
    object Sample4 : Screen("sample4")
    object Sample5 : Screen("sample5")
    object Sample6 : Screen("sample6")
    object Sample7 : Screen("sample7")
    object Sample8 : Screen("sample8")
    object Sample9 : Screen("sample9")
    object Sample10 : Screen("sample10")
} 