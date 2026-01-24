package dev.seabat.android.samplecanvas.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class PieSegment(
    val color: Color,
    val percentage: Float
)

@Composable
fun AnimatedPieChart(segments: List<PieSegment>) {
    var currentRotation by remember { mutableStateOf(0f) }

    LaunchedEffect(segments) {
        animate(
            initialValue = currentRotation,
            targetValue = currentRotation + 360f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        ) { value, _ ->
            currentRotation = value
        }
    }

    Canvas(modifier = Modifier.size(200.dp)) {
        var startAngle = currentRotation
        segments.forEach { segment ->
            drawArc(
                color = segment.color,
                startAngle = startAngle,
                sweepAngle = segment.percentage * 360f,
                useCenter = true
            )
            startAngle += segment.percentage * 360f
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedPieChartPreview() {
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