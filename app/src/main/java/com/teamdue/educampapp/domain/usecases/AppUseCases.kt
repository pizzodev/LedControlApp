package com.teamdue.educampapp.domain.usecases

import com.teamdue.educampapp.data.network.datasource.MockDatasource
import com.teamdue.educampapp.data.network.datasource.RemoteDatasource
import com.teamdue.educampapp.data.network.entities.PojoEntity
import javax.inject.Inject

class AppUseCases @Inject constructor(
    private val remoteDatasource: RemoteDatasource,
    private val mockDatasource: MockDatasource
) {

    suspend fun getData(isMocked: Boolean): PojoEntity {
        return if (isMocked)
            remoteDatasource.getData().toPojoEntity()
        else
            mockDatasource.getDataMocked().toPojoEntity()
    }

}