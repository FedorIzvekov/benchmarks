package com.fedorizvekov.benchmarks.random.integer;

import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
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
public class JdkRandom {


    @Benchmark
    public void random(Data data, Blackhole blackhole) {
        var number = data.random.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @Benchmark
    public void splittableRandom(Data data, Blackhole blackhole) {
        var number = data.splittableRandom.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @Benchmark
    public void threadLocalRandom(Data data, Blackhole blackhole) {
        var number = data.threadLocalRandom.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @Benchmark
    public void secureRandom(Data data, Blackhole blackhole) {
        var number = data.secureRandom.nextInt(data.rangeMin, data.rangeMax + 1);
        blackhole.consume(number);
    }


    @Benchmark
    public void mathRandom(Data data, Blackhole blackhole) {
        var number = data.rangeMin + (int) (Math.random() * ((data.rangeMax + 1) - data.rangeMin));
        blackhole.consume(number);
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"1"})
        int rangeMin;
        @Param({"10", "100", "1000", "10000"})
        int rangeMax;

        Random random;
        SplittableRandom splittableRandom;
        ThreadLocalRandom threadLocalRandom;
        SecureRandom secureRandom;

        @Setup
        public void setup() {
            random = new Random(); // pseudo-random
            splittableRandom = new SplittableRandom(); // pseudo-random
            threadLocalRandom = ThreadLocalRandom.current(); // pseudo-random
            secureRandom = new SecureRandom();  // cryptographically strong pseudo-random
        }

    }

}
