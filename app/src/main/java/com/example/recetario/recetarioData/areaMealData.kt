package com.example.recetario.recetarioData

import com.google.gson.annotations.SerializedName

data class areaListResponse(
    @SerializedName("meals") val areaList: List<Area>
)

data class Area(
    @SerializedName("strArea") val name: String
)

