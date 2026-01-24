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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.seabat.android.samplecanvas.ui.components.SimpleBarChart

/**
 * Sample 1 Screen
 *
 * see. https://medium.com/@androidlab/build-stunning-data-dashboards-in-jetpack-compose-a-complete-guide-to-charts-visualization-7ef00a8bd62b
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sample1Screen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample 1") },
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
                text = "Sample 1 Screen",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "これはサンプル1の画面です",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            SimpleBarChart(
                data = listOf(10f, 20f, 15f, 30f, 25f, 40f, 35f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Sample1ScreenPreview() {
    Sample1Screen(
        onNavigateBack = {}
    )
}