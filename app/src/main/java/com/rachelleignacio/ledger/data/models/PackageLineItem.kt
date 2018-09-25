package com.rachelleignacio.ledger.data.models

import androidx.room.*

@Entity(tableName = "package_line_items",
        indices = [
            (Index("id")),
            (Index("client_id")),
            (Index("units_remaining"))
        ],
        foreignKeys = [(ForeignKey(entity = Client::class, parentColumns = ["id"], childColumns = ["client_id"]))])
data class PackageLineItem(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                   @ColumnInfo(name = "unit_type") val unitType: Unit = Unit.HOUR,
                   @ColumnInfo(name = "client_id") val clientId: Int = 0,
                   @ColumnInfo(name = "total_units") val totalUnits: Int = 0,
                   @ColumnInfo(name = "units_remaining") val unitsRemaining: Int = 0)