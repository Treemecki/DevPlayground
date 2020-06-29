package dev.threemecki.kotlin.coroutines.operation

class IOOperationSimulation() {

    fun perform(millis: Long) {
        Thread.sleep(millis)
    }

}