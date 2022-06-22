package com.teamdue.educampapp.data.network.datasource

import com.teamdue.educampapp.data.network.dto.LedStatusDto
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.random.Random

class MockDatasource @Inject constructor(
    //Nothing needed
) {

    suspend fun powerOnMocked(): LedStatusDto {
        val pojoItem = LedStatusDto(
            true
        )
        return pojoItem
    }

    suspend fun powerOffMocked(): LedStatusDto {
        val pojoItem = LedStatusDto(
            false
        )
        return pojoItem
    }

    fun initWebSocketServer(messageFromSocket: MutableStateFlow<LedStatusDto?>) {
        openWebSocketChannel(messageFromSocket)
    }

    fun openWebSocketChannel(state: MutableStateFlow<LedStatusDto?>) {
        state.value = LedStatusDto(
            Random.nextBoolean()
        )
    }
}