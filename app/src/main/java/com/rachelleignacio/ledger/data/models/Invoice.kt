package com.rachelleignacio.ledger.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "invoices",
        indices = [
            Index("id"),
            Index("is_paid"),
            Index("client_id")
        ])
data class Invoice(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                   @ColumnInfo(name = "client_id") val clientId: Int = 0,
                   @ColumnInfo(name = "is_paid") val isPaid: Boolean = false)