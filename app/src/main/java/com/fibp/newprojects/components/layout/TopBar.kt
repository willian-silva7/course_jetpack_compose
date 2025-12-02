package com.fibp.newprojects.components.layout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.fibp.newprojects.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToAppBar() {
    TopAppBar(title = { Text(text = "My App")}, navigationIcon = { Icon(
        painter = painterResource(id = R.drawable.ic_help_outlined),
        contentDescription = "",
    )}, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Gray, titleContentColor = Color.Yellow))
}