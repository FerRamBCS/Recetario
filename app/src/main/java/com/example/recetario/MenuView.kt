package com.example.recetario

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.compose.AsyncImage
import com.example.recetario.data.Meal

@Composable
fun MenuScreen(nav: NavHostController, recetarioViewModel: RecetarioViewModel = viewModel()) {
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(searchQuery) {
        if (searchQuery.isNotEmpty()) {
            recetarioViewModel.getMealByName(searchQuery)
        } else {
            val mealIds = listOf("53085", "52870", "52819", "52765", "52774", "52998", "52823", "52869", "53082")
            recetarioViewModel.getMealsByIds(mealIds)
        }
    }

    val mealList by recetarioViewModel.mealsList.collectAsState()

    Column(modifier = Modifier.padding(15.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar recetas...") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(0.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(mealList) { meal ->
                MealItem(meal = meal) {
                    nav.navigate("mealDetail/${meal.idMeal}")
                }
            }
        }

    }
}

@Composable
fun MealItem(meal: Meal, onClick: () -> Unit) {
    Column(modifier = Modifier
        .padding(4.dp)
        .clickable { onClick() }) {

        AsyncImage(
            model = meal.strMealThumb,
            contentDescription = meal.strMeal,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )
        Text(text = meal.strMeal, style = MaterialTheme.typography.labelMedium, modifier = Modifier.padding(top = 8.dp))
    }
}





