package dev.seabat.android.sampleanimation.ui.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 高さと背景色をアニメーションさせて小さなカードを大きなカードにする
 *
 * @param isExpanded
 * @param modifier
 */
@Composable
fun ExpandableCard(
    isExpanded: Boolean,
    modifier: Modifier = Modifier
) {
    val transition = updateTransition(targetState = isExpanded, label = "ExpandCard")

    val cardHeight by transition.animateDp(label = "height") { expanded ->
        if (expanded) 200.dp else 80.dp
    }

    val backgroundColor by transition.animateColor(label = "background") { expanded ->
        if (expanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    }

    val contentColor =
        if (isExpanded) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(if (isExpanded) "Expanded" else "Collapsed")
        }
    }
}

