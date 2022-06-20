package com.teamdue.educampapp.data.network.datasource

import com.teamdue.educampapp.data.network.AppApi
import com.teamdue.educampapp.data.network.dto.PojoDto
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val appApi: AppApi
) {

    suspend fun getData(): PojoDto {
        val pojoItem = appApi.getSomething()
        return pojoItem
    }
}