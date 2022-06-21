package com.teamdue.educampapp.presentation.screens

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

    fun powerOn(stat: MutableStateFlow<String>, useMockEnv: Boolean) {
        viewModelScope.launch {
            try {
                stat.value = useCases.powerOn(useMockEnv).toBeautifulString()
            } catch (e: Exception) {
                stat.value = "${e.message}"
            }
        }
    }
    fun powerOff(stat: MutableStateFlow<String>, useMockEnv: Boolean) {
        viewModelScope.launch {
            try {
                stat.value = useCases.powerOff(useMockEnv).toBeautifulString()
            } catch (e: Exception) {
                stat.value = "${e.message}"
            }
        }
    }
}