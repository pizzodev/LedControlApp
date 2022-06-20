package com.teamdue.educampapp.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    fun initViewModel(stat: MutableStateFlow<String>) {
        try {
            viewModelScope.launch {
                stat.value = "Hello embedded extended team2!"
            }
        } catch (e: Exception) {
            stat.value = "${e.message}"
        }
    }
}