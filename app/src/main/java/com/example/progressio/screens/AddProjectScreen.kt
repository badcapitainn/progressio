package com.example.progressio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.rounded.AppRegistration
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.progressio.R
import com.example.progressio.components.CustomCheckBox
import com.example.progressio.components.CustomRoundedTextField
import com.example.progressio.components.TopBar
import com.example.progressio.navigation.Screen
import com.example.progressio.ui.theme.Blue
import com.example.progressio.ui.theme.LimeGreen
import com.example.progressio.ui.theme.Orange
import com.example.progressio.ui.theme.Tail600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProjectScreen(
    navController: NavController
) {
    var highPriority by remember {
        mutableStateOf(false)
    }
    var mediumPriority by remember {
        mutableStateOf(false)
    }
    var lowPriority by remember {
        mutableStateOf(false)
    }

    val scrollState = rememberScrollState()
    val datePickerState = rememberDatePickerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .scrollable(scrollState, orientation = Orientation.Vertical)
    ) {
        TopBar(
            menuOnClick = {navController.popBackStack()},
            notificationOnClick = {},
            profileOnClick = {},
            text = "Add Project",
            firstIcon = Icons.Rounded.ArrowBackIosNew
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.20f),
            contentAlignment = Alignment.Center

        ){
            Image(modifier = Modifier.size(80.dp), painter = painterResource(id = R.drawable.archive), contentDescription = "" )
        }
        CustomRoundedTextField(fieldValue = "Project Name") {
            Icon(
                Icons.Rounded.Book,
                contentDescription = "Email Icon"
            )

        }
        CustomRoundedTextField(fieldValue = "Description") {
            Icon(
                Icons.Rounded.AppRegistration,
                contentDescription = "Email Icon"
            )

        }
        Box(
            modifier = Modifier
                .padding(16.dp)

        ){
            Column {
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = "Priority:",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CustomCheckBox(checked = highPriority) {
                        highPriority = it
                    }
                    Text(
                        text = "High",
                        modifier = Modifier.padding(start = 5.dp, end = 20.dp, top = 20.dp, bottom = 0.dp),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Red

                    )

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CustomCheckBox(checked = mediumPriority) {
                        mediumPriority = it
                    }
                    Text(
                        text = "Medium",
                        modifier = Modifier.padding(start = 5.dp, end = 20.dp, top = 20.dp, bottom = 0.dp),
                        fontWeight = FontWeight.SemiBold,
                        color = Orange

                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CustomCheckBox(checked = lowPriority) {
                        lowPriority = it
                    }
                    Text(
                        text = "Low",
                        modifier = Modifier.padding(start = 5.dp, end = 20.dp, top = 20.dp, bottom = 0.dp),
                        fontWeight = FontWeight.SemiBold,
                        color = LimeGreen

                    )

                }
            }
        }
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "Due:",
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )

        DatePicker(state = datePickerState)

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            IconButton(
                modifier = Modifier
                    .padding(30.dp)
                    .shadow(30.dp, CircleShape)
                    .clip(RoundedCornerShape(50.dp))
                    .size(60.dp),
                onClick = {navController.navigate(Screen.AddProject.route)},
                colors = IconButtonDefaults.iconButtonColors(containerColor = Blue)
            ) {
                Icon(modifier = Modifier.size(20.dp), imageVector = Icons.Default.Save, contentDescription ="", tint = Tail600 )
            }
        }
    }
    
}

@Preview
@Composable
fun AddProjectScreenPreview() {
    val navController = rememberNavController()
    AddProjectScreen(navController = navController)
}