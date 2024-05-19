package com.example.progressio.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.progressio.components.TopBar
import com.example.progressio.navigation.Screen
import com.example.progressio.ui.theme.Blue
import com.example.progressio.ui.theme.Tail600

@Composable
fun ProjectScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ){
        TopBar(
            profileOnClick = {navController.navigate(route = Screen.Profile.route)},
            menuOnClick = {navController.popBackStack()},
            notificationOnClick = {},
            firstIcon = Icons.Rounded.ArrowBackIosNew,
            text = "Projects"
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            IconButton(
                modifier = Modifier
                    .padding(30.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .size(60.dp)
                    .shadow(30.dp),
                onClick = {navController.navigate(Screen.AddProject.route)},
                colors = IconButtonDefaults.iconButtonColors(containerColor = Blue)
            ) {
                Icon(modifier = Modifier.size(20.dp), imageVector = Icons.Default.Add, contentDescription ="", tint = Tail600 )
            }
        }

    }

}
@Preview
@Composable
fun ProjectScreenPreview() {
    val navController = rememberNavController()
    ProjectScreen(navController = navController)

}