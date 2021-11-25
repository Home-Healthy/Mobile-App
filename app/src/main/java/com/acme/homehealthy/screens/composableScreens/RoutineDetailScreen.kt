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
import androidx.navigation.NavController
import com.acme.homehealthy.data.models.RoutineDetail
import com.acme.homehealthy.ui.theme.Strength
import com.acme.homehealthy.ui.theme.TransparentBlack
import com.acme.homehealthy.ui.theme.WheightLose
import com.acme.homehealthy.ui.theme.hypertrophy

@Composable
fun RoutineDetailScreen(navController: NavController, bodyPart: String, routineDetailList: List<RoutineDetail>){
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
            FoodStats(valueStat = 96, color = hypertrophy, statName = "Hypertrofphy")
            Spacer(modifier = Modifier.height(25.dp))
            FoodStats(valueStat = 30, color = Strength, statName = "Strengh")
            Spacer(modifier = Modifier.height(25.dp))
            FoodStats(valueStat = 80, color = WheightLose, statName = "Wheight Loss")
        }
    }
}