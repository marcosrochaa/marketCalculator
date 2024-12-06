package com.example.marketcalculator.model

sealed class Screen(val route: String) {
    object Calculator : Screen("calculator")
    object SavedProducts : Screen("saved_products")
    object AddProduct : Screen("add_product")
}
