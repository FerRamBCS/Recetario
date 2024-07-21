package com.example.recetario

import com.example.recetario.recetarioData.areaListResponse
import com.example.recetario.recetarioData.idMealResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") mealId: String): idMealResponse

    @GET("list.php")
    suspend fun getAreaList(@Query("a") area: String = "list"): areaListResponse

}