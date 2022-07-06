package misha.petshelter.data.repositories

import misha.petshelter.data.remote.NetworkRemoteData
import javax.inject.Inject

class UserRepository @Inject constructor (
    private val networkRemote: NetworkRemoteData
) {
    suspend fun getTestResult() = networkRemote.getTestResult()
}