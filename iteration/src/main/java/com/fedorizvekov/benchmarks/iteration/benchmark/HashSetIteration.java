package com.fedorizvekov.benchmarks.iteration.benchmark;

import static com.fedorizvekov.benchmarks.iteration.StringUtil.generate;
import static com.fedorizvekov.benchmarks.iteration.StringUtil.workingLoad;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
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
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@Fork(jvmArgsAppend = {"-Xms2G", "-Xmx2G"})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class HashSetIteration {


    @Benchmark
    public void forEach(Data data, Blackhole blackhole) {
        for (String element : data.set) {

            workingLoad(element, blackhole);

        }
    }


    @Benchmark
    public void whileIterator(Data data, Blackhole blackhole) {
        var iterator = data.set.iterator();

        while (iterator.hasNext()) {

            workingLoad(iterator.next(), blackhole);

        }

        blackhole.consume(iterator);
    }


    @Benchmark
    public void stream(Data data, Blackhole blackhole) {
        data.set.stream().forEach(element -> workingLoad(element, blackhole));

    }


    @Benchmark
    @Threads(2)
    public void parallelStream(Data data, Blackhole blackhole) {
        data.set.parallelStream().forEach(element -> workingLoad(element, blackhole));
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"15"})
        int stringLength;
        @Param({"10", "100", "1000", "10000"})
        int capacity;

        Set<String> set;

        @Setup
        public void setup() {
            set = Stream.generate(() -> generate(stringLength))
                    .limit(capacity)
                    .collect(Collectors.toSet());
        }

    }

}
