package com.acme.homehealthy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.ui.theme.DeepBlue
import com.acme.homehealthy.ui.theme.Rose

@Composable
fun MainScreen(routines: List<Routine>){
    /*Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize())
    {
        Column() {
            routinesList(routines = routines)
        }
    }*/
    Scaffold {
        routinesList(routines = routines)
    }
}


/*@Composable
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
                color = Rose
            )

        }

    }
}
*/

@Composable
fun routinesList(routines: List<Routine>){
    LazyColumn(){
        items(routines){
            routine -> RoutineRow(routine)
        }
    }
}

@Composable
fun RoutineRow(routine: Routine){
    Card (
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        elevation = 5.dp
            ){
        Row (
            modifier = Modifier
                .padding(4.dp)
                ){
            Column {
                Text(
                    text =routine.name
                )

            }
        }

    }
}


