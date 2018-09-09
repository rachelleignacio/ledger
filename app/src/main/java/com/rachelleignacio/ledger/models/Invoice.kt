package com.rachelleignacio.ledger.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "invoices",
        indices = [Index("id"), Index("is_paid"), (Index("client_id"))])
data class Invoice(@PrimaryKey(autoGenerate = true) val id: Int = -1,
                   @ColumnInfo(name = "client_id") val clientId: Int = -1,
                   @ColumnInfo(name = "is_paid") val isPaid: Boolean = false)