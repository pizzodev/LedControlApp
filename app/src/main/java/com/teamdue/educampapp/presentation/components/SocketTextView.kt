package com.teamdue.educampapp.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

@Composable
fun SocketTextView(
    modifier: Modifier = Modifier(),
    stringValue: String
) {
    Text(
        text = stringValue
    )
}