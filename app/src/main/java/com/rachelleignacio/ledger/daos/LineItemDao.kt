package com.rachelleignacio.ledger.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.rachelleignacio.ledger.models.LineItem

@Dao
interface LineItemDao {
    @Insert
    fun addLineItem(newLineItem: LineItem)

    @Update
    fun updateLineItem(lineItem: LineItem)
}