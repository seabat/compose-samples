package dev.seabat.android.expandablelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimateExpandableListScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Animate Expandable List") },
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
        AnimateExpandableList(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun AnimateExpandableList(
    modifier: Modifier = Modifier
) {
    val items =
        remember {
            List(20) { index ->
                ExpandableItem(
                    title = "Item #$index",
                    overview = "One common feature in many applications is an expandable list, " +
                        "where users can click on an item to show more information. " +
                        "This article will guide you through building an animated expandable " +
                        "list using LazyColumn in Jetpack Compose. We'll break down each " +
                        "component of the code, explore how state management works, " +
                        "and create a smooth, interactive experience."
                )
            }
        }
    val expandedStates =
        remember {
            mutableStateListOf(
                *BooleanArray(items.size) {
                    false
                }.toTypedArray()
            )
        }
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp),
        state = listState
    ) {
        itemsIndexed(items, key = { index, _ -> index }) { index, item ->
            ExpandableListItem(
                item = item,
                index = index,
                isExpanded = expandedStates[index],
                onExpandedChange = { expandedStates[index] = it }
            )
        }
    }
}
