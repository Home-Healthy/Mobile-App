package com.acme.homehealthy.screens.composableScreens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MainDietDetailScreen(dayOfWekk: String?){
    Text(text = dayOfWekk!!)
}