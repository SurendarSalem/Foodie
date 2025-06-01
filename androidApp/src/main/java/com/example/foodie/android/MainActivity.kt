package com.example.foodie.android

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by inject()
    private val prefs: SharedPreferences by inject()
    private val editor: SharedPreferences.Editor by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        val isLoggedIn = prefs.getBoolean("isLoggedIn", false)
        enableEdgeToEdge()
        splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }
        splashScreen.setOnExitAnimationListener {
            it.remove()
            setContent {
                if (isLoggedIn) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    MyApplicationTheme {
                        NavigationStack(prefs, editor)
                    }
                }
            }
        }
    }

}