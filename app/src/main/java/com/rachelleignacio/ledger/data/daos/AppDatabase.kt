package com.rachelleignacio.ledger.data.daos

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rachelleignacio.ledger.data.models.Client
import com.rachelleignacio.ledger.data.models.InvoiceDetail
import com.rachelleignacio.ledger.data.models.LineItem

@Database(entities = [Client::class, LineItem::class, InvoiceDetail::class],
            version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun lineItemDao(): LineItemDao
}