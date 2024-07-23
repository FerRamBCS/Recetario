package com.example.recetario.repository

import com.example.recetario.ApiService
import com.example.recetario.data.Ingredient

class IngredientsRepository(private val apiService: ApiService) {

    // Función suspendida para obtener la lista de ingredientes
    suspend fun getIngredients(): List<Ingredient>? {
        return try {
            // Hacemos la llamada a la API usando la función suspendida
            val response = apiService.getIngredients()
            // Retornamos la lista de ingredientes
            response.meals
        } catch (e: Exception) {
            // En caso de excepción, retornamos null
            null
        }
    }
}
