package com.teamdue.educampapp.data.network

import com.teamdue.educampapp.data.network.dto.LedStatusDto
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface AppApi {
    @GET("power/on")
    suspend fun powerOn(): LedStatusDto

    @GET("power/off")
    suspend fun powerOff(): LedStatusDto
}