package com.acme.homehealthy.screens

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object DietScreen: Screen("diet_screen")
}
