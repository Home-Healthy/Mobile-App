package com.acme.homehealthy.screens.composableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.acme.homehealthy.R
import com.acme.homehealthy.ui.theme.TransparentBlack

@Composable
fun MainAutenticationBox() {
    Box (
        modifier = Modifier
            .background(color = TransparentBlack)
            ){
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.a),
                contentDescription = "Google button",
                tint = Color.Unspecified
            )
            Text(text = "Sign In with Google")
        }
    }
}