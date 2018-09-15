package com.rachelleignacio.ledger.data.models

import androidx.room.*
import java.util.*

sealed class LineItem {
    @Entity(tableName = "daily_line_items",
            indices = [
                Index("id"),
                Index("client_id"),
                Index("is_paid"),
                Index("invoice_id")
            ],
            foreignKeys = [
                ForeignKey(entity = Client::class, parentColumns = ["id"], childColumns = ["client_id"]),
                ForeignKey(entity = Invoice::class, parentColumns = ["id"], childColumns = ["invoice_id"])
            ])
    data class DailyLineItem(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                             @ColumnInfo val date: Date = Date(),
                             @ColumnInfo val description: String = "",
                             @ColumnInfo(name = "unit_type") val unitType: Unit = Unit.HORSE,
                             @ColumnInfo(name = "client_id") val clientId: Int = 0,
                             @ColumnInfo(name = "rate_per_unit") val ratePerUnit: Double = 1.0,
                             @ColumnInfo(name = "billable_units") val billableUnits: Double = 0.0,
                             @ColumnInfo(name = "is_paid") val isPaid: Boolean = false,
                             @ColumnInfo(name = "invoice_id") val invoiceId: Int = 0) : LineItem()

    @Entity(tableName = "package_line_items",
            indices = [
                Index("id"),
                Index("client_id"),
                Index("units_remaining")
            ],
            foreignKeys = [ForeignKey(entity = Client::class, parentColumns = ["id"], childColumns = ["client_id"])])
    data class PackageLineItem(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                               @ColumnInfo(name = "unit_type") val unitType: Unit = Unit.HOUR,
                               @ColumnInfo(name = "client_id") val clientId: Int = 0,
                               @ColumnInfo(name = "total_units") val totalUnits: Int = 0,
                               @ColumnInfo(name = "units_remaining") val unitsRemaining: Int = 0)
}

