package com.example.recetario.recetarioData

import com.google.gson.annotations.SerializedName

data class idMealResponse(
    @SerializedName("meals") val idmealList: List<idMeal>
)

data class idMeal(
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strInstruction: String
)