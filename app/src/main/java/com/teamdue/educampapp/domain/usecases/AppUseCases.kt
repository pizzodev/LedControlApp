package com.teamdue.educampapp.domain.usecases

import com.teamdue.educampapp.data.network.datasource.MockDatasource
import com.teamdue.educampapp.data.network.datasource.RemoteDatasource
import com.teamdue.educampapp.data.network.entities.PojoEntity
import javax.inject.Inject

class AppUseCases @Inject constructor(
    private val remoteDatasource: RemoteDatasource,
    private val mockDatasource: MockDatasource
) {

    suspend fun getData(): PojoEntity {
        return remoteDatasource.getData().toPojoEntity()
    }

    suspend fun getDataMocked(): PojoEntity {
        return mockDatasource.getDataMocked().toPojoEntity()
    }

}