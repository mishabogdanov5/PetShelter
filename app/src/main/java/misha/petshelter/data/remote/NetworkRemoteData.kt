package misha.petshelter.data.remote

import misha.petshelter.data.network.retrofit.RetrofitService
import javax.inject.Inject

class NetworkRemoteData @Inject constructor (
    private val retrofit: RetrofitService
) {
    fun getTestResult() = retrofit.getTestResult()
}