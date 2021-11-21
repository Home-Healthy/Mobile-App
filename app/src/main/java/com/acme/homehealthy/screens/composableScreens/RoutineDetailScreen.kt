package com.acme.homehealthy.screens.composableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.acme.homehealthy.ui.theme.TransparentBlack

@Composable
fun RoutineDetailScreen(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
    ){
        RoutineGoals()
    }
}

@Composable
fun RoutineGoals(){
    Box(
        modifier = Modifier
            .background(Color.Black)
            .padding(top = 15.dp, start = 20.dp, end = 20.dp, bottom = 10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
    )
    {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(TransparentBlack)
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()
        ){
            FoodStats(valueStat = 96, color = Color.Red, statName = "HIpertrofy")
            Spacer(modifier = Modifier.height(25.dp))

            FoodStats(valueStat = 30, color = Color.Green, statName = "Strengh")
            Spacer(modifier = Modifier.height(25.dp))

            FoodStats(valueStat = 80, color = Color.Blue, statName = "Wheight Loss")


        }
    }
}