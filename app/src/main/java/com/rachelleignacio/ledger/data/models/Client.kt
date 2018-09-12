package com.rachelleignacio.ledger.data.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "clients",
        indices = [Index("id"), Index("name")]
)
data class Client(@PrimaryKey(autoGenerate = true) val id: Int = -1,
                  val name: String = "")