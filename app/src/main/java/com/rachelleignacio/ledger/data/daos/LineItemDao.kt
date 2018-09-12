package com.rachelleignacio.ledger.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.rachelleignacio.ledger.data.models.LineItem

@Dao
interface LineItemDao {
    @Insert
    fun addLineItem(newLineItem: LineItem)

    @Update
    fun updateLineItem(lineItem: LineItem)
}