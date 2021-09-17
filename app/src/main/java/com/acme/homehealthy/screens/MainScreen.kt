package com.acme.homehealthy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.ui.theme.*

@Composable
fun MainScreen(routines: List<Routine>){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize())
    {
        Column() {
            Greetings(name = "Guapeton")
            RoutinesList(routines = routines)
        }
    }

}


@Composable
fun Greetings(name: String){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good day, $name",
                style = MaterialTheme.typography.h2,
                color = textNight
            )

        }

    }
}


@Composable
fun RoutinesList(routines: List<Routine>){
    LazyRow(){
        items(routines){
            routine -> RoutinesRow(routine)
        }
    }
}


@Composable
fun RoutinesRow(routines: Routine){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Rose)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column() {
            Text(
                text = routines.name,
                style = MaterialTheme.typography.h2
            )
            Text(
                text = routines.level,
                style = MaterialTheme.typography.body1,
                color = Gray
            )
        }


    }
}



