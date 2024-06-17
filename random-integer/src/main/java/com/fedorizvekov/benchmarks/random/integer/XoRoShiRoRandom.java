package com.fedorizvekov.benchmarks.random.integer;

import java.util.concurrent.TimeUnit;
import it.unimi.dsi.util.SplitMix64Random;
import it.unimi.dsi.util.XoRoShiRo128PlusPlusRandom;
import it.unimi.dsi.util.XoRoShiRo128PlusRandom;
import it.unimi.dsi.util.XoRoShiRo128StarStarRandom;
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
public class XoRoShiRoRandom {


    @Benchmark
    public void splitMix64Random(Data data, Blackhole blackhole) {
        var number = data.splitMix64Random.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @Benchmark
    public void xoRoShiRo128PlusRandom(Data data, Blackhole blackhole) {
        var number = data.xoRoShiRo128PlusRandom.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @Benchmark
    public void xoRoShiRo128PlusPlusRandom(Data data, Blackhole blackhole) {
        var number = data.xoRoShiRo128PlusPlusRandom.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @Benchmark
    public void xoRoShiRo128StarStarRandom(Data data, Blackhole blackhole) {
        var number = data.xoRoShiRo128StarStarRandom.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"1"})
        int rangeMin;
        @Param({"10", "100", "1000", "10000"})
        int rangeMax;

        // XoRoShiRo (XOR/rotate/shift/rotate) generators
        SplitMix64Random splitMix64Random;
        XoRoShiRo128PlusRandom xoRoShiRo128PlusRandom;
        XoRoShiRo128PlusPlusRandom xoRoShiRo128PlusPlusRandom;
        XoRoShiRo128StarStarRandom xoRoShiRo128StarStarRandom;


        @Setup
        public void setup() {
            splitMix64Random = new SplitMix64Random();
            xoRoShiRo128PlusRandom = new XoRoShiRo128PlusRandom();
            xoRoShiRo128PlusPlusRandom = new XoRoShiRo128PlusPlusRandom();
            xoRoShiRo128StarStarRandom = new XoRoShiRo128StarStarRandom();
        }

    }

}
