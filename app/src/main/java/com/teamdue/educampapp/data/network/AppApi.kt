package com.teamdue.educampapp.data.network

import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface AppApi {
    @GET("pokemon")
    suspend fun getSomething(): Unit
}