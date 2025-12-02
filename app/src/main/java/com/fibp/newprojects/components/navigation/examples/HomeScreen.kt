package com.fibp.newprojects.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.fibp.newprojects.components.MyLaunchedEffect
import com.fibp.newprojects.components.layout.MyAdvanceList
import com.fibp.newprojects.components.layout.MyGridList
import com.fibp.newprojects.components.layout.MyNavigationBar
import com.fibp.newprojects.components.layout.MyToAppBar
import com.fibp.newprojects.components.layout.ScrollList

@Composable
fun HomeScreen(email: String) {
    val navController = rememberNavController()
    // Guarda o índice selecionado (0 = Home, 1 = Map, 2 = Help)
    var selectedIndex by remember { mutableIntStateOf(0) }

    MyLaunchedEffect(email = email, onFinished = {})
    Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyToAppBar()},
                    bottomBar = {
                        MyNavigationBar(
                            navController = navController,
                            selectedIndex = selectedIndex,
                            onItemSelected = { index -> selectedIndex = index }
                        )
                    }
                ) {innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
                        when (selectedIndex) {
                            0 -> ScrollList(modifier = Modifier)
                            1 -> MyGridList(modifier = Modifier)
                            2 -> MyAdvanceList(modifier = Modifier)
                        }
                    }
                }
}