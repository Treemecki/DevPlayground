package dev.treemecki.kotlin.common

import java.text.SimpleDateFormat
import java.util.*

fun currentTime(withMillis: Boolean = false): String {
    val pattern = if (withMillis) "dd/M/yyyy hh:mm:ss.SSS" else "dd/M/yyyy hh:mm:ss"
    val format = SimpleDateFormat(pattern)
    return format.format(Date())
}
