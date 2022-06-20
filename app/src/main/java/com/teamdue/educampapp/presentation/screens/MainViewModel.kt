package com.teamdue.educampapp.presentation.screens

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

    fun initViewModel(stat: MutableStateFlow<String>, useMockEnv: Boolean) {
        try {
            viewModelScope.launch {
                stat.value = useCases.getData(useMockEnv).pojoField
            }
        } catch (e: Exception) {
            stat.value = "${e.message}"
        }
    }
}