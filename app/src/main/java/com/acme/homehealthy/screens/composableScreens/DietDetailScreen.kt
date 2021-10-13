package com.acme.homehealthy.screens.composableScreens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.acme.homehealthy.data.models.Diet

@Composable
fun MainDietDetailScreen(dayOfWekk: String?, _diets: List<Diet>){
    Text(text = dayOfWekk!!)
}