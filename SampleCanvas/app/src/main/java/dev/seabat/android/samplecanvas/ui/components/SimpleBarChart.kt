package dev.seabat.android.samplecanvas.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleBarChart(data: List<Float>) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    ) {
        val barWidth = size.width / data.size
        val maxValue = data.maxOrNull() ?: 1f

        data.forEachIndexed { index, value ->
            val barHeight = (value / maxValue) * size.height
            drawRect(
                color = Color(0xFF6200EE),
                topLeft = Offset(
                    x = index * barWidth + barWidth * 0.1f,
                    y = size.height - barHeight
                ),
                size = Size(
                    width = barWidth * 0.8f,
                    height = barHeight
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleBarChartPreview() {
    SimpleBarChart(
        data = listOf(10f, 20f, 15f, 30f, 25f, 40f, 35f)
    )
}