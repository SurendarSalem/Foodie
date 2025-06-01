package com.example.foodie.android

// NavigationStack.kt
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationStack(prefs: SharedPreferences, editor: SharedPreferences.Editor) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            LoginScreen(navController = navController, editor)
        }
        composable(route = Screen.Detail.route) {
            SignUpScreen(navController = navController)
        }
    }
}

// Screen.kt
sealed class Screen(val route: String) {
    object Main: Screen("main_screen")
    object Detail: Screen("detail_screen")
}