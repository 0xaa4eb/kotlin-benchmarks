package com.xaa4eb.methods

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class InlineMethodBenchmark {

    @Setup
    open fun setup() {

    }

    @Benchmark
    fun withoutInlineMethod(): Int {
        return addFiveDefault { 42 }
    }

    @Benchmark
    fun withInlineMethod(): Int {
        return addFiveInline { 42 }
    }

    private inline fun addFiveInline(body: () -> Int): Int {
        return body() + 5
    }

    private fun addFiveDefault(body: () -> Int): Int {
        return body() + 5
    }
}