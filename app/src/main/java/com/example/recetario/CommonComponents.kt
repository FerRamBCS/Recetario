package com.example.recetario

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recetario.data.Category
//import com.example.recetario.data.Country
import com.example.recetario.data.Meal

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

@Composable
fun MealItemCountries(meal: Meal, onClick: () -> Unit) {
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
        Text(
            text = meal.strMeal,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}
@Composable
fun MealItemCategories(category: Category, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = category.strCategoryThumb,
            contentDescription = category.strCategory,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )
        Text(
            text = category.strCategory,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}