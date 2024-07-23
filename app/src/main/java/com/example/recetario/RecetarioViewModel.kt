package com.example.recetario

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.recetario.data.Category
import com.example.recetario.data.Country
import com.example.recetario.data.Ingredient
import com.example.recetario.data.Meal
import com.example.recetario.data.MealDetail
import com.example.recetario.repository.CategoriesRepository
import com.example.recetario.repository.CountriesRepository
import com.example.recetario.repository.IngredientsRepository
import com.example.recetario.repository.MealDetailRepository
import com.example.recetario.repository.MealsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecetarioViewModel(application: Application) : AndroidViewModel(application) {
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val apiService = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(ApiService::class.java)

    private val categoriesRepository = CategoriesRepository(apiService)
    private val countriesRepository = CountriesRepository(apiService)
    private val ingredientsRepository = IngredientsRepository(apiService)
    private val mealDetailRepository = MealDetailRepository(apiService)
    private val mealsRepository = MealsRepository(apiService)

    private val _categoriesList = MutableStateFlow<List<Category>>(emptyList())
    val categoriesList: StateFlow<List<Category>> = _categoriesList

    private val _countriesList = MutableStateFlow<List<Country>>(emptyList())
    val countriesList: StateFlow<List<Country>> = _countriesList

    private val _ingredientsList = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredientsList: StateFlow<List<Ingredient>> = _ingredientsList

    private val _mealDetail = MutableStateFlow<List<MealDetail>>(emptyList())
    val mealDetail: StateFlow<List<MealDetail>> = _mealDetail

    private val _mealsList = MutableStateFlow<List<Meal>>(emptyList())
    val mealsList: StateFlow<List<Meal>> = _mealsList

    init {
        getCategories()
        getCountries()
        getIngredients()
    }

    private fun getCategories() = viewModelScope.launch {
        val categories = categoriesRepository.getCategories() ?: emptyList()
        _categoriesList.value = categories
    }

    private fun getCountries() = viewModelScope.launch {
        val countries = countriesRepository.getCountries() ?: emptyList()
        _countriesList.value = countries
    }

    private fun getIngredients() = viewModelScope.launch {
        val ingredients = ingredientsRepository.getIngredients() ?: emptyList()
        _ingredientsList.value = ingredients
    }

    fun getMealDetailById(id: String) = viewModelScope.launch {
        val mealDetail = mealDetailRepository.getMealById(id) ?: emptyList()
        _mealDetail.value = mealDetail
    }

    fun getMealsByFirstLetter(firstLetter: String) = viewModelScope.launch {
        val meals = mealsRepository.getMealsByFirstLetter(firstLetter) ?: emptyList()
        _mealsList.value = meals
    }

    fun getMealByName(name: String) = viewModelScope.launch {
        val meals = mealsRepository.getMealByName(name) ?: emptyList()
        _mealsList.value = meals
    }
}
