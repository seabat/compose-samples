package dev.seabat.android.sampleanimation.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * see. https://medium.com/@hiren6997/10-jetpack-compose-animations-that-will-wow-your-users-6dda5342a567
 */
@Composable
fun ElasticSearchBar() {
    var expanded by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    // targetValue の変更がアニメーションのトリガーとなる。
    // 現在の値から新しいtargetValueの値に向かってアニメーションが開始される。
    // 新しいtargetValueの値へは animationSpec に従って変化する。
    //     dampingRatio: バウンスの強さ（値が小さいほどバウンスが強い）
    //     stiffness: アニメーションの速度（値が大きいほど速い）
    //
    // 上記を踏まえ、width は以下の値をとる
    // 展開時：
    //   48dpから開始
    //   300dpに向かって加速
    //   300dpを少し超える（例：320dp）
    //   300dpに戻る
    //   最終的に300dpで安定
    // 縮小時：
    //   300dpから開始
    //   48dpに向かって加速
    //   48dpを少し下回る（例：30dp）
    //   48dpに戻る
    //   最終的に48dpで安定
    //
    // ※ バウンスは、目標値に到達した後、少し戻ってから再び目標値に収束する動きのこと
    val width by animateDpAsState(
        targetValue = if (expanded) 300.dp else 48.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    
    Box(
        modifier = Modifier
            .width(width)
            .height(48.dp)
            .background(
                MaterialTheme.colorScheme.surface,
                RoundedCornerShape(24.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                RoundedCornerShape(24.dp)
            )
    ) {
        if (!expanded) {
            IconButton(
                onClick = { expanded = true },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        } else {
            // NOTE: TextField はコンポーネントないの padding が大きすぎるので BasicTextField を採用
            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (searchText.isEmpty()) {
                            Text(
                                text = "Search...",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                        innerTextField()
                    }
                }
            )
            
            IconButton(
                onClick = { 
                    expanded = false
                    searchText = ""
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
        }
    }
}
