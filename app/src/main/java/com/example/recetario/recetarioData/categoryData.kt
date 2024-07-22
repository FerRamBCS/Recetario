package com.example.recetario.recetarioData

import com.google.gson.annotations.SerializedName

data class categoryResponse(
    @SerializedName("categories") val categorias: List<Category>
)
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)
