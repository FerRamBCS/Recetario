package com.example.recetario.data

import com.google.gson.annotations.SerializedName

// Clase de respuesta para la lista de países
data class CountriesResponse(
    @SerializedName("meals") val meals: List<Country> // Lista de países
)

// Clase que representa un país
data class Country(
    @SerializedName("strArea") val strArea: String // Nombre del país
)
