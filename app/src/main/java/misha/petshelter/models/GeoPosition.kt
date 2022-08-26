package misha.petshelter.models

import com.google.gson.annotations.SerializedName

data class GeoPosition(

    @SerializedName("lat")
    val latitude: Double,

    @SerializedName("lng")
    val longitude: Double,
)