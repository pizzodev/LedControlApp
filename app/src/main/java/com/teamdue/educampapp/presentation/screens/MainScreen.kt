package com.teamdue.educampapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScreen(navController: NavController) {

    val viewModel = hiltViewModel<MainViewModel>()
    val stat = MutableStateFlow("")

    viewModel.initViewModel(stat)

    //Ui building
    ValueSurface(stat.asStateFlow())
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ValueSurface(stat: StateFlow<String>) {
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.White)
    ) {
        Text(text = stat.value)
    }
}