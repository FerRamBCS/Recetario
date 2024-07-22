package com.example.recetario

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.recetario.recetarioData.Area
import com.example.recetario.recetarioData.Category
import com.example.recetario.recetarioData.Ingredients
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.recetario.recetarioRepository.idMealRepository
import com.example.recetario.recetarioData.idMeal
import com.example.recetario.recetarioRepository.AreaMealRepository
import com.example.recetario.recetarioRepository.categoryRepository
import com.example.recetario.recetarioRepository.ingredientRepository
import com.example.recetario.recetarioRepository.searchMealByNameRepository

class RecetarioViewModel(application: Application): AndroidViewModel(application) {
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

    // Repositorios
    private val idRepository = idMealRepository(apiService)
    private val areaRepository = AreaMealRepository(apiService)
    private val categoryRepository = categoryRepository(apiService)
    private val ingredientRepository = ingredientRepository(apiService)
    private val searchRepository = searchMealByNameRepository(apiService)


    // StateFlows para MealDetails
    private val _mealDetails = MutableStateFlow<idMeal?>(null)
    val mealDetails: StateFlow<idMeal?> = _mealDetails

    // StateFLows para AreaList
    private val _areaList = MutableStateFlow<List<Area>?>(null)
    val areaList: StateFlow<List<Area>?> = _areaList

    //StateFlows para Categorias
    private val _categories = MutableStateFlow<List<Category>?>(null)
    val categories: StateFlow<List<Category>?> =_categories

    // StateFlows para ingredientes
    private val _ingredients = MutableStateFlow<List<Ingredients>?>(null)
    val ingredients: StateFlow<List<Ingredients>?> = _ingredients

    init {
        getMealDetailsById("")
        getAreaList()
        getCategories()
        getIngredients()
    }

    private fun getMealDetailsById (mealId: String) = viewModelScope.launch {
        _mealDetails.value = idRepository.getMealDetails(mealId)
    }

    fun getMealDeatailsByName (mealName: String) = viewModelScope.launch {
        _mealDetails.value = searchRepository.searchMealByName(mealName)
    }

    private fun  getAreaList () = viewModelScope.launch {
        _areaList.value = areaRepository.getAreaList()
    }

    private fun getCategories() = viewModelScope.launch {
        _categories.value = categoryRepository.getMealCategories()
    }

    private fun getIngredients() = viewModelScope.launch {
        _ingredients.value = ingredientRepository.getIngredients()
    }

}