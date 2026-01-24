package dev.seabat.android.samplecanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateListOf
import dev.seabat.android.samplecanvas.ui.navigation.MainNavGraph
import dev.seabat.android.samplecanvas.ui.navigation.Screen
import dev.seabat.android.samplecanvas.ui.theme.SampleCanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleCanvasTheme {
                val backStack = remember { mutableStateListOf<Screen>(Screen.Home) }
                MainNavGraph(
                    backStack = backStack,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}