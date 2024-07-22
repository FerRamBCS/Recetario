package com.example.recetario

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recetario.recetarioData.idMeal
import androidx.compose.foundation.lazy.grid.items



@Composable
fun inicioScreen(recetarioViewModel: RecetarioViewModel = viewModel()){
    val meals by recetarioViewModel.mealDetails.collectAsState()
    Column (Modifier.padding(15.dp)){
        LazyVerticalGrid(
            columns = GridCells.Fixed (count = 3),
            contentPadding = PaddingValues(0.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp),
            horizontalArrangement = Arrangement.spacedBy(0.dp)) {

            items (meals) { meal ->
                MealItem(meal = meal)
            }
        }
    }
}


@Composable
fun MealItem(meal: idMeal){
    Card {
        Column {
            Text(text = meal.strMeal)
            Text(text = meal.strCategory)
            Text(text = meal.strArea)
            Text(text = meal.strInstruction)
        }
    }
}