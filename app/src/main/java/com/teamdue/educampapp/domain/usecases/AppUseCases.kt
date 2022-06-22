package com.teamdue.educampapp.domain.usecases

import com.teamdue.educampapp.data.network.datasource.MockDatasource
import com.teamdue.educampapp.data.network.datasource.RemoteDatasource
import com.teamdue.educampapp.data.network.entities.LedStatusEntity
import javax.inject.Inject

class AppUseCases @Inject constructor(
    private val remoteDatasource: RemoteDatasource,
    private val mockDatasource: MockDatasource
) {

    suspend fun powerOn(isMocked: Boolean): LedStatusEntity {
        return if (isMocked)
            mockDatasource.powerOnMocked().toLedStatusEntity()
        else
            remoteDatasource.powerOn().toLedStatusEntity()
    }

    suspend fun powerOff(isMocked: Boolean): LedStatusEntity {
        return if (isMocked)
            mockDatasource.powerOffMocked().toLedStatusEntity()
        else
            remoteDatasource.powerOff().toLedStatusEntity()
    }

}