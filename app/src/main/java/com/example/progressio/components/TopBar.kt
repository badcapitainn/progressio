package com.example.progressio.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.progressio.R
import com.example.progressio.ui.theme.Blue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    menuOnClick: ()-> Unit,
    notificationOnClick: ()-> Unit,
    profileOnClick: ()-> Unit,
    firstIcon: ImageVector = Icons.Filled.Menu,
    text: String = stringResource(R.string.app_name),
    secondIcon: ImageVector = Icons.Filled.Notifications,
    thirdIcon: ImageVector = Icons.Filled.AccountCircle

) {
    TopAppBar(
        title = {
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = menuOnClick) {
                Icon(firstIcon, contentDescription = "", tint = Blue)
            }
        },
        actions = {
            IconButton(onClick = notificationOnClick) {
                Icon(secondIcon, contentDescription = "", tint = Blue)
            }
            IconButton(onClick = profileOnClick) {
                Icon(thirdIcon, contentDescription = "", tint = Blue)
            }
        }
    )
}
