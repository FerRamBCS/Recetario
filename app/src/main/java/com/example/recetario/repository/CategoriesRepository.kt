package com.example.recetario.repository

import com.example.recetario.ApiService
import com.example.recetario.data.Category

class CategoriesRepository(private val apiService: ApiService) {

    // Función suspendida para obtener la lista de categorías
    suspend fun getCategories(): List<Category>? {
        return try {
            // Hacemos la llamada a la API usando la función suspendida
            val response = apiService.getCategories()
            // Retornamos la lista de categorías
            response.categories
        } catch (e: Exception) {
            // En caso de excepción, retornamos null
            null
        }
    }
}
