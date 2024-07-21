package com.example.recetario

import com.example.recetario.recetarioData.idMealResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") mealId: String): idMealResponse
}