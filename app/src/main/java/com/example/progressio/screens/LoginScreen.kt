package com.example.progressio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.progressio.components.ClickableText
import com.example.progressio.components.CustomRoundedTextField
import com.example.progressio.components.GradientBox
import com.example.progressio.components.GradientButton
import com.example.progressio.components.PasswordOutlinedTextField
import com.example.progressio.components.isSmallScreenHeight
import com.example.progressio.firebase.FirebaseViewModel
import com.example.progressio.navigation.Screen
import com.example.progressio.ui.theme.Blue
import com.example.progressio.ui.theme.Tail600

@Composable
fun LoginScreen(
    navController: NavController,
    vm : FirebaseViewModel
){
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var emailError by remember{ mutableStateOf(false) }
    var passwordError by remember{ mutableStateOf(false)}
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
                Image(imageVector = Icons.Rounded.Image, contentDescription = "Logo here" )
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
                if(emailError){
                    Text(
                        text = "Enter Email",
                        color = Color.Red
                    )
                }
                email = CustomRoundedTextField(fieldValue = "Email") {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "Email Icon"
                    )

                }
                if(passwordError){
                    Text(
                        text = "Enter Password",
                        color = Color.Red
                    )
                }

                password = PasswordOutlinedTextField(fieldValue = "Password") {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = "Password Icon"
                    )

                }
                GradientButton(text = "Sign In", textColor = Color.White , gradient = Brush.horizontalGradient(colors = listOf(Blue, Tail600)), onClick = {
                    if (email.isNotEmpty()){
                        emailError = false
                        if (password.isNotEmpty()){
                            passwordError = false
                            vm.login(email, password)
                        }else{
                            passwordError = true
                        }
                    }else{
                        emailError = true
                    }

                } )
                if (vm.signedIn.value){
                    navController.navigate(route = Screen.Home.route)
                }
                vm.signedIn.value = false


                Row (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(text = "Don't have an account yet? ")
                    ClickableText(text = "Sign Up.") {
                        navController.navigate(route = Screen.SignUp.route)
                    }
                }

            }

        }

    }
}