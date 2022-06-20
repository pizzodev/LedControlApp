package com.teamdue.educampapp.data.network

import com.teamdue.educampapp.data.network.dto.PojoDto
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface AppApi {
    @GET("TOBE")
    suspend fun getSomething(): PojoDto
}