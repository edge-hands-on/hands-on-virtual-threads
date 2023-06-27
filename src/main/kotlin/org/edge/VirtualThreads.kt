package org.edge

import java.util.concurrent.Executors


fun main() {
    val task = Runnable {
        println("Start ${Thread.currentThread()}")
        repeat(10) {
            Thread.sleep(1000)
            println("Working ${Thread.currentThread()}")
        }
        println("End ${Thread.currentThread()}")
    }
    val executorService = Executors.newVirtualThreadPerTaskExecutor()
    //val executorService = Executors.newFixedThreadPool(10)

    val tasks = (1..10)
        .map { executorService.submit(task) }
        .toList()

    tasks.forEach { it.get() }
}