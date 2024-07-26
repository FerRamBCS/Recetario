package com.example.recetario

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

fun YouTubeLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Composable
fun CategoriesScreen(navController: NavController, recetarioViewModel: RecetarioViewModel = viewModel()) {
    val categoriesList by recetarioViewModel.categoriesList.collectAsState()
    val context = LocalContext.current

    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f) // Para que el grid ocupe todo el espacio disponible
        ) {
            items(categoriesList) { category ->
                MealItemCategories(category = category) {
                    navController.navigate("categories")
                }
            }
        }

        // Agrega el botón al final de la columna
        Button(
            onClick = { YouTubeLink(context, "https://www.youtube.com/watch?v=dQw4w9WgXcQ") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Abrir YouTube")
        }
    }
}
