package com.example.recetario.repository

import com.example.recetario.ApiService
import com.example.recetario.data.Country

class CountriesRepository(private val apiService: ApiService) {

    // Función suspendida para obtener la lista de países
    suspend fun getCountries(): List<Country>? {
        return try {
            // Hacemos la llamada a la API usando la función suspendida
            val response = apiService.getCountries()
            // Retornamos la lista de países
            response.meals
        } catch (e: Exception) {
            // En caso de excepción, retornamos null
            null
        }
    }
}
