package dev.seabat.android.sampleanimation.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StaggeredList(items: List<String>) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            var startAnimation by remember { mutableStateOf(false) }
            
            LaunchedEffect(Unit) {
                startAnimation = true
            }
            
            val animatedVisibility by animateFloatAsState(
                targetValue = if (startAnimation) 1f else 0f,
                animationSpec = tween(
                    durationMillis = 300,
                    delayMillis = index * 100
                ),
                label = "visibility_$index"
            )
            
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .alpha(animatedVisibility)
                    .offset(y = (50 * (1f - animatedVisibility)).dp)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

/**
 * Sample 4 Screen
 *
 * see. https://medium.com/@hiren6997/10-jetpack-compose-animations-that-will-wow-your-users-6dda5342a567
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sample4Screen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val sampleItems = listOf(
        "アイテム 1",
        "アイテム 2", 
        "アイテム 3",
        "アイテム 4",
        "アイテム 5",
        "アイテム 6",
        "アイテム 7",
        "アイテム 8"
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample 4") },
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sample 4 Screen",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "これはサンプル4の画面です",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
            )
            
            StaggeredList(items = sampleItems)
        }
    }
} 