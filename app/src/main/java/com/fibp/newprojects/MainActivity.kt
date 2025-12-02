package com.fibp.newprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.fibp.newprojects.components.navigation.NavigationWrapper
import com.fibp.newprojects.ui.theme.NewProjectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewProjectsTheme {

                NavigationWrapper()
                // A surface container using the 'background' color from the theme
                /*Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyToAppBar()},
                    bottomBar = { MyNavigationBar() }
                ) {innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
//                        Text(text = "Main text", color = Color.Yellow)
                        ScrollList(modifier = Modifier)
                    }
                }*/
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
@Composable
fun GreetingPreview() {
    NewProjectsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

        }
    }
}