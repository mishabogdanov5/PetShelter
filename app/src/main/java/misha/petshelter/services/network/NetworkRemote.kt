package misha.petshelter.services.network

import misha.petshelter.services.network.retrofit.RetrofitService
import misha.petshelter.models.LoginInfo
import misha.petshelter.models.RegisterInfo
import javax.inject.Inject

class NetworkRemote @Inject constructor (
    private val retrofit: RetrofitService
) {
    fun loginUser(info: LoginInfo) = retrofit.loginUser(info)

    fun registerUser(info: RegisterInfo) = retrofit.registerUser(info)
}