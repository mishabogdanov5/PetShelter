package misha.petshelter.data.network.retrofit

import io.reactivex.rxjava3.core.Single
import misha.petshelter.models.TestModel
import retrofit2.http.GET
import retrofit2.http.Headers


interface RetrofitService {
 //"tech/healthcheck"
    @GET("typicode/demo/posts/1")
    @Headers("Content-Type: application/json")
    fun getTestResult(): Single<TestModel>
}