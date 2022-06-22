package com.teamdue.educampapp.data.di

import com.teamdue.educampapp.data.network.AppApi
import com.teamdue.educampapp.presentation.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApi(): AppApi {
        return Retrofit.Builder()
            .baseUrl(Constants.WEBAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppApi::class.java)
    }

}

