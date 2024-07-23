package com.example.recetario.data

import com.google.gson.annotations.SerializedName

// Clase de respuesta para la lista de categorías
data class CategoriesResponse(
    @SerializedName("categories") val categories: List<Category> // Lista de categorías
)

// Clase que representa una categoría
data class Category(
    @SerializedName("idCategory") val idCategory: String, // ID de la categoría
    @SerializedName("strCategory") val strCategory: String, // Nombre de la categoría
    @SerializedName("strCategoryThumb") val strCategoryThumb: String, // URL de la imagen de la categoría
    @SerializedName("strCategoryDescription") val strCategoryDescription: String // Descripción de la categoría
)

