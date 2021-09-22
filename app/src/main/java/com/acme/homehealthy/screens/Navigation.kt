package com.acme.homehealthy.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.data.models.Training

@Composable
fun Navigation(_routines: List<Routine>, _trainings: List<Training>){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(_routines , _trainings , navController)
        }

        composable(route = Screen.DietScreen.route){}
    }
}