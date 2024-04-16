package com.example.progressio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.CircularProgressIndicator
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
fun SignUpScreen(
    navController: NavController,
    vm: FirebaseViewModel
){
    var username by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var usernameError by remember{ mutableStateOf(false) }
    var emailError by remember{ mutableStateOf(false) }
    var passwordError by remember{ mutableStateOf(false) }
    var passwordLength by remember{ mutableStateOf(false) }


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
                if (vm.inProgress.value){
                    CircularProgressIndicator()
                }
                //spacing according to screen size
                if (isSmallScreenHeight()){
                    Spacer(modifier = Modifier.fillMaxSize(0.05f))
                }else{
                    Spacer(modifier = Modifier.fillMaxSize(0.1f))
                }
                //--------
                Text(
                    text = "Create New Account",
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
                if(usernameError){
                    Text(
                        text = "Enter Username",
                        color = Color.Red
                    )
                }
                username = CustomRoundedTextField(fieldValue = "Username") {
                    Icon(
                        Icons.Rounded.Person,
                        contentDescription = "Username Icon"
                    )

                }
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

                if(passwordLength){
                    Text(
                        text = "Password must be at least 8 characters",
                        color = Color.Red
                    )
                }

                password = PasswordOutlinedTextField(fieldValue = "Password") {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = "Password Icon"
                    )

                }
                GradientButton(text = "Sign Up", textColor = Color.White , gradient = Brush.horizontalGradient(colors = listOf(Blue, Tail600)), onClick = {
                    if (email.isNotEmpty()){
                        emailError = false
                        if (password.isNotEmpty()){
                            passwordError = false
                            if (username.isNotEmpty()){
                                usernameError = false
                                vm.onSignUp(email, password)
                            }else{
                                usernameError = true
                            }
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
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(text = "Already Have an account? ")
                    ClickableText(text = "Sign In.") {
                        navController.navigate(route = Screen.Login.route)

                    }
                }

            }

        }

    }
}

