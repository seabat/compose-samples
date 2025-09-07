package dev.seabat.android.sampleanimation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.seabat.android.sampleanimation.ui.components.ElasticSearchBar



/**
 * Sample 5 Screen
 *
 * see. https://medium.com/@hiren6997/10-jetpack-compose-animations-that-will-wow-your-users-6dda5342a567
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sample5Screen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample 5") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Sample 5 Screen",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "これはサンプル5の画面です",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            ElasticSearchBar()
            
            Spacer(modifier = Modifier.weight(1f))
        }
    }
} 