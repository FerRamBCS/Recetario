package com.example.recetario.recetarioRepository

import com.example.recetario.ApiService
import com.example.recetario.recetarioData.idMeal

class idMealRepository(private val apiService: ApiService) {

    suspend fun getMealDetails(mealId: String): idMeal? {
        return try {
            val response = apiService.getMealDetails(mealId)
            response.idmealList.firstOrNull()  // Devuelve el primer (y único) elemento de la lista
        } catch (e: Exception) {
            null  // Maneja el error según sea necesario
        }
    }
}