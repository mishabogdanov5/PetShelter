package misha.petshelter.data.network.retrofit

import misha.petshelter.models.TestModel
import retrofit2.Response
import retrofit2.http.GET


interface RetrofitService {

    @GET("tech/healthcheck")
    suspend fun getTestResult(): Response<TestModel>
}