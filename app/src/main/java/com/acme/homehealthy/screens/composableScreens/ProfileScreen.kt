package com.acme.homehealthy.screens.composableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.acme.homehealthy.ui.theme.DeepBlack
import com.acme.homehealthy.ui.theme.InerGreen
import com.acme.homehealthy.ui.theme.Rose
import com.acme.homehealthy.ui.theme.TransparentBlack
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun profileScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlack)
            .fillMaxSize()
    ) {
        profileDataSection()
    }
}


@Composable
fun profileDataSection() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 15.dp, top = 35.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Transparent)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
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
                imageModel = "https://800noticias.com/cms/wp-content/uploads/2019/08/Dwayne-Johnson.jpg",
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 1200),
                modifier = Modifier
                    .size(300.dp, 320.dp)
                    .clip(RoundedCornerShape(25.dp))
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
                    text = "asdsdsaddad",
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "asdsdsaddad",
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

            }
        }
    }
}