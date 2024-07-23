package com.example.recetario

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.recetario.data.Meal
import com.example.recetario.data.MealDetail

@Composable
fun MenuScreen(recetarioViewModel: RecetarioViewModel = viewModel()) {
    val mealList by recetarioViewModel.mealsList.collectAsState()
    Column(modifier = Modifier.padding(15.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(0.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(mealList) { meal ->
                MealItem(meal = meal)
            }
        }
    }
}

@Composable
fun MealItem(meal: Meal) {
    Column {
        AsyncImage(
            model = meal.strMealThumb,
            contentDescription = meal.strMeal,
            modifier = Modifier.padding(4.dp)
        )
    }
}
