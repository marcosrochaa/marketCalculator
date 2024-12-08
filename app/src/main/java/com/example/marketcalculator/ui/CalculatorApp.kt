package com.example.marketcalculator.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
                calculatorViewModel = viewModel(),
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
                onViewProducts = { navController.navigate(Screen.SavedProducts.route) },
                navController = navController // Passando o navController
            )
        }
        composable(Screen.AddProduct.route) {
            AddProductScreen(
                onSaveProduct = { product ->
                    productViewModel.addProduct(product)
                    navController.popBackStack() // Voltar para a tela anterior
                },
                onCancel = { navController.popBackStack() } // Cancelar e voltar
            )
        }
        composable(Screen.SavedProducts.route) {

            val totalPrice = productViewModel.products.value.sumOf { it.price }

            SavedProductsScreen(
                totalPrice = totalPrice,
                products = productViewModel.products.value,
                onBackClick = { navController.popBackStack() },
                onDeleteProduct = { product ->
                    productViewModel.removeProduct(product)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorAppPreview() {
    CalculatorApp()
}




