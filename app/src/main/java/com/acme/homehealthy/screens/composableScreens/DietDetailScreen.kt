package com.acme.homehealthy.screens.composableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.acme.homehealthy.R
import com.acme.homehealthy.data.models.Diet
import com.acme.homehealthy.screens.Screen
import com.acme.homehealthy.screens.trainingsView
import com.acme.homehealthy.ui.theme.Gray
import com.acme.homehealthy.ui.theme.TransparentBlack
import com.acme.homehealthy.ui.theme.text
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MainDietDetailScreen(dayOfWekk: String?, _diets: List<Diet>, navController: NavController) {
    Box() {

        dietList(_diets, dayOfWekk!!, navController)
    }
}


@Composable
fun dietList(diets: List<Diet>, day: String, navController: NavController) {
    for (diet in diets) {
        if (diet.day == day) {
            fietRow(diet, day, navController)
        }
    }

}

@Composable
fun fietRow(diet: Diet, day: String, navController: NavController) {
    Box(
        modifier = Modifier
            .background(Gray)
            .padding(20.dp)
            .clip(RoundedCornerShape(25.dp))
            .clipToBounds()
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.backicon),
            contentDescription = "sdsdsd",
            modifier = Modifier.clickable {
                navController.navigate(Screen.DietScreen.route)
            }
                .width(40.dp)
                .height(40.dp)
                .background(Color.White)
        )
        Text(text = day)
        Box(
            modifier = Modifier
                .background(TransparentBlack)
                .fillMaxSize()
        ) {
            Column {
                Row() {
                    GlideImage(
                        imageModel = diet.breakfastImg, modifier = Modifier
                            .size(200.dp, 120.dp)
                    )
                    Text(text = diet.breackfast)
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Row() {
                    GlideImage(
                        imageModel = diet.lunchImg, modifier = Modifier
                            .size(200.dp, 120.dp)
                    )
                    Text(text = diet.lunch)
                }
                Spacer(modifier = Modifier.height(25.dp))
                Row() {
                    GlideImage(
                        imageModel = diet.dinnerImg, modifier = Modifier
                            .size(200.dp, 120.dp)
                    )
                    Text(text = diet.dinner)
                }
            }

        }
    }
}
