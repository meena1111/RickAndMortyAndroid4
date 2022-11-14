package com.example.rickandmortyandroid4.di

import com.example.rickandmortyandroid4.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacter(retrofitClient: RetrofitClient) = retrofitClient.provideCharacterApiService()

    @Singleton
    @Provides
    fun provideLocation(retrofitClient: RetrofitClient) = retrofitClient.provideLocationApiService()

    @Singleton
    @Provides
    fun provideEpisode(retrofitClient: RetrofitClient) = retrofitClient.provideEpisodeApiService()
}