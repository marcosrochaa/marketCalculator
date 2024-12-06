package com.example.marketcalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,
    val purchaseDate: String // Este é o campo que vai armazenar a data da compra
)
