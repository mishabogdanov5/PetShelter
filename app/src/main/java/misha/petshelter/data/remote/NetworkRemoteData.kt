package misha.petshelter.data.remote

import misha.petshelter.data.network.retrofit.RetrofitService
import misha.petshelter.models.LoginInfo
import javax.inject.Inject

class NetworkRemoteData @Inject constructor (
    private val retrofit: RetrofitService
) {
    fun loginUser(info: LoginInfo) = retrofit.loginUser(info)
}