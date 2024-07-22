package com.example.recetario

import com.example.recetario.recetarioData.areaListResponse
import com.example.recetario.recetarioData.categoryResponse
import com.example.recetario.recetarioData.idMealResponse
import com.example.recetario.recetarioData.ingredientResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    //EndPoint para buscar por Id de comida
    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") mealId: String): idMealResponse
    //EndPoint para filtrar por area
    @GET("list.php")
    suspend fun getAreaList(@Query("a") area: String = "list"): areaListResponse
    //EndPoint para filtrar por categorias

    @GET("categories.php")
    suspend fun getMealCategories(): categoryResponse
    //EndPoint para filtrar por ingrdientes

    @GET("list.php?i=list")
    suspend fun getMealIgredients(): ingredientResponse
    //EndPoint para fltrar por nombre

    //EndPoint para buscar directamente por nombre el platillo
    @GET("search.php")
    suspend fun searchMealByName(@Query("s") mealName: String): idMealResponse


}
