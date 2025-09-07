package dev.seabat.android.subcompositionmeasurement

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFold
import dev.seabat.android.subcompositionmeasurement.ui.theme.SubcompositionMeasurementTheme

/**
 * コンポーザブル関数のリストを等間隔で横に並べて表示するコンポーザブル関数。
 *
 * @param items
 * @param modifier
 */
@Composable
fun SameWithItemsRow(
    items: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    SubcomposeLayout(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .then(modifier)
    ) { constraints ->

        // List<Measurable> を生成する
        val measurables = items.flatMapIndexed { index, item ->
            subcompose(slotId = index) { item() }
        }

        // List<Measurable> のなかでの最大幅を持つアイテムの最大幅を算出する
        val maxWidth = measurables.fastFold(initial = 0) { max, curr ->
            maxOf(curr.maxIntrinsicWidth(constraints.maxHeight), max)
        }

        // List<Placeable> を生成する
        val placeables = measurables.map {
            it.measure(
                constraints.copy(
                    minWidth = maxWidth,
                    maxWidth = maxWidth
                )
            )
        }

        // List<Measurable> の全アイテムの幅を足すことで、全体の幅を算出する
        val layoutWidth = placeables.sumOf { placeable -> placeable.width }
        // List<Measurable> の最大の高さを算出する
        val layoutHeight = placeables.maxOf { placeable -> placeable.height }

        layout(width = layoutWidth, height = layoutHeight) {
            var x = 0
            placeables.forEach { placeable ->
                // List<Placeable> を相対位置に配置していく
                placeable.placeRelative(x = x, y = 0)
                x += placeable.width
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun SameWithItemsRowPreview() {
    SubcompositionMeasurementTheme {
        Surface {
            SameWithItemsRow(items = listOf(
                {
                    Text(text = "Madrid", textAlign = TextAlign.Center)
                },
                {
                    Box(
                        modifier = Modifier
                            .background(Color.Blue)
                            .size(60.dp)
                    )
                },
                {
                    Text(text = "Barcelona", textAlign = TextAlign.Center)
                },
                {
                    Box(
                        modifier = Modifier
                            .background(Color.Green)
                            .size(50.dp)
                    )
                },
                {
                    Text(text = "Bilbao", textAlign = TextAlign.Center)
                },
                {
                    Box(
                        modifier = Modifier
                            .background(Color.Red)
                            .size(40.dp)
                    )
                },
                {
                    Text(text = "Sevilla", textAlign = TextAlign.Center)
                },
                {
                    Box(
                        modifier = Modifier
                            .background(Color.Red)
                            .size(50.dp)
                    )
                },
                {
                    Text(text = "Valencia", textAlign = TextAlign.Center)
                },
                {
                    Box(
                        modifier = Modifier
                            .background(Color.Red)
                            .size(60.dp)
                    )
                }
            ))
        }
    }
}