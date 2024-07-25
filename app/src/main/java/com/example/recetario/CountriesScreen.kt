package com.example.recetario

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun CountriesScreen(navController: NavHostController, recetarioViewModel: RecetarioViewModel = viewModel()) {

    val countriesList by recetarioViewModel.countriesList.collectAsState()

    LaunchedEffect(Unit) {
        val mealIds = listOf("53085", "52870", "52819", "52765", "52774", "52998", "52823", "52869", "53082")
        recetarioViewModel.getMealsByIds(mealIds)
    }

    val meals by recetarioViewModel.mealsList.collectAsState()
    val groupedMeals = countriesList.groupBy { it.strArea }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        groupedMeals.forEach { (country) ->
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = country,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(meals) { meal ->
                MealItemCountries(meal = meal) {
                    navController.navigate("mealDetail/${meal.idMeal}")
                }
            }
        }
    }
}


