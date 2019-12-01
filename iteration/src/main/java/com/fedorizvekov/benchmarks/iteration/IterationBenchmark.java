package com.fedorizvekov.benchmarks.iteration;

import com.fedorizvekov.benchmarks.iteration.benchmark.ArrayIteration;
import com.fedorizvekov.benchmarks.iteration.benchmark.ArrayListIteration;
import com.fedorizvekov.benchmarks.iteration.benchmark.LinkedListIteration;
import com.fedorizvekov.benchmarks.iteration.benchmark.HashMapIteration;
import com.fedorizvekov.benchmarks.iteration.benchmark.HashSetIteration;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class IterationBenchmark {

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder()
                .include(ArrayIteration.class.getSimpleName())
                .include(ArrayListIteration.class.getSimpleName())
                .include(LinkedListIteration.class.getSimpleName())
                .include(HashSetIteration.class.getSimpleName())
                .include(HashMapIteration.class.getSimpleName())
                .warmupIterations(10)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .measurementTime(TimeValue.seconds(10))
                .forks(2)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

}
