package com.teamdue.educampapp.data.di

import com.teamdue.educampapp.data.network.AppApi
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
            .baseUrl("http://10.30.24.219:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppApi::class.java)
    }

}

