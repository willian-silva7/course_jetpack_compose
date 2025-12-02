package com.fibp.newprojects.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fibp.newprojects.components.navigation.examples.HomeScreen
import com.fibp.newprojects.components.navigation.examples.LoginScreen

/*@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login>{

        }
    }
}*/

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen { email ->
                navController.navigate("home/$email")
            }
        }

        composable("home/{email}") { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: "Usuário"
            HomeScreen(email = email)
        }
    }
}
