package com.example.marketcalculator.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marketcalculator.model.Product
import com.example.marketcalculator.model.Screen

@Composable
fun CalculatorApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Calculator.route) {
        composable(Screen.Calculator.route) {
            CalculatorScreen(
                onSaveProduct = { _, _ -> navController.navigate(Screen.AddProduct.route) },
                onViewProducts = { navController.navigate(Screen.SavedProducts.route) }
            )
        }
        composable(Screen.SavedProducts.route) {
            SavedProductsScreen(
                products = listOf(
                    Product("Arroz", 19.99, "06/12/2024"),
                    Product("Feijão", 7.49, "06/12/2024")
                ),
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.AddProduct.route) {
            AddProductScreen(
                onSaveProduct = { product ->
                    // TODO: Salvar produto no ViewModel ou banco de dados
                    navController.popBackStack() // Voltar à tela anterior
                },
                onCancel = { navController.popBackStack() }
            )
        }
    }
}

