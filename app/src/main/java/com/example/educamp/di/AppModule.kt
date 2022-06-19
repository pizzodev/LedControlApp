package com.example.educamp.di

import com.example.educamp.repository.EduRepository
import com.example.educamp.constants.Constants
import com.example.educamp.manager.BluetoothManager
import com.example.educamp.network.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideEduRepository(restApi: RestApi, bluetoothManager: BluetoothManager)
        = EduRepository(restApi, bluetoothManager)

    @Singleton
    @Provides
    fun provideTriviaApi(): RestApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestApi::class.java)
    }

}