package com.fedorizvekov.benchmarks.random.integer;

import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.random.ISAACRandom;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.Well512a;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@Fork(jvmArgsAppend = {"-Xms2G", "-Xmx2G"})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Math3Random {


    @Benchmark
    public void well512aRandom(Data data, Blackhole blackhole) {
        var number = data.rangeMin + data.well512a.nextInt(data.rangeMax + 1 - data.rangeMin);
        blackhole.consume(number);
    }


    @Benchmark
    public void mersenneTwisterRandom(Data data, Blackhole blackhole) {
        var number = data.rangeMin + data.mersenneTwister.nextInt(data.rangeMax + 1 - data.rangeMin);
        blackhole.consume(number);
    }


    @Benchmark
    public void isaacRandom(Data data, Blackhole blackhole) {
        var number = data.rangeMin + data.isaacRandom.nextInt(data.rangeMax + 1 - data.rangeMin);
        blackhole.consume(number);
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"1"})
        int rangeMin;
        @Param({"10", "100", "1000", "10000"})
        int rangeMax;

        Well512a well512a;                  // (Well Equidistributed Long-period Linear)
        MersenneTwister mersenneTwister;
        ISAACRandom isaacRandom;            // (Indirection, Shift, Accumulate, Add, Count).


        @Setup
        public void setup() {
            well512a = new Well512a();
            mersenneTwister = new MersenneTwister();
            isaacRandom = new ISAACRandom();
        }

    }

}
