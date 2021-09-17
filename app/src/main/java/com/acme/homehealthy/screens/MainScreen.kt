package com.acme.homehealthy.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.data.models.Training
import com.acme.homehealthy.ui.theme.*


@Composable
fun MainScreen(_routines: List<Routine>, _trainings: List<Training>) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    )
    {
        Column() {
            Greetings(name = "Guapeton")
            RoutinesList(routines = _routines)

            TrainingList(trainings = _trainings)
        }
    }

}


@Composable
fun Greetings(name: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
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
fun RoutinesList(routines: List<Routine>) {
    LazyRow() {
        items(routines) { routine ->
            RoutinesRow(routine)
        }
    }
}


@Composable
fun RoutinesRow(routines: Routine) {

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


@Composable
fun trainingsView(trainings: Training) {
    var imgUrl : String
    if(trainings.id == 1L){
        imgUrl = "https://elcomercio.pe/resizer/czgVq4F-823qxacsPteSJCzm0M8=/980x0/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/ULW4UUDPXJBU7GEARPRFLEWSYU.jpg"
    }
    else if (trainings.id == 2L){
        imgUrl = "https://i0.wp.com/once.pe/wp-content/uploads/2021/01/cuto-dice-su-verdad-e1612117753484.jpg"
    }
    else{
        imgUrl = "https://cdn.futbolperuano.com/sdi/2018/09/27/juan-vargas-se-defendio-de-las-criticas-sobre-su-peso-674355.jpg"
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 15.dp, top = 40.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Transparent)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(cardNight)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(
                    data = imgUrl
                ),
                contentDescription = trainings.name,
                modifier = Modifier
                    .size(200.dp, 120.dp)
                    .clip(RoundedCornerShape(25.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(cardNight)
                    .padding(bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = trainings.name,
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = trainings.description,
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

            }
        }
    }
}



@Composable
fun TrainingList(trainings: List<Training>) {
    LazyColumn() {
        items(trainings) { training ->
            trainingsView(training)
        }
    }
}


