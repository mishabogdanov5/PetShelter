package misha.petshelter.services.network.retrofit

import io.reactivex.rxjava3.core.Single
import misha.petshelter.models.LoginInfo
import misha.petshelter.models.PetInfo
import misha.petshelter.models.UserTokens
import misha.petshelter.models.RegisterInfo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface RetrofitService {

    @POST("login/email")
    fun loginUser(@Body info: LoginInfo) : Single<UserTokens>

    @POST("register/email")
    fun registerUser(@Body info: RegisterInfo): Single<UserTokens>

    @GET("announcements")
    fun getAllPets(): Single<List<PetInfo>>
}