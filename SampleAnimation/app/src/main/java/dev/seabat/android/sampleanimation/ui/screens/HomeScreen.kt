package dev.seabat.android.sampleanimation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import dev.seabat.android.sampleanimation.ui.navigation.Screen
import dev.seabat.android.sampleanimation.ui.theme.SampleAnimationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToSample: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample Animation") }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "サンプル画面一覧",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample1.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 1")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample2.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 2")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample3.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 3")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample4.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 4")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample5.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 5")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample6.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 6")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample7.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 7")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample8.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 8")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample9.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 9")
            }
            
            Button(
                onClick = { onNavigateToSample(Screen.Sample10.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 10")
            }

            Button(
                onClick = { onNavigateToSample(Screen.Sample11.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample 11")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SampleAnimationTheme {
        HomeScreen(onNavigateToSample = {})
    }
}