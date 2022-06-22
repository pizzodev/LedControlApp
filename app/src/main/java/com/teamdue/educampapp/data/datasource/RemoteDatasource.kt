package com.teamdue.educampapp.data.network.datasource

import android.util.Log
import com.teamdue.educampapp.data.network.AppApi
import com.teamdue.educampapp.data.network.MessageListener
import com.teamdue.educampapp.data.network.dto.LedStatusDto
import com.teamdue.educampapp.presentation.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val appApi: AppApi
): MessageListener {

    private lateinit var _state: MutableStateFlow<LedStatusDto?>

    suspend fun powerOn(): LedStatusDto {
        val pojoItem = appApi.powerOn()
        return pojoItem
    }

    suspend fun powerOff(): LedStatusDto {
        val pojoItem = appApi.powerOff()
        return pojoItem
    }

    fun initWebSocketServer() {
        WebSocketManager.init(Constants.WS_ADDRESS, this)
    }

    fun openWebSocketChannel(state: MutableStateFlow<LedStatusDto?>) {
        _state = state
        WebSocketManager.connect()
    }

    override fun onConnectSuccess() {
        Log.d( "WebSocket", "Connected successfully \n" )
    }

    override fun onConnectFailed() {
        Log.d( "WebSocket", "Failed\n" )
    }

    override fun onClose() {
        Log.d( "WebSocket", "Close\n" )
    }

    override fun onMessage(text: String?) {
        _state.value = LedStatusDto.fromString(text?:"")
        Log.d( "WebSocket", "$text" )
    }
}