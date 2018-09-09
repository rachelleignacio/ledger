package com.rachelleignacio.ledger.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "clients",
        indices = [Index("id"), Index("name")]
)
data class Client(@PrimaryKey(autoGenerate = true) val id: Int = -1,
                  val name: String = "",
                  @ColumnInfo(name = "rate_per_horse") val ratePerHorse: Double = 1.0,
                  @ColumnInfo(name = "rate_per_hour") val ratePerHour: Double = 1.0)