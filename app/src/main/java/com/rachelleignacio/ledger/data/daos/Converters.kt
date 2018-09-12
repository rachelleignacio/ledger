package com.rachelleignacio.ledger.data.daos

import androidx.room.TypeConverter
import com.rachelleignacio.ledger.data.models.Unit

object Converters {

    @TypeConverter
    @JvmStatic
    fun unitTypeToString(unitType: Unit): String = unitType.type

    @TypeConverter
    @JvmStatic
    fun unitStringToType(unitString: String): Unit = if (unitString == Unit.HORSE.type) Unit.HORSE else Unit.HOUR
}