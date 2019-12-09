package com.fedorizvekov.benchmarks.logback;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.apache.log4j.LogManager;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.slf4j.LoggerFactory;

@BenchmarkMode(Mode.AverageTime)
@Fork(jvmArgsAppend = {"-Xms2G", "-Xmx2G"})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LogbackLogging {

    @Benchmark
    public void slf4jInfoConcatenation(Data data) {
        data.slf4j.info(UUID.randomUUID() + data.messages[0] + data.messages[1] + data.messages[2] + data.messages[3]);
    }


    @Benchmark
    public void slf4jInfoPlaceholder(Data data) {
        data.slf4j.info(data.placeholder, UUID.randomUUID(), data.messages[0], data.messages[1], data.messages[2], data.messages[3]);
    }


    @Benchmark
    public void slf4jErrorConcatenation(Data data) {
        data.slf4j.error(UUID.randomUUID() + data.messages[0] + data.messages[1] + data.messages[2] + data.messages[3]);
    }


    @Benchmark
    public void slf4jErrorPlaceholder(Data data) {
        data.slf4j.error(data.placeholder, UUID.randomUUID(), data.messages[0], data.messages[1], data.messages[2], data.messages[3]);
    }


    @Benchmark
    public void log4j2InfoConcatenation(Data data) {
        data.log4j2.info(UUID.randomUUID() + data.messages[0] + data.messages[1] + data.messages[2] + data.messages[3]);
    }


    @Benchmark
    public void log4j2ErrorConcatenation(Data data) {
        data.log4j2.error(UUID.randomUUID() + data.messages[0] + data.messages[1] + data.messages[2] + data.messages[3]);
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"15"})
        int stringLength;
        int messageCount = 4;

        org.slf4j.Logger slf4j;
        org.apache.log4j.Logger log4j2;

        String[] messages;
        String placeholder;


        @Setup
        public void setup() {
            slf4j = LoggerFactory.getLogger(LogbackLogging.class);
            log4j2 = LogManager.getLogger(LogbackLogging.class);

            messages = Stream.generate(() -> StringUtil.generate(stringLength))
                    .limit(messageCount)
                    .toArray(String[]::new);

            placeholder = "{}".repeat(messageCount + 1);
        }

    }

}
