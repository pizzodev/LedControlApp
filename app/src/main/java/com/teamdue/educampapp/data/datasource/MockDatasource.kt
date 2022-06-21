package com.teamdue.educampapp.data.network.datasource

import com.teamdue.educampapp.data.network.dto.PojoDto
import javax.inject.Inject

class MockDatasource @Inject constructor(
    //Nothing needed
) {

    suspend fun powerOnMocked(): PojoDto {
        val pojoItem = PojoDto(
            true
        )
        return pojoItem
    }

    suspend fun powerOffMocked(): PojoDto {
        val pojoItem = PojoDto(
            false
        )
        return pojoItem
    }
}