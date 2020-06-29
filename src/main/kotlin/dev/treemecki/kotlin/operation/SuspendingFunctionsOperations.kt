package dev.threemecki.kotlin.coroutines.operation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

suspend fun performSuspendingFunctionsOperation() = coroutineScope {
    val time = measureTimeMillis {
        println("The answer is ${performIOAsyncOperations()}")
    }
    println("Completed in $time ms")
}

suspend fun performIOAsyncOperations(): Int = coroutineScope {
    val one = async { provideData01() }
    val two = async { provideData02() }
    one.await() + two.await()
}

suspend fun provideData01(): Int = withContext(Dispatchers.IO) {
    IOOperationSimulation().perform(1000)
    35
}

suspend fun provideData02(): Int = withContext(Dispatchers.IO) {
    IOOperationSimulation().perform(1000)
    65
}