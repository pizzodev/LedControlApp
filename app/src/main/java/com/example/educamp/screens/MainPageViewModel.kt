package com.example.educamp.screens

import androidx.lifecycle.ViewModel
import com.example.educamp.repository.EduRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(private val eduRepository: EduRepository): ViewModel() {
}