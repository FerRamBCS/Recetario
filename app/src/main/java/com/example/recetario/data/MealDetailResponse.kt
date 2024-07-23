package com.example.recetario.data

import com.google.gson.annotations.SerializedName

// Clase de respuesta para el detalle de una comida
data class MealDetailResponse(
    @SerializedName("meals") val meals: List<MealDetail> // Lista con los detalles de la comida
)

// Clase que representa el detalle de una comida
data class MealDetail(
    @SerializedName("idMeal") val idMeal: String, // ID de la comida
    @SerializedName("strMeal") val strMeal: String, // Nombre de la comida
    @SerializedName("strDrinkAlternate") val strDrinkAlternate: String?, // Bebida alterna (puede ser nulo)
    @SerializedName("strCategory") val strCategory: String, // Categoría de la comida
    @SerializedName("strArea") val strArea: String, // Área (región) de la comida
    @SerializedName("strInstructions") val strInstructions: String, // Instrucciones para preparar la comida
    @SerializedName("strMealThumb") val strMealThumb: String, // URL de la imagen de la comida
    @SerializedName("strTags") val strTags: String?, // Etiquetas de la comida (puede ser nulo)
    @SerializedName("strYoutube") val strYoutube: String, // URL del video de YouTube de la receta
    @SerializedName("strIngredient1") val strIngredient1: String?, // Ingrediente 1 (puede ser nulo)
    @SerializedName("strIngredient2") val strIngredient2: String?, // Ingrediente 2 (puede ser nulo)
    @SerializedName("strIngredient3") val strIngredient3: String?, // Ingrediente 3 (puede ser nulo)
    @SerializedName("strIngredient4") val strIngredient4: String?, // Ingrediente 4 (puede ser nulo)
    @SerializedName("strIngredient5") val strIngredient5: String?, // Ingrediente 5 (puede ser nulo)
    @SerializedName("strIngredient6") val strIngredient6: String?, // Ingrediente 6 (puede ser nulo)
    @SerializedName("strIngredient7") val strIngredient7: String?, // Ingrediente 7 (puede ser nulo)
    @SerializedName("strIngredient8") val strIngredient8: String?, // Ingrediente 8 (puede ser nulo)
    @SerializedName("strIngredient9") val strIngredient9: String?, // Ingrediente 9 (puede ser nulo)
    @SerializedName("strIngredient10") val strIngredient10: String?, // Ingrediente 10 (puede ser nulo)
    @SerializedName("strIngredient11") val strIngredient11: String?, // Ingrediente 11 (puede ser nulo)
    @SerializedName("strIngredient12") val strIngredient12: String?, // Ingrediente 12 (puede ser nulo)
    @SerializedName("strIngredient13") val strIngredient13: String?, // Ingrediente 13 (puede ser nulo)
    @SerializedName("strIngredient14") val strIngredient14: String?, // Ingrediente 14 (puede ser nulo)
    @SerializedName("strIngredient15") val strIngredient15: String?, // Ingrediente 15 (puede ser nulo)
    @SerializedName("strIngredient16") val strIngredient16: String?, // Ingrediente 16 (puede ser nulo)
    @SerializedName("strIngredient17") val strIngredient17: String?, // Ingrediente 17 (puede ser nulo)
    @SerializedName("strIngredient18") val strIngredient18: String?, // Ingrediente 18 (puede ser nulo)
    @SerializedName("strIngredient19") val strIngredient19: String?, // Ingrediente 19 (puede ser nulo)
    @SerializedName("strIngredient20") val strIngredient20: String?, // Ingrediente 20 (puede ser nulo)
    @SerializedName("strMeasure1") val strMeasure1: String?, // Medida del ingrediente 1 (puede ser nulo)
    @SerializedName("strMeasure2") val strMeasure2: String?, // Medida del ingrediente 2 (puede ser nulo)
    @SerializedName("strMeasure3") val strMeasure3: String?, // Medida del ingrediente 3 (puede ser nulo)
    @SerializedName("strMeasure4") val strMeasure4: String?, // Medida del ingrediente 4 (puede ser nulo)
    @SerializedName("strMeasure5") val strMeasure5: String?, // Medida del ingrediente 5 (puede ser nulo)
    @SerializedName("strMeasure6") val strMeasure6: String?, // Medida del ingrediente 6 (puede ser nulo)
    @SerializedName("strMeasure7") val strMeasure7: String?, // Medida del ingrediente 7 (puede ser nulo)
    @SerializedName("strMeasure8") val strMeasure8: String?, // Medida del ingrediente 8 (puede ser nulo)
    @SerializedName("strMeasure9") val strMeasure9: String?, // Medida del ingrediente 9 (puede ser nulo)
    @SerializedName("strMeasure10") val strMeasure10: String?, // Medida del ingrediente 10 (puede ser nulo)
    @SerializedName("strMeasure11") val strMeasure11: String?, // Medida del ingrediente 11 (puede ser nulo)
    @SerializedName("strMeasure12") val strMeasure12: String?, // Medida del ingrediente 12 (puede ser nulo)
    @SerializedName("strMeasure13") val strMeasure13: String?, // Medida del ingrediente 13 (puede ser nulo)
    @SerializedName("strMeasure14") val strMeasure14: String?, // Medida del ingrediente 14 (puede ser nulo)
    @SerializedName("strMeasure15") val strMeasure15: String?, // Medida del ingrediente 15 (puede ser nulo)
    @SerializedName("strMeasure16") val strMeasure16: String?, // Medida del ingrediente 16 (puede ser nulo)
    @SerializedName("strMeasure17") val strMeasure17: String?, // Medida del ingrediente 17 (puede ser nulo)
    @SerializedName("strMeasure18") val strMeasure18: String?, // Medida del ingrediente 18 (puede ser nulo)
    @SerializedName("strMeasure19") val strMeasure19: String?, // Medida del ingrediente 19 (puede ser nulo)
    @SerializedName("strMeasure20") val strMeasure20: String? // Medida del ingrediente 20 (puede ser nulo)
)
