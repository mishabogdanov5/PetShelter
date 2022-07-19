package misha.petshelter.data.network.retrofit

import io.reactivex.rxjava3.core.Single
import misha.petshelter.models.LoginInfo
import misha.petshelter.models.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface RetrofitService {
 //"tech/healthcheck"
    /*@GET("typicode/demo/posts/1")
    @Headers("Content-Type: application/json")
    fun getTestResult(): Single<TestModel>*/

    @POST("login/email")
    fun loginUser(@Body info: LoginInfo) : Single<LoginResponse>
}