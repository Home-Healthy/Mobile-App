package com.acme.homehealthy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.acme.homehealthy.R
import com.acme.homehealthy.data.models.Routine
import com.acme.homehealthy.data.models.Training
import com.acme.homehealthy.resources.BotonNavContent
import com.acme.homehealthy.ui.theme.*
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun MainScreen(_routines: List<Routine>, _trainings: List<Training>, navController: NavController) {
    Box(
        modifier = Modifier
            .background(DeepBlack)
            .fillMaxSize()
    )
    {
        Column() {
            Greetings(name = "Guapeton")
            RoutinesList(routines = _routines)

            TrainingList(trainings = _trainings)
            Spacer(modifier = Modifier.height(26.dp))

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
            initialSelectedIndex = 0
        )
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
                style = MaterialTheme.typography.h4,
                color = Color.White
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
            .background(TransparentBlack)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column() {
            Text(
                text = routines.name,
                style = MaterialTheme.typography.h2,
                color = Color.LightGray
            )
            Text(
                text = routines.level,
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }


    }
}


@Composable
fun trainingsView(trainings: Training) {
    var imgUrl: String
    if (trainings.id == 1L) {
        imgUrl =
            "https://elcomercio.pe/resizer/czgVq4F-823qxacsPteSJCzm0M8=/980x0/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/ULW4UUDPXJBU7GEARPRFLEWSYU.jpg"
    } else if (trainings.id == 2L) {
        imgUrl =
            "https://i0.wp.com/once.pe/wp-content/uploads/2021/01/cuto-dice-su-verdad-e1612117753484.jpg"
    } else {
        imgUrl =
            "https://cdn.futbolperuano.com/sdi/2018/09/27/juan-vargas-se-defendio-de-las-criticas-sobre-su-peso-674355.jpg"
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
                .background(TransparentBlack)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*Image(
                painter = rememberImagePainter(
                    data = imgUrl
                ),
                contentDescription = trainings.name,
                modifier = Modifier
                    .size(200.dp, 120.dp)
                    .clip(RoundedCornerShape(25.dp))
            )*/
            GlideImage(
                imageModel = imgUrl,
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 1200),
                modifier = Modifier
                    .size(200.dp, 120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(TransparentBlack)
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


@Composable
fun BottomNav(
    items: List<BotonNavContent>,
    modifier: Modifier = Modifier,
    initialSelectedIndex: Int = 0,
    navController: NavController
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(navBar)
            .padding(15.dp)
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))

    ) {
        items.forEachIndexed { index, item ->
            BottomNavItem(
                item = item,
                isSelected = index == selectedItemIndex,
                navController

            ) {
                selectedItemIndex = index

            }
        }
    }
}

@Composable
fun BottomNavItem(
    item: BotonNavContent,
    isSelected: Boolean = false,
    navController: NavController,
    onItemClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            if(item.tittle=="Training"){
            navController.navigate(Screen.MainScreen.route)}
            else if (item.tittle == "Nutrition"){
            navController.navigate(Screen.DietScreen.route)}
            else if(item.tittle == "Profile"){
                navController.navigate(Screen.AuthScreen.route) }
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(if (isSelected) Purple700 else Color.Transparent)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.tittle,
                tint = if (isSelected) Rose else Color.White,
                modifier = Modifier
                    .size(20.dp)


            )
        }
        Text(
            text = item.tittle,
            color = if (isSelected) Rose else Color.White
        )

    }

}




