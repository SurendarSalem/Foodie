package com.example.foodie.android.di

import android.content.Context
import android.content.SharedPreferences
import com.example.foodie.android.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SplashViewModel() }
    single { getSharedPrefs(context = get()) }
    single { getSharedPrefs(context = get()).edit() }
}

fun getSharedPrefs(context: Context): SharedPreferences {
    return context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
}
