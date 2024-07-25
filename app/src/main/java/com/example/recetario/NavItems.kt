package com.example.recetario

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen(val route: String, val id: String, val icon: ImageVector) {
    object Home : Screen("home", "home", Icons.Filled.Home)
    object Countries : Screen("countries", "countries", Icons.Filled.Place)
    object Categories : Screen("categories", "categories", Icons.Filled.Star)
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { MenuScreen(navController) }
        composable(route = "mealDetail/{mealId}") { parameter ->
            val mealId: String? = parameter.arguments?.getString("mealId")
            mealId?.let {
                MealDetailScreen(mealId = it, navController = navController)
            }
        }
        composable(Screen.Countries.route) { CountriesScreen(navController) }
        composable(Screen.Categories.route) { CategoriesScreen() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Countries,
        Screen.Categories
    )
    BottomNavigation {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = { Text(screen.id) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

    }
}

@Composable
fun CountriesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

    }
}

@Composable
fun CategoriesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "CATEGORIAS EPIC BRAND")
    }
}