package com.fibp.newprojects.components.layout

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fibp.newprojects.components.model.NavItem

@Composable
fun MyNavigationBar (
    modifier: Modifier = Modifier,
    navController: NavController,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    val itemList = listOf(
        NavItem("Home", Icons.Default.Home, "home"),
        NavItem("Map", Icons.Default.Star, "map"),
        NavItem("Help", Icons.Default.Info, "help"),
    )
//    var selectedIndex by remember { mutableIntStateOf(2) }

    NavigationBar (
        modifier = modifier,
        containerColor = Color.Black,
        tonalElevation = 10.dp
    ){
        itemList.forEachIndexed{ index, item ->
            AddedMenu(
                navItem = item,
                isSelected = index == selectedIndex
            ) {
                onItemSelected(index)
//                selectedIndex = index
                /*navController.navigate(item.route) {
                    popUpTo("home" ) {inclusive = false}
                    launchSingleTop = true
                }*/
            }
        }
    }
}

@Composable
fun RowScope.AddedMenu(navItem: NavItem, isSelected: Boolean, onItemClick: () -> Unit) {
    NavigationBarItem(
        selected = isSelected,
        label = { Text(text = navItem.name) },
        onClick = { onItemClick() },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Yellow,
            selectedTextColor = Color.Yellow,
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.White,
            indicatorColor = Color.Gray // Altera a cor da borda para azul
        ),
        icon = {
            Icon(
                imageVector = navItem.icon,
                contentDescription = navItem.name
            )
        }
    )
}