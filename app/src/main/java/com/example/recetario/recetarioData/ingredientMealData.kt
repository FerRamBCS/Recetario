package com.example.recetario.recetarioData

import com.google.gson.annotations.SerializedName

data class ingredientResponse(
    @SerializedName("meals") val ingredients: List<Ingredients>
)

data class Ingredients(
    val idIngredient: String,
    val strIngredient: String,
    val strDescription: String?,
    val strType: String?
)