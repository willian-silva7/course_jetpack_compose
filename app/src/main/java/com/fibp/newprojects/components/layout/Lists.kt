package com.fibp.newprojects.components.layout

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fibp.newprojects.R
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun ScrollList(modifier: Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 10 }
    }
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd){
        LazyColumn(state = listState) {
            items(100){
                Text(text = "Item: $it" ,
                    modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = Color.Yellow
                )
            }
        }
        if (showButton) {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
//                    listState.animateScrollToItem(0)
                    listState.scrollToItem(0)
                }
            }, modifier = Modifier.padding(16.dp), containerColor = Color.Gray) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_up),
                    contentDescription = "",
                    tint = Color.Yellow,

                    )
            }
        }
    }
}


@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(List(100) {"Item número $it"})
    }
    val numbers = remember {
        mutableStateOf(List(50) { Random.nextInt(0, 6) })
    }
    var showView by remember {
        mutableStateOf(true)
    }

    val colors = listOf(
        Color(color = 0xFFF44336),
        Color(color = 0xFF4CAF50),
        Color(color = 0xFF9C27B0),
        Color(color = 0xFFCDDC39),
        Color(color = 0xFF3F51B5),
        Color(color = 0xFFFFC107),
        Color(color = 0xFF03A9F4),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(numbers.value) { randomNumber ->
            // Estado local para cada item
            var showView by remember { mutableStateOf(true) }
            AnimatedVisibility (showView, enter = scaleIn(), exit = scaleOut()) {
                Box(
                    modifier = Modifier.background(colors[randomNumber]).
                    clickable { if (randomNumber%2 == 0 && showView){ showView = !showView } },
                    contentAlignment = Alignment.Center
                ){

                    Text(text = randomNumber.toString(), color = Color.White, fontSize = 28.sp)
                }
            }
        }
    }
}


@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(List(100){"Item número $it"})
    }

    LazyColumn {
        itemsIndexed(items, key = {_, item -> item}){index, item ->
            Row {
                Text(text = item + "   indice: $index", color = Color.White)
                Spacer(modifier = Modifier.weight(1f))
                TextButton({
                    items = items.toMutableList().apply {
                        removeAt(index = index)
                    }
                }) {
                    Text(text = "Apagar")
                }
                Spacer(modifier = Modifier.width(24.dp))
            }
        }
    }
}