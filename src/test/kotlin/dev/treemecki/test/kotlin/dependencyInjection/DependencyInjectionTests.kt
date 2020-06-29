package dev.treemecki.test.kotlin.dependencyInjection

import dev.treemecki.kotlin.dependencyInjection.builder.buildDataDecorator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class DependencyInjectionTests {

    @Test
    fun kodeinDependencyInjectionTest() {
        val andrewInfo = buildDataDecorator("AndrewConst")
            .decorate()
        val johnInfo = buildDataDecorator("JohnConst")
            .decorate()
        assertAll(
            "dependencyInjection",
            { Assertions.assertTrue(andrewInfo == "> Andrew: Hello") },
            { Assertions.assertTrue(johnInfo == "> John: Hello") }
        )
    }

}
