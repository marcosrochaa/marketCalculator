package com.example.marketcalculator.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var instance: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            val tempInstance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "product_database"
            ).build()
            instance = tempInstance
            tempInstance
        }
    }
}
