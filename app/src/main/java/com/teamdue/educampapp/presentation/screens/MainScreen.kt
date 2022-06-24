package com.teamdue.educampapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.teamdue.educampapp.R
import com.teamdue.educampapp.data.network.dto.LedStatusDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun MainScreen(navController: NavController) {
    val viewModel = hiltViewModel<MainViewModel>()
    
    //Ui building
    ValueSurface(viewModel)

    viewModel.initViewModel(booleanResource(id = R.bool.useMockEnv))
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ValueSurface(viewModel: MainViewModel) {

    val isMock = booleanResource(id = R.bool.useMockEnv)
    val state = viewModel.messageFromSocket.asStateFlow().collectAsState()

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
                painterResource(
                    if (evaluateState(viewModel.messageFromSocket))
                        R.drawable.on
                    else
                        R.drawable.off
                ),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        //If lamp is on, turn off
                        if (evaluateState(viewModel.messageFromSocket))
                            viewModel.powerOff(isMock)
                        //If lamp is off, turn on
                        else
                            viewModel.powerOn(isMock)
                    }
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            AnimatedVisibility(visible = state.value != null) {
                Text(
                    text = "Field led is: " + state
                        .value?.toLedStatusEntity().toString()
                )
            }
        }
    }
}

//Evaluate what comes from socket
private fun evaluateState(
    messageState: MutableStateFlow<LedStatusDto?>
): Boolean {
    return when (messageState.value?.ledStatus) {
        true -> true
        false -> false
        else -> false
    }
}