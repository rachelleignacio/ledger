package com.rachelleignacio.ledger.data.models

import androidx.room.*
import java.util.*

@Entity(tableName = "daily_line_items",
        indices = [
            (Index("id")),
            (Index("client_id")),
            (Index("invoice_id"))
        ],
        foreignKeys = [
            (ForeignKey(entity = Client::class, parentColumns = ["id"], childColumns = ["client_id"])),
            (ForeignKey(entity = InvoiceDetail::class, parentColumns = ["id"], childColumns = ["invoice_id"]))
        ])
data class DailyLineItem(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                 @ColumnInfo val date: Date = Date(),
                 @ColumnInfo val description: String = "",
                 @ColumnInfo(name = "unit_type") val unitType: Unit = Unit.HORSE,
                 @ColumnInfo(name = "client_id") val clientId: Int = 0,
                 @ColumnInfo(name = "rate_per_unit") val ratePerUnit: Double = 1.0,
                 @ColumnInfo(name = "billable_units") val billableUnits: Double = 0.0,
                 @ColumnInfo(name = "invoice_id") val invoiceId: Int = 0)