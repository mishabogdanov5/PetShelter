package misha.petshelter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import misha.petshelter.data.network.retrofit.RetrofitService
import misha.petshelter.data.remote.NetworkRemoteData
import misha.petshelter.data.repositories.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String = "https://petsproject.issart.com/api/1.0.0/"

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService = retrofit.create(RetrofitService::class.java)

    @Singleton
    @Provides
    fun provideNetworkRemoteData(retrofitService: RetrofitService): NetworkRemoteData = NetworkRemoteData(retrofitService)

    @Singleton
    @Provides
    fun provideUserRepository(remoteData: NetworkRemoteData): UserRepository = UserRepository(remoteData)
}