package com.teamdue.educampapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.teamdue.educampapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun MainScreen(navController: NavController) {
    val viewModel = hiltViewModel<MainViewModel>()

    //Ui building
    ValueSurface(viewModel.ledStatus, viewModel)
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ValueSurface(stat: MutableStateFlow<Boolean>, viewModel: MainViewModel) {

    val isMock = booleanResource(id = R.bool.useMockEnv)
    val ledStatus = stat.asStateFlow().collectAsState()

    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(if (ledStatus.value) R.drawable.on else R.drawable.off),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        //If lamp is on, turn off
                        if (ledStatus.value)
                            viewModel.powerOff(isMock)
                        //If lamp is off, turn on
                        else
                            viewModel.powerOn(isMock)
                    }
            )

        }

    }
}