package com.fedorizvekov.benchmarks.string;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class StringBenchmark {

    public static void main(String[] args) throws RunnerException {

        var options = new OptionsBuilder()
                .include(StringConcatenationInLoop.class.getSimpleName())
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
