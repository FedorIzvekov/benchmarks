package com.fedorizvekov.benchmarks.iteration.benchmark;

import static com.fedorizvekov.benchmarks.iteration.StringUtil.generate;
import static com.fedorizvekov.benchmarks.iteration.StringUtil.workingLoad;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
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
public class ArrayIteration {


    @Benchmark
    public void for1(Data data, Blackhole blackhole) {
        for (int count = 0; count < data.array.length; count++) {

            workingLoad(data.array[count], blackhole);

        }
    }


    @Benchmark
    public void forEach(Data data, Blackhole blackhole) {
        for (String element : data.array) {

            workingLoad(element, blackhole);

        }
    }


    @Benchmark
    public void while1(Data data, Blackhole blackhole) {
        var count = 0;

        while (count < data.array.length) {

            workingLoad(data.array[count], blackhole);
            count++;

        }

        blackhole.consume(count);
    }


    @Benchmark
    public void stream(Data data, Blackhole blackhole) {
        Stream.of(data.array).forEach(element -> workingLoad(element, blackhole));
    }


    @Benchmark
    public void parallelStream(Data data, Blackhole blackhole) {
        Stream.of(data.array).parallel().forEach(element -> workingLoad(element, blackhole));
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"15"})
        int stringLength;
        @Param({"10", "100", "1000"})
        int capacity;

        String[] array;

        @Setup
        public void setup() {
            array = Stream.generate(() -> generate(stringLength))
                    .limit(capacity)
                    .toArray(String[]::new);
        }

    }

}
