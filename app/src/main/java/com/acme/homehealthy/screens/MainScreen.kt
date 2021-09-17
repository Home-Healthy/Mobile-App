package com.acme.homehealthy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acme.homehealthy.ui.theme.DeepBlue
import com.acme.homehealthy.ui.theme.Rose

@Composable
fun MainScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize())
    {
        Column() {

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
                color = Rose
            )

        }

    }
}


