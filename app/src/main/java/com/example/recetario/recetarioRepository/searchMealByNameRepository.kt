package com.example.recetario.recetarioRepository

import com.example.recetario.ApiService
import com.example.recetario.recetarioData.idMeal

class searchMealByNameRepository(private val apiService: ApiService) {

    suspend fun searchMealByName(mealName: String): idMeal? {
        return try {
            val response = apiService.searchMealByName(mealName)
            response.idmealList.firstOrNull()
        } catch (e: Exception) {
            null
        }
    }
}