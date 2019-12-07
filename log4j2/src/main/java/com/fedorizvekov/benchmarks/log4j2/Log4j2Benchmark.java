package com.fedorizvekov.benchmarks.log4j2;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class Log4j2Benchmark {

    public static void main(String[] args) throws RunnerException {

        var options = new OptionsBuilder()
                .include(Log4j2Logging.class.getSimpleName())
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
