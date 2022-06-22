package com.teamdue.educampapp.domain.usecases

import com.teamdue.educampapp.data.network.datasource.MockDatasource
import com.teamdue.educampapp.data.network.datasource.RemoteDatasource
import com.teamdue.educampapp.data.network.dto.LedStatusDto
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class WebSocketRepository @Inject constructor(
    private val remoteDatasource: RemoteDatasource,
    private val mockDatasource: MockDatasource
) {
    fun initWebSocketServer(useMockEnv: Boolean, messageFromSocket: MutableStateFlow<LedStatusDto?>) {
        if (useMockEnv)
            mockDatasource.initWebSocketServer(messageFromSocket)
        else
            remoteDatasource.initWebSocketServer()
    }
    fun openWebSocketChannel(value: MutableStateFlow<LedStatusDto?>, isMock: Boolean) {
        if (isMock)
            mockDatasource.openWebSocketChannel(value)
        else
            remoteDatasource.openWebSocketChannel(value)
    }
}