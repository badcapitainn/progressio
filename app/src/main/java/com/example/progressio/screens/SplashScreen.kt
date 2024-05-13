package com.example.progressio.screens

import android.window.SplashScreen
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.progressio.R
import com.example.progressio.navigation.Screen
import com.example.progressio.ui.theme.Blue
import com.example.progressio.ui.theme.Tail700
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavController
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    var alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 4000)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(route = Screen.Login.route)

    }
    Splash(alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Blue,
        targetValue = Tail700,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 1000
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    Box(
        modifier = Modifier
            .background(color)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        //Icon(modifier = Modifier.alpha(alpha), imageVector = Icons.Rounded.Image, contentDescription = "Logo here")
        Image(modifier = Modifier.alpha(alpha), painter = painterResource(id = R.drawable.mylogo), contentDescription = "mylogo")
    }
}