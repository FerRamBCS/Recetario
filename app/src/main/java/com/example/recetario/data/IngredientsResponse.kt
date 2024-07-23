package com.example.recetario.data

import com.google.gson.annotations.SerializedName

// Clase de respuesta para la lista de ingredientes
data class IngredientsResponse(
    @SerializedName("meals") val meals: List<Ingredient> // Lista de ingredientes
)

// Clase que representa un ingrediente
data class Ingredient(
    @SerializedName("idIngredient") val idIngredient: String, // ID del ingrediente
    @SerializedName("strIngredient") val strIngredient: String, // Nombre del ingrediente
    @SerializedName("strDescription") val strDescription: String // Descripción del ingrediente
)
