package com.teamdue.educampapp.data.network.datasource

import com.teamdue.educampapp.data.network.AppApi
import com.teamdue.educampapp.data.network.dto.PojoDto
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val appApi: AppApi
) {

    suspend fun powerOn(): PojoDto {
        val pojoItem = appApi.powerOn()
        return pojoItem
    }

    suspend fun powerOff(): PojoDto {
        val pojoItem = appApi.powerOff()
        return pojoItem
    }
}