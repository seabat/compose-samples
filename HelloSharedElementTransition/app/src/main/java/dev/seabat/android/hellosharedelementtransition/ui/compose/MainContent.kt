package dev.seabat.android.hellosharedelementtransition.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.seabat.android.hellosharedelementtransition.ui.theme.HelloSharedElementTransitionTheme

@Composable
fun MainContent() {
    HelloSharedElementTransitionTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CoffeeListDetail(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    MainContent()
}