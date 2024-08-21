package com.example.cryptocurrency_app.di

import com.example.cryptocurrency_app.common.Constants.BASE_URL
import com.example.cryptocurrency_app.data.remote.CoinPaprikaApi
import com.example.cryptocurrency_app.data.repository.CoinRepositoryImpl
import com.example.cryptocurrency_app.domain.repository.CoinRepository
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
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi) : CoinRepository{
        return CoinRepositoryImpl(api)
    }

}