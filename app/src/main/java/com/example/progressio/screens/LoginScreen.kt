package com.example.progressio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.progressio.components.CustomRoundedTextField
import com.example.progressio.components.GradientBox
import com.example.progressio.components.PasswordOutlinedTextField
import com.example.progressio.components.isSmallScreenHeight

@Composable
fun LoginScreen(){
    GradientBox(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.35f),
                contentAlignment = Alignment.Center

            ){
                Text(
                    text = "Logo Here",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
                    .background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //spacing according to screen size
                if (isSmallScreenHeight()){
                    Spacer(modifier = Modifier.fillMaxSize(0.05f))
                }else{
                    Spacer(modifier = Modifier.fillMaxSize(0.1f))
                }
                //--------
                Text(
                    text = "Sign In",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black
                )
                //spacing according to screen size
                if (isSmallScreenHeight()){
                    Spacer(modifier = Modifier.fillMaxSize(0.05f))
                }else{
                    Spacer(modifier = Modifier.fillMaxSize(0.1f))
                }
                //--------
                CustomRoundedTextField(fieldValue = "Email") {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "Email Icon"
                    )

                }

                PasswordOutlinedTextField(fieldValue = "Password") {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = "Password Icon"
                    )

                }

            }

        }

    }
}