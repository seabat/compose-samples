package dev.seabat.android.sampleanimation.ui.components

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun SwipeableDismissCard(
    content: @Composable () -> Unit,
    onDismiss: () -> Unit
) {
    var offsetX by remember { mutableStateOf(0f) }
    val dismissThreshold = 200f
    
    LaunchedEffect(offsetX) {
        if (kotlin.math.abs(offsetX) > dismissThreshold) {
            onDismiss()
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    offsetX += delta
                }
            )
            .offset(x = offsetX.dp)
            .alpha(1f - (kotlin.math.abs(offsetX) / dismissThreshold).coerceIn(0f, 1f))
    ) {
        content()
    }
}
