package misha.petshelter.models

import com.google.gson.annotations.SerializedName

data class RegisterInfo(
    val email: String,

    val password: String,

    @SerializedName("userName")
    val name: String,
)
