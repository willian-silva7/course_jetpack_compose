package com.fibp.newprojects.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun MyLaunchedEffect(modifier: Modifier = Modifier, onFinished: () -> Unit, email: String) {
    var timeEffect by remember { mutableIntStateOf(2) }

    LaunchedEffect(timeEffect) {
        if (timeEffect > 0) {
            delay(1000)
            timeEffect--
        } else {
            onFinished()
        }
    }
    
    MyDialog(showDialog = if (timeEffect > 0) true else false, email = email)
}