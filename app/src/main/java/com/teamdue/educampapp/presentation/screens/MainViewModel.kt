package com.teamdue.educampapp.presentation.screens

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.ui.res.booleanResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamdue.educampapp.R
import com.teamdue.educampapp.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: AppUseCases
): ViewModel() {

    var ledStatus = MutableStateFlow(value = false)

    fun powerOn(useMockEnv: Boolean) {
        viewModelScope.launch {
            try {
                ledStatus.value = useCases.powerOn(useMockEnv).ledStatus
            } catch (e: Exception) {
                Log.d("App error", e.message.toString())
            }
        }
    }
    fun powerOff(useMockEnv: Boolean) {
        viewModelScope.launch {
            try {
                ledStatus.value = useCases.powerOff(useMockEnv).ledStatus
            } catch (e: Exception) {
                Log.d("App error", e.message.toString())
            }
        }
    }
}