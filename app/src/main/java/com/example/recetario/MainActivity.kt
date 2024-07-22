package com.example.recetario

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: RecetarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí iría tu contenido de UI, si es necesario
        }


        //PRUEBA EN LOGCAT

        // Observa los cambios en el StateFlow
        lifecycleScope.launch {
            viewModel.mealDetails.collect { meal ->
                // Imprime los detalles del plato en la consola
                if (meal != null) {
                    Log.d(
                        "MainActivity",
                        "Meal Details: ${meal.strMeal}, ${meal.strCategory}, ${meal.strArea}, ${meal.strInstruction}"
                    )
                } else {
                    Log.d("MainActivity", "Meal details not found")
                }
            }
        }
        // Observa los cambios en el StateFlow para la lista de áreas
        lifecycleScope.launch {
            viewModel.areaList.collect { areas ->
                // Imprime la lista de áreas en la consola
                if (areas != null) {
                    Log.d("MainActivity", "Area List: ${areas.joinToString { it.name }}")
                } else {
                    Log.d("MainActivity", "Area list not found")
                }
            }
        }
        // Observa los cambios en el StateFlow para categorías
        lifecycleScope.launch {
            viewModel.categories.collect { categories ->
                if (categories != null) {
                    categories.forEach { category ->
                        Log.d(
                            "MainActivity",
                            "Category: ${category.strCategory}, ${category.strCategoryThumb}, ${category.strCategoryDescription}"
                        )
                    }
                } else {
                    Log.d("MainActivity", "Categories not found")
                }

            }

        }

    }
}


