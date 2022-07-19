package misha.petshelter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import misha.petshelter.data.network.retrofit.RetrofitService
import misha.petshelter.data.remote.NetworkRemoteData
import misha.petshelter.data.repositories.UserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String = "https://petsproject.issart.com/api/1.0.0/"

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .also { it.level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
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