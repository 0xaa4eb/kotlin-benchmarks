package com.xaa4eb.methods

import org.openjdk.jmh.annotations.*
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class TailrecMethodBenchmark {

    private var value: Long = 0

    @Setup
    open fun setup() {
        value = 30
    }

    @Benchmark
    fun factorial(): Long {
        return factorial(value)
    }

    @Benchmark
    fun tailrecFactorial(): Long {
        return tailrecFactorial(value)
    }

//    TailrecMethodBenchmark.factorial         avgt    2  28,865          ns/op
//    TailrecMethodBenchmark.tailrecFactorial  avgt    2  15,771          ns/op

    fun factorial(n: Long, accum: Long = 1): Long {
        val soFar = n * accum
        return if (n <= 1) {
            soFar
        } else {
            factorial(n - 1, soFar)
        }
    }

    tailrec fun tailrecFactorial(n: Long, accum: Long = 1): Long {
        val soFar = n * accum
        return if (n <= 1) {
            soFar
        } else {
            tailrecFactorial(n - 1, soFar)
        }
    }
}