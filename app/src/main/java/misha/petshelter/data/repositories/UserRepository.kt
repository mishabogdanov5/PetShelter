package misha.petshelter.data.repositories

import misha.petshelter.data.remote.NetworkRemoteData
import misha.petshelter.models.LoginInfo
import javax.inject.Inject

class UserRepository @Inject constructor (
    private val networkRemote: NetworkRemoteData
) {
    fun loginUser(info: LoginInfo) = networkRemote.loginUser(info)
}