package dev.treemecki.test.kotlin.functional

import dev.treemecki.kotlin.functional.arrow.Information
import dev.treemecki.kotlin.functional.arrow.Person
import dev.treemecki.kotlin.functional.arrow.writeEmailInformation
import dev.treemecki.kotlin.functional.basic.informationBuilder
import dev.treemecki.kotlin.functional.basic.monthValidation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class FunctionalTests {

    @Test
    fun closureTest() {
        val infoBuilder = informationBuilder("PREFIX ")(5)
        val information = infoBuilder("txt01") + infoBuilder("txt02")
        Assertions.assertTrue(information == "PREFIX txt01 txt01 txt01 txt01 txt01 PREFIX txt02 txt02 txt02 txt02 txt02 ")
    }

    @Test
    fun compositionTest() {
        val validMonthInfo = monthValidation("May")
        val invalidMonthInfo = monthValidation("Mayy")
        assertAll(
            "monthsValidation",
            { Assertions.assertTrue(validMonthInfo == "Month validated") },
            { Assertions.assertTrue(invalidMonthInfo == "Invalid data") }
        )
    }

    @Test
    fun eitherTest() {
        val emailInformation01 = writeEmailInformation(
            Person(
                "Adam",
                "adam@box.com"
            ), Information("Test")
        )
        val emailInformation02 = writeEmailInformation(
            Person(
                "John",
                ""
            ), Information("Test")
        )
        val emailInformation03 = writeEmailInformation(
            Person(
                "Eva",
                "eva@box.com"
            ), Information("Test".repeat(30))
        )
        assertAll(
            "monthsValidation",
            { Assertions.assertTrue(emailInformation01.isRight()) },
            { Assertions.assertTrue(emailInformation02.isLeft()) },
            { Assertions.assertTrue(emailInformation03.isLeft()) }
        )
    }

}