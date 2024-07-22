package com.example.recetario.recetarioData

import com.google.gson.annotations.SerializedName

data class searchMealByNameResponse(
    @SerializedName("meals") val mealList: List<idMeal>
)