package com.rachelleignacio.ledger.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "invoices",
        indices = [
            Index("id"),
            Index("date_created"),
            Index("pay_period_start_date"),
            Index("is_paid"),
            Index("client_id")
        ])
data class InvoiceDetail(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                         @ColumnInfo(name = "date_created") val dateCreated: Date = Date(),
                         @ColumnInfo(name = "pay_period_start_date") val payPeriodStartDate: Date = Date(),
                         @ColumnInfo(name = "pay_period_end_date") val payPeriodEndDate: Date = Date(),
                         @ColumnInfo(name = "client_id") val clientId: Int = 0,
                         @ColumnInfo(name = "is_paid") val isPaid: Boolean = false)