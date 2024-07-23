package com.example.recetario

import com.example.recetario.data.CategoriesResponse
import com.example.recetario.data.CountriesResponse
import com.example.recetario.data.IngredientsResponse
import com.example.recetario.data.MealDetailResponse
import com.example.recetario.data.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Por primer letra
    @GET("search.php")
    suspend fun getMealsByFirstLetter(@Query("f") firstLetter: String): MealsResponse

    // Paises
    @GET("list.php")
    suspend fun getCountries(@Query("a") list: String = "list"): CountriesResponse

    // Categorias
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    // Ingredientes
    @GET("list.php")
    suspend fun getIngredients(@Query("i") list: String = "list"): IngredientsResponse

    // Por nombre
    @GET("search.php")
    suspend fun getMealByName(@Query("s") name: String): MealsResponse

    // Por ID
    @GET("lookup.php")
    suspend fun getMealById(@Query("i") id: String): MealDetailResponse
}
