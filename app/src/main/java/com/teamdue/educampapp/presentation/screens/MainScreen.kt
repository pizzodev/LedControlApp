package com.teamdue.educampapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.teamdue.educampapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun MainScreen(navController: NavController) {
    val viewModel = hiltViewModel<MainViewModel>()
    val stat = MutableStateFlow("")

    //Ui building
    ValueSurface(stat, viewModel)
}

@Composable
fun ValueSurface(stat: MutableStateFlow<String>, viewModel: MainViewModel) {

    val isMock = booleanResource(id = R.bool.useMockEnv)

    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.White)
    ) {
        Column() {
            Row() {
                Button(
                    onClick = {
                        viewModel.powerOn(stat, isMock)
                    },
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    Text("ON")
                }
                Button(
                    onClick = {
                        viewModel.powerOff(stat, isMock)
                    },
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    Text("OFF")
                }
            }
            Text(text = stat.asStateFlow().collectAsState().value)
        }

    }
}