package dev.seabat.android.samplecanvas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.seabat.android.samplecanvas.ui.components.AnimatedPieChart
import dev.seabat.android.samplecanvas.ui.components.PieSegment

/**
 * Sample 2 Screen
 *
 * see. https://medium.com/@androidlab/build-stunning-data-dashboards-in-jetpack-compose-a-complete-guide-to-charts-visualization-7ef00a8bd62b
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sample2Screen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample 2") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "戻る"
                        )
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Sample 2 Screen",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "これはサンプル2の画面です",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            AnimatedPieChart(
                segments = listOf(
                    PieSegment(color = Color(0xFF6200EE), percentage = 0.3f),
                    PieSegment(color = Color(0xFF03DAC5), percentage = 0.2f),
                    PieSegment(color = Color(0xFFFF6B6B), percentage = 0.25f),
                    PieSegment(color = Color(0xFFFFD93D), percentage = 0.15f),
                    PieSegment(color = Color(0xFF6BCF7F), percentage = 0.1f)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Sample2ScreenPreview() {
    Sample1Screen(
        onNavigateBack = {}
    )
}