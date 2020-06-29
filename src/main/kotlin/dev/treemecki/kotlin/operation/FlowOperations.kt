package dev.threemecki.kotlin.coroutines.operation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun buildFlow(): Flow<Int> = flow<Int> {
    for (i in 1..3) {
        IOOperationSimulation().perform(500)
        emit(i)
    }
}.flowOn(Dispatchers.IO)
