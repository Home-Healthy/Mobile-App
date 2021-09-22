package com.acme.homehealthy.screens.composableScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.acme.homehealthy.R
import com.acme.homehealthy.resources.BotonNavContent
import com.acme.homehealthy.screens.BottomNav
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun dietScreen(navController: NavController){
    Box(){

        Column() {
            GlideImage(imageModel = "https://statics-cuidateplus.marca.com/cms/dieta-ornish.jpg",
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 1200),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth())
        }
        BottomNav(
            items = listOf(
                BotonNavContent("Training", R.drawable.dumbbellfortraining_89135),
                BotonNavContent(
                    "Nutrition",
                    R.drawable.bodybuilding_nutrition_protein_fitness_diet_icon_149055
                ),
                BotonNavContent("Profile", R.drawable.profile_121261)
            ),
            modifier = Modifier.align(Alignment.BottomEnd),
            navController = navController,
            initialSelectedIndex = 1
        )
    }
}