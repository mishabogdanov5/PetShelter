package misha.petshelter.models

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String
)
