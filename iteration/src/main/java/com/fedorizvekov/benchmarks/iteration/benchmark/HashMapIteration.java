package com.fedorizvekov.benchmarks.iteration.benchmark;

import static com.fedorizvekov.benchmarks.iteration.StringUtil.generate;
import static com.fedorizvekov.benchmarks.iteration.StringUtil.workingLoad;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@Fork(jvmArgsAppend = {"-Xms2G", "-Xmx2G"})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class HashMapIteration {


    @Benchmark
    public void for1(Data data, Blackhole blackhole) {
        for (int count = 0; count < data.map.size(); count++) {

            workingLoad(data.map.get(count), blackhole);

        }
    }


    @Benchmark
    public void forEach(Data data, Blackhole blackhole) {
        for (String element : data.map.values()) {

            workingLoad(element, blackhole);

        }
    }


    @Benchmark
    public void while1(Data data, Blackhole blackhole) {
        var count = 0;

        while (count < data.map.size()) {

            workingLoad(data.map.get(count), blackhole);
            count++;

        }

        blackhole.consume(count);
    }


    @Benchmark
    public void whileIterator(Data data, Blackhole blackhole) {
        var iterator = data.map.values().iterator();

        while (iterator.hasNext()) {

            workingLoad(iterator.next(), blackhole);

        }

        blackhole.consume(iterator);
    }


    @Benchmark
    public void stream(Data data, Blackhole blackhole) {
        data.map.values().stream().forEach(element -> workingLoad(element, blackhole));
    }


    @Benchmark
    @Threads(2)
    public void parallelStream(Data data, Blackhole blackhole) {
        data.map.values().parallelStream().forEach(element -> workingLoad(element, blackhole));
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"15"})
        int stringLength;
        @Param({"10", "100", "1000", "10000"})
        int capacity;

        Map<Integer, String> map;

        @Setup
        public void setup() {
            map = IntStream.range(0, capacity)
                    .boxed()
                    .collect(Collectors.toMap(
                            Function.identity(),
                            key -> generate(stringLength)
                    ));
        }

    }

}
