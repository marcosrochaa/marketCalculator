package com.example.marketcalculator.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> get() = _products

    fun addProduct(product: Product) {
        _products.value = _products.value + product
    }

    fun removeProduct(product: Product) {
        _products.value = _products.value - product
    }
}

