package com.example.marketcalculator.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marketcalculator.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
