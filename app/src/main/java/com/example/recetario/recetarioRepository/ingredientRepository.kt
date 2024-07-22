package com.example.recetario.recetarioRepository

import com.example.recetario.ApiService
import com.example.recetario.recetarioData.Ingredients

class ingredientRepository(private  val apiService: ApiService) {

    suspend fun getIngredients(): List<Ingredients>? {
        return try {
            val response = apiService.getMealIgredients()
            response.ingredients
        }catch (e: Exception){
            null
        }
    }

}