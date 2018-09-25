package com.rachelleignacio.ledger.data.daos

import androidx.room.TypeConverter
import com.rachelleignacio.ledger.data.models.Unit
import com.rachelleignacio.ledger.utils.DateUtil
import java.util.*

object Converters {

    @TypeConverter
    @JvmStatic
    fun unitTypeToString(unitType: Unit) = unitType.type

    @TypeConverter
    @JvmStatic
    fun unitStringToType(unitString: String) = if (unitString == Unit.HORSE.type) Unit.HORSE else Unit.HOUR

    @TypeConverter
    @JvmStatic
    fun dateToString(date: Date) = DateUtil.dateToString(date)

    @TypeConverter
    @JvmStatic
    fun stringToDate(dateString: String) = DateUtil.stringToDate(dateString)
}