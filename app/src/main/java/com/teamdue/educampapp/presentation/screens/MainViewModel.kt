package com.teamdue.educampapp.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamdue.educampapp.data.network.dto.LedStatusDto
import com.teamdue.educampapp.data.network.entities.LedStatusEntity
import com.teamdue.educampapp.domain.usecases.AppUseCases
import com.teamdue.educampapp.domain.usecases.WebSocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: AppUseCases,
    private val webSocketRepository: WebSocketRepository
): ViewModel() {

    val messageFromSocket = MutableStateFlow<LedStatusDto?>(value = null)

    fun initViewModel(useMockEnv: Boolean) {
        //Open channel
        webSocketRepository.initWebSocketServer(useMockEnv, messageFromSocket)
        //Connect to socket
        connectToWebSocket(useMockEnv)
    }

    fun powerOn(useMockEnv: Boolean) {
        viewModelScope.launch {
            try {
                messageFromSocket.value = useCases.powerOn(useMockEnv).toLedStatusDto()
            } catch (e: Exception) {
                Log.d("App error", e.message.toString())
            }
        }
    }
    fun powerOff(useMockEnv: Boolean) {
        viewModelScope.launch {
            try {
                messageFromSocket.value = useCases.powerOff(useMockEnv).toLedStatusDto()
            } catch (e: Exception) {
                Log.d("App error", e.message.toString())
            }
        }
    }

    private fun connectToWebSocket(isMock: Boolean) {
        viewModelScope.launch {
            try {
                webSocketRepository.openWebSocketChannel(messageFromSocket, isMock)
            } catch (e: Exception) {
                Log.d("Socket error", e.message.toString())
            }
        }
    }
}