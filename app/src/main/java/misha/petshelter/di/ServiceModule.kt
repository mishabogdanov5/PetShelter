package misha.petshelter.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import misha.petshelter.services.localStorage.SharedPreferencesStorage
import misha.petshelter.services.localStorage.UserStorage
import misha.petshelter.services.navigation.AppNavigation
import misha.petshelter.services.navigation.AppNavigationImpl
import misha.petshelter.services.network.retrofit.RetrofitService
import misha.petshelter.services.network.okhttp.loginClient
import misha.petshelter.ui.theme.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(loginClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService = retrofit.create(RetrofitService::class.java)

    @Singleton
    @Provides
    fun providesUserStorage(
        @ApplicationContext
        context: Context):UserStorage = SharedPreferencesStorage(context)

    @Singleton
    @Provides
    fun provideNavigation(): AppNavigation = AppNavigationImpl()
}