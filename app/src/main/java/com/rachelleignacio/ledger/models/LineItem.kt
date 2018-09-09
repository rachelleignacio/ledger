package com.rachelleignacio.ledger.models

import androidx.room.*

@Entity(tableName = "line_items",
        indices = [Index("id", "id"),
            Index("client_id", "client_id"),
            Index("invoice_id", "invoice_id")
        ],
        foreignKeys = [ForeignKey(entity = Client::class, parentColumns = ["id"], childColumns = ["client_id"]),
            ForeignKey(entity = Invoice::class, parentColumns = ["id"], childColumns = ["invoice_id"])
        ]
)
data class LineItem(@PrimaryKey(autoGenerate = true) val id: Int = -1,
                    @ColumnInfo(name = "unit_type") val unitType: Unit = Unit.HOUR,
                    @ColumnInfo(name = "billable_units") val billableUnits: Double = 0.0,
                    @ColumnInfo(name = "client_id") val clientId: Int = -1,
                    @ColumnInfo(name = "invoice_id") val invoiceId: Int = -1)