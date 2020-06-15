package com.shashank.assingment.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object BaseUtils {
    const val INCOMING_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    const val DATE_TIME_FORMAT = "dd/MM/yyyy hh:mm aaa"

    fun convertSimpleDateFormatToReadableFormat(date: String): String {
        val format1 = SimpleDateFormat(INCOMING_DATE_FORMAT, Locale.getDefault())
        val format2 = SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault())
        Log.v("check Date" , date)
        val parsedDate = format1.parse(date)
        Log.v("check Date" , parsedDate.toString())
        return (format2.format(parsedDate))
    }
}