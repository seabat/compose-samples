package dev.seabat.android.compose.samplelist.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sample2Screen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Staggered Grid") },
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
        CustomStaggeredGrid(
            items = (1..40).map { "Item $it" },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun CustomStaggeredGrid(
    items: List<String>,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        val column1 = items.filterIndexed { index, _ -> index % 2 == 0 }
        val column2 = items.filterIndexed { index, _ -> index % 2 != 0 }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(column1) {
                Card(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                    Text(text = it, modifier = Modifier.padding(16.dp))
                }
            }
        }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(column2) {
                Card(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                    Text(text = it, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun Sample2ScreenPreview() {
    Sample2Screen(onNavigateBack = {})
}