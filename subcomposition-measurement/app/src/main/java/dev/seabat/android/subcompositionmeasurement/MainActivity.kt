package dev.seabat.android.subcompositionmeasurement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.seabat.android.subcompositionmeasurement.ui.theme.SubcompositionMeasurementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SubcompositionMeasurementTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SameWithItemsRow(
                        modifier = Modifier.padding(innerPadding),
                        items = listOf(
                            {
                                Text(text = "Madrid", textAlign = TextAlign.Center)
                            },
                            {
                                Box(
                                    modifier = Modifier
                                        .background(Color.Blue)
                                        .size(60.dp)
                                )
                            },
                            {
                                Text(text = "Barcelona", textAlign = TextAlign.Center)
                            },
                            {
                                Box(
                                    modifier = Modifier
                                        .background(Color.Green)
                                        .size(50.dp)
                                )
                            },
                            {
                                Text(text = "Bilbao", textAlign = TextAlign.Center)
                            },
                            {
                                Box(
                                    modifier = Modifier
                                        .background(Color.Red)
                                        .size(40.dp)
                                )
                            },
                            {
                                Text(text = "Sevilla", textAlign = TextAlign.Center)
                            },
                            {
                                Box(
                                    modifier = Modifier
                                        .background(Color.Red)
                                        .size(50.dp)
                                )
                            },
                            {
                                Text(text = "Valencia", textAlign = TextAlign.Center)
                            },
                            {
                                Box(
                                    modifier = Modifier
                                        .background(Color.Red)
                                        .size(60.dp)
                                )
                            }
                        )
                    )
                }
            }
        }
    }
}