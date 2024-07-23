package com.example.recetario.data

import com.google.gson.annotations.SerializedName

// Clase de respuesta para la lista de comidas
data class MealsResponse(
    @SerializedName("meals") val meals: List<Meal> // Lista de comidas
)

// Clase que representa una comida
data class Meal(
    @SerializedName("idMeal") val idMeal: String, // ID de la comida
    @SerializedName("strMeal") val strMeal: String, // Nombre de la comida
    @SerializedName("strMealThumb") val strMealThumb: String // URL de la imagen de la comida
)
