package com.example.marketcalculator.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> get() = _products

    // Resultado da calculadora
    private val _calculatorResult = mutableStateOf<Double>(0.0)
    val calculatorResult: State<Double> get() = _calculatorResult

    fun addProduct(product: Product) {
        _products.value = _products.value + product
    }

    fun removeProduct(product: Product) {
        _products.value = _products.value - product
    }

    // Função para calcular o preço total dos produtos
    fun getTotalPrice(): Double {
        return _products.value.sumOf { it.price }
    }

    // Função para realizar as operações da calculadora
    fun calculate(operation: String, num1: Double, num2: Double) {
        val result = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> if (num2 != 0.0) num1 / num2 else Double.NaN
            else -> 0.0
        }
        _calculatorResult.value = result
    }
}


