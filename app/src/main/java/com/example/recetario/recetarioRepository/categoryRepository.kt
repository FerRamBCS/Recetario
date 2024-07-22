package com.example.recetario.recetarioRepository

import com.example.recetario.ApiService
import com.example.recetario.recetarioData.Category

class categoryRepository(private val apiService: ApiService) {

    suspend fun getMealCategories(): List<Category>?{
        return try {
            val response = apiService.getMealCategories()
            response.categorias
        }catch (e: Exception){
            null
        }
    }

}