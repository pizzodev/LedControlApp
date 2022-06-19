package com.example.educamp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.educamp.R

@Composable
@Preview(showBackground = true)
fun MainPage(viewModel: MainPageViewModel = viewModel()) {
    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding))
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                Button(modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.padding))
                    .fillMaxWidth(),
                    onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.ble))
                }
                Button(modifier = Modifier.fillMaxWidth(),
                    onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.network))
                }
            }
        }
    }
}