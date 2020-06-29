package dev.treemecki.kotlin.functional.basic

fun informationBuilder(prefix: String): (Int) -> (String) -> String {
    val separator = " "
    return fun(numberOfRepetitions: Int): (String) -> String {
        return { x: String -> prefix + x.plus(separator).repeat(numberOfRepetitions) }
    }
}
