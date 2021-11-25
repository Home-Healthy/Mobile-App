package com.acme.homehealthy.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.acme.homehealthy.data.models.*
import com.acme.homehealthy.screens.composableScreens.*
import com.acme.homehealthy.utils.presentation.AuthScreen
import com.acme.homehealthy.utils.presentation.GoogleSignInButtonUi
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Navigation(_routines: List<Routine>, _trainings: List<Training>, _diets: List<Diet>, user: User){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AuthScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(_routines , _trainings , navController)

        }

        composable(route = Screen.DietScreen.route){
            dietScreen(navController)
        }

        composable(route = Screen.ProfileScreen.route){
            profileScreen(user, navController)
        }

        composable(route = Screen.AuthScreen.route){
            //MainAutenticationBox(navController)
            /*GoogleSignInButtonUi() {
                navController.navigate(Screen.MainScreen.route)
            }*/
            AuthScreen(authViewModel = AuthVIewModel(), _routines = _routines, _trainings =_trainings , navController = navController)
        }
        composable(route = Screen.SplashScreen.route){
            splashScreen(navController)
        }
        composable(route= Screen.RoutineDetailScreen.route + "{name}", arguments = listOf(
            navArgument("name"){
                type = NavType.StringType
                defaultValue = "CHEAST"
                nullable = false
            }
        )){
            entry ->
            entry.arguments?.getString("name")?.let { RoutineDetailScreen(navController = navController, bodyPart = it) }
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