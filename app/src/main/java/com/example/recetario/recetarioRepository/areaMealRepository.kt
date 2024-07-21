package com.example.recetario.recetarioRepository

import com.example.recetario.ApiService
import com.example.recetario.recetarioData.Area

class AreaMealRepository (private val apiService: ApiService){

    suspend fun  getAreaList(): List<Area>? {
        return try {
            val response = apiService.getAreaList()
            response.areaList // Devuelve la lista de áreas
        } catch (e: Exception) {
            null // Maneja el error según sea necesario
        }
    }
}