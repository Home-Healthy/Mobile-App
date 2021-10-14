package com.acme.homehealthy.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.acme.homehealthy.data.models.Diet
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.data.models.Training
import com.acme.homehealthy.data.models.User
import com.acme.homehealthy.screens.composableScreens.MainAutenticationBox
import com.acme.homehealthy.screens.composableScreens.MainDietDetailScreen
import com.acme.homehealthy.screens.composableScreens.dietScreen
import com.acme.homehealthy.screens.composableScreens.profileScreen

@ExperimentalFoundationApi
@Composable
fun Navigation(_routines: List<Routine>, _trainings: List<Training>, _diets: List<Diet>, user: User){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(_routines , _trainings , navController)

        }

        composable(route = Screen.DietScreen.route){
            dietScreen(navController)
        }

        composable(route = Screen.ProfileScreen.route){
            profileScreen(user)
        }

        composable(route = Screen.AuthScreen.route){
            MainAutenticationBox(navController)
        }

        composable(route = Screen.DietDetailScreen.route + "/{name}", arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "Monday"
                nullable = false
            }
        )) { entry ->
            MainDietDetailScreen(dayOfWekk = entry.arguments?.getString("name"), _diets, navController)
        }
    }
}