package dev.treemecki.kotlin.functional.basic

val monthValidation = composeFunctions(
    ::isValidMonth,
    ::determineMonthInformation
)

fun <T, U, V> composeFunctions(g: (T) -> U, f: (U) -> V): (T) -> V =
    { f(g(it)) }

fun isValidMonth(month: String): Boolean =
    listOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    ).contains(month)

fun determineMonthInformation(isMonth: Boolean): String = if (isMonth) "Month validated" else "Invalid data"
