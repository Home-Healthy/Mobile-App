package com.acme.homehealthy.screens

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object DietScreen: Screen("diet_screen")
    object ProfileScreen: Screen("profile_screen")
    object AuthScreen: Screen("auth_screen")


    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
