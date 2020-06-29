package dev.treemecki.test.kotlin.coroutines

import dev.threemecki.kotlin.coroutines.operation.buildFlow
import dev.threemecki.kotlin.coroutines.operation.performIOAsyncOperations
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CoroutinesTests {

    @Test
    fun asyncTest() {
        runBlocking {
            val ioResult = performIOAsyncOperations()
            Assertions.assertTrue(ioResult == 100)
        }
    }

    @Test
    fun flowTest() {
        runBlocking {
            val flowResult = buildFlow()
                .reduce { accumulator, value -> accumulator + value }
            Assertions.assertTrue(flowResult == 6)
        }
    }

}
