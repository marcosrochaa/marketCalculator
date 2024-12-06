package com.example.marketcalculator.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marketcalculator.model.Product
import com.example.marketcalculator.model.ProductViewModel
import com.example.marketcalculator.model.Screen

@Composable
fun CalculatorApp() {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Calculator.route) {
        composable(Screen.Calculator.route) {
            CalculatorScreen(
                onSaveProduct = { productName, productPrice ->
                    if (productName != null && productPrice != null) {
                        // Salva o produto no ViewModel
                        productViewModel.addProduct(
                            Product(
                                name = productName,
                                price = productPrice,
                                purchaseDate = "Data Exemplo"
                            )
                        )
                    }
                },
                onViewProducts = { navController.navigate(Screen.SavedProducts.route) }
            )
        }
        composable(Screen.AddProduct.route) {
            AddProductScreen(
                onSaveProduct = { product ->
                    productViewModel.addProduct(product)
                    navController.popBackStack()
                },
                onCancel = { navController.popBackStack() }
            )
        }
        composable(Screen.SavedProducts.route) {
            SavedProductsScreen(
                products = productViewModel.products.value,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}




