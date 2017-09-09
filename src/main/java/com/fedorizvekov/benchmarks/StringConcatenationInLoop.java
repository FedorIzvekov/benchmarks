package com.fedorizvekov.benchmarks;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@Fork(jvmArgsAppend = {"-Xms2G", "-Xmx2G"})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StringConcatenationInLoop {

    @Benchmark
    public String stringBuilder(Data data) {
        StringBuilder result = new StringBuilder();
        for (String element : data.stringArray) {
            result.append(element);
        }
        return result.toString();
    }


    @Benchmark
    public String stringBuilderWithCapacity(Data data) {
        StringBuilder result = new StringBuilder(data.stringArray.length);
        for (String element : data.stringArray) {
            result.append(element);
        }
        return result.toString();
    }


    @Benchmark
    public String stringBuffer(Data data) {
        StringBuffer result = new StringBuffer();
        for (String element : data.stringArray) {
            result.append(element);
        }
        return result.toString();
    }


    @Benchmark
    public String stringBufferWithCapacity(Data data) {
        StringBuffer result = new StringBuffer(data.stringArray.length);
        for (String element : data.stringArray) {
            result.append(element);
        }
        return result.toString();
    }


    @Benchmark
    public String stringJoiner(Data data) {
        StringJoiner result = new StringJoiner("");
        for (String element : data.stringArray) {
            result.add(element);
        }
        return result.toString();
    }


    @Benchmark
    public String stringStreamJoining(Data data) {
        String result = Arrays.stream(data.stringArray).collect(Collectors.joining());
        return result;
    }


    @Benchmark
    public String stringFormat(Data data) {
        String result = String.format("%s%s%s", data.stringArray);
        return result;
    }


    @Benchmark
    public String stringConcat(Data data) {
        String result = "";
        for (String element : data.stringArray) {
            result = result.concat(element);
        }
        return result;
    }


    @Benchmark
    public String operatorPlus(Data data) {
        String result = "";
        for (String element : data.stringArray) {
            result = result + element;
        }
        return result;
    }


    @State(Scope.Thread)
    public static class Data {

        String[] stringArray;

        @Setup
        public void setup() {
            stringArray = new String[]{"test123", "test456", "test789"};
        }

    }

}
