package com.xaa4eb.methods

import org.openjdk.jmh.annotations.*
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class SpreadOperatorBenchmark {

    private lateinit var arrayWith20Items: IntArray

    private lateinit var arrayWith1Item: IntArray

    @Setup(Level.Iteration)
    open fun setup() {
        arrayWith20Items = intArrayOf(
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt(),
                ThreadLocalRandom.current().nextInt()
        )

        arrayWith1Item = intArrayOf(ThreadLocalRandom.current().nextInt())
    }

    @Benchmark
    fun benchmarkWith1Item() {
        acceptVararg(*arrayWith1Item)
    }

    @Benchmark
    fun benchmarkWith20Items() {
        acceptVararg(*arrayWith20Items)
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private fun acceptVararg(vararg xs: Int) {

    }
}