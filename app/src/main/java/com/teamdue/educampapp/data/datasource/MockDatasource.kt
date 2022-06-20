package com.teamdue.educampapp.data.network.datasource

import com.teamdue.educampapp.data.network.dto.PojoDto
import javax.inject.Inject

class MockDatasource @Inject constructor(
    //Nothing needed
) {

    suspend fun getDataMocked(): PojoDto {
        val pojoItem = PojoDto(
            "Hello embedded extended team2!"
        )
        return pojoItem
    }
}