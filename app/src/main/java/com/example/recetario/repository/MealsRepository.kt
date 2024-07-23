package com.example.recetario.repository

import com.example.recetario.ApiService
import com.example.recetario.data.Meal

class MealsRepository(private val apiService: ApiService) {

    // Función suspendida para obtener comidas por primera letra
    suspend fun getMealsByFirstLetter(firstLetter: String): List<Meal>? {
        return try {
            // Hacemos la llamada a la API usando la función suspendida
            val response = apiService.getMealsByFirstLetter(firstLetter)
            // Retornamos la lista de comidas
            response.meals
        } catch (e: Exception) {
            // En caso de excepción, retornamos null
            null
        }
    }

    // Función suspendida para obtener una comida por nombre
    suspend fun getMealByName(name: String): List<Meal>? {
        return try {
            // Hacemos la llamada a la API usando la función suspendida
            val response = apiService.getMealByName(name)
            // Retornamos la lista de comidas
            response.meals
        } catch (e: Exception) {
            // En caso de excepción, retornamos null
            null
        }
    }
}
