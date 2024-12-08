package com.example.marketcalculator.extensions

import java.text.NumberFormat
import java.util.Locale

fun formatPrice(price: Double): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return formatter.format(price)
}
