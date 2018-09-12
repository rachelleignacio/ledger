package com.rachelleignacio.ledger.data

import android.content.Context
import androidx.room.Room
import com.rachelleignacio.ledger.data.daos.AppDatabase

private const val DATABASE_NAME = "database"

object DataRepository {
    lateinit var appDatabase: AppDatabase

    fun init(context: Context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }
}