package dev.seabat.android.sampleanimation.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShoppingCart(
    modifier: Modifier = Modifier
) {
    var itemCount by remember { mutableIntStateOf(0) }
    var shouldShake by remember { mutableStateOf(false) }

    val badgeScale by animateFloatAsState(
        targetValue = if (itemCount > 0) 1f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessHigh
        ),
        label = "badgeScale"
    )

    val cartShake = remember { Animatable(0f) }

    LaunchedEffect(shouldShake) {
        if (!shouldShake) return@LaunchedEffect

        cartShake.snapTo(0f)
        cartShake.animateTo(
            targetValue = 0f,
            animationSpec = keyframes {
                durationMillis = 300
                -5f at 50
                5f at 100
                -3f at 150
                3f at 200
                0f at 300
            }
        )
        shouldShake = false
    }

    Box(modifier = modifier) {
        IconButton(
            onClick = {
                itemCount++
                shouldShake = true
            },
            modifier = Modifier.offset(x = cartShake.value.dp)
        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
        }

        AnimatedVisibility(
            visible = itemCount > 0,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut(),
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Badge(modifier = Modifier.scale(badgeScale)) {
                Text("$itemCount")
            }
        }
    }
}

