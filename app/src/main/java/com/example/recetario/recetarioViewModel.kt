package com.example.recetario

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.recetario.recetarioRepository.idMealRepository
import com.example.recetario.recetarioData.idMeal

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

    private val repository = idMealRepository(apiService)

    private val _mealDetails = MutableStateFlow<idMeal?>(null)
    val mealDetails: StateFlow<idMeal?> = _mealDetails

    init {
        getMealDetails()
    }

    private fun getMealDetails() = viewModelScope.launch {
        _mealDetails.value = repository.getMealDetails("53085")  // ID específico
    }
}