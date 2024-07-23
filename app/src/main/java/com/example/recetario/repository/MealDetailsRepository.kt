package com.example.recetario.repository

import com.example.recetario.ApiService
import com.example.recetario.data.MealDetail

class MealDetailRepository(private val apiService: ApiService) {

    // Función suspendida para obtener el detalle de una comida por ID
    suspend fun getMealById(id: String): List<MealDetail>? {
        return try {
            // Hacemos la llamada a la API usando la función suspendida
            val response = apiService.getMealById(id)
            // Retornamos el detalle de la comida
            response.meals
        } catch (e: Exception) {
            // En caso de excepción, retornamos null
            null
        }
    }
}
