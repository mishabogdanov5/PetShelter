package misha.petshelter.models

import com.google.gson.annotations.SerializedName

data class PetInfo(

    val id: String,

    @SerializedName("petType")
    val type: String,

    val imageUrl: String,

    val title: String,

    val description: String,

    @SerializedName("geoPosition")
    val position: GeoPosition
)
