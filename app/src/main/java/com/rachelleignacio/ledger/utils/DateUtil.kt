package com.rachelleignacio.ledger.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    private val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    fun dateToString(date: Date) = dateFormat.format(date)
    fun stringToDate(dateString: String): Date = dateFormat.parse(dateString)
}