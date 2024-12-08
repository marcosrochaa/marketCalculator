package com.example.marketcalculator.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatData(date: String): String {
    val originalFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US) // Ajuste conforme necessário
    val targetFormat = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
    val dateObject: Date = originalFormat.parse(date)!!
    return targetFormat.format(dateObject)
}
