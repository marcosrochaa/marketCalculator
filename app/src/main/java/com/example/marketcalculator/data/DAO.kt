package com.example.marketcalculator.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.marketcalculator.model.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM product_table")
    suspend fun getAllProducts(): List<Product>

    @Delete
    suspend fun deleteProduct(product: Product)
}
