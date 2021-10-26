package com.fedorizvekov.benchmarks.string;

import static org.openjdk.jmh.annotations.CompilerControl.Mode.EXCLUDE;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
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
public class StringConcatenation {

    @Benchmark
    public void operatorPlus10(Data data, Blackhole blackhole) {

        var result = data.stringArray[0] + data.stringArray[1] + data.stringArray[2] + data.stringArray[3] + data.stringArray[4]
                + data.stringArray[5] + data.stringArray[6] + data.stringArray[7] + data.stringArray[8] + data.stringArray[9];

        blackhole.consume(result);
    }


    @Benchmark
    public void operatorPlus50(Data data, Blackhole blackhole) {

        var result = data.stringArray[0] + data.stringArray[1] + data.stringArray[2] + data.stringArray[3] + data.stringArray[4]
                + data.stringArray[5] + data.stringArray[6] + data.stringArray[7] + data.stringArray[8] + data.stringArray[9]
                + data.stringArray[10] + data.stringArray[11] + data.stringArray[12] + data.stringArray[13] + data.stringArray[14]
                + data.stringArray[15] + data.stringArray[16] + data.stringArray[17] + data.stringArray[18] + data.stringArray[19]
                + data.stringArray[20] + data.stringArray[21] + data.stringArray[22] + data.stringArray[23] + data.stringArray[24]
                + data.stringArray[25] + data.stringArray[26] + data.stringArray[27] + data.stringArray[28] + data.stringArray[29]
                + data.stringArray[30] + data.stringArray[31] + data.stringArray[32] + data.stringArray[33] + data.stringArray[34]
                + data.stringArray[35] + data.stringArray[36] + data.stringArray[37] + data.stringArray[38] + data.stringArray[39]
                + data.stringArray[40] + data.stringArray[41] + data.stringArray[42] + data.stringArray[43] + data.stringArray[44]
                + data.stringArray[45] + data.stringArray[46] + data.stringArray[47] + data.stringArray[48] + data.stringArray[49];

        blackhole.consume(result);
    }


    @Benchmark
    public void operatorPlus100(Data data, Blackhole blackhole) {

        var result = data.stringArray[0] + data.stringArray[1] + data.stringArray[2] + data.stringArray[3] + data.stringArray[4]
                + data.stringArray[5] + data.stringArray[6] + data.stringArray[7] + data.stringArray[8] + data.stringArray[9]
                + data.stringArray[10] + data.stringArray[11] + data.stringArray[12] + data.stringArray[13] + data.stringArray[14]
                + data.stringArray[15] + data.stringArray[16] + data.stringArray[17] + data.stringArray[18] + data.stringArray[19]
                + data.stringArray[20] + data.stringArray[21] + data.stringArray[22] + data.stringArray[23] + data.stringArray[24]
                + data.stringArray[25] + data.stringArray[26] + data.stringArray[27] + data.stringArray[28] + data.stringArray[29]
                + data.stringArray[30] + data.stringArray[31] + data.stringArray[32] + data.stringArray[33] + data.stringArray[34]
                + data.stringArray[35] + data.stringArray[36] + data.stringArray[37] + data.stringArray[38] + data.stringArray[39]
                + data.stringArray[40] + data.stringArray[41] + data.stringArray[42] + data.stringArray[43] + data.stringArray[44]
                + data.stringArray[45] + data.stringArray[46] + data.stringArray[47] + data.stringArray[48] + data.stringArray[49]
                + data.stringArray[50] + data.stringArray[51] + data.stringArray[52] + data.stringArray[53] + data.stringArray[54]
                + data.stringArray[55] + data.stringArray[56] + data.stringArray[57] + data.stringArray[58] + data.stringArray[59]
                + data.stringArray[60] + data.stringArray[61] + data.stringArray[62] + data.stringArray[63] + data.stringArray[64]
                + data.stringArray[65] + data.stringArray[66] + data.stringArray[67] + data.stringArray[68] + data.stringArray[69]
                + data.stringArray[70] + data.stringArray[71] + data.stringArray[72] + data.stringArray[73] + data.stringArray[74]
                + data.stringArray[75] + data.stringArray[76] + data.stringArray[77] + data.stringArray[78] + data.stringArray[79]
                + data.stringArray[80] + data.stringArray[81] + data.stringArray[82] + data.stringArray[83] + data.stringArray[84]
                + data.stringArray[85] + data.stringArray[86] + data.stringArray[87] + data.stringArray[88] + data.stringArray[89]
                + data.stringArray[90] + data.stringArray[91] + data.stringArray[92] + data.stringArray[93] + data.stringArray[94]
                + data.stringArray[95] + data.stringArray[96] + data.stringArray[97] + data.stringArray[98] + data.stringArray[99];

        blackhole.consume(result);
    }


    @Benchmark
    @CompilerControl(EXCLUDE)
    public void operatorPlusWithoutJit10(Data data, Blackhole blackhole) {

        var result = data.stringArray[0] + data.stringArray[1] + data.stringArray[2] + data.stringArray[3] + data.stringArray[4]
                + data.stringArray[5] + data.stringArray[6] + data.stringArray[7] + data.stringArray[8] + data.stringArray[9];

        blackhole.consume(result);
    }


    @Benchmark
    @CompilerControl(EXCLUDE)
    public void operatorPlusWithoutJit50(Data data, Blackhole blackhole) {

        var result = data.stringArray[0] + data.stringArray[1] + data.stringArray[2] + data.stringArray[3] + data.stringArray[4]
                + data.stringArray[5] + data.stringArray[6] + data.stringArray[7] + data.stringArray[8] + data.stringArray[9]
                + data.stringArray[10] + data.stringArray[11] + data.stringArray[12] + data.stringArray[13] + data.stringArray[14]
                + data.stringArray[15] + data.stringArray[16] + data.stringArray[17] + data.stringArray[18] + data.stringArray[19]
                + data.stringArray[20] + data.stringArray[21] + data.stringArray[22] + data.stringArray[23] + data.stringArray[24]
                + data.stringArray[25] + data.stringArray[26] + data.stringArray[27] + data.stringArray[28] + data.stringArray[29]
                + data.stringArray[30] + data.stringArray[31] + data.stringArray[32] + data.stringArray[33] + data.stringArray[34]
                + data.stringArray[35] + data.stringArray[36] + data.stringArray[37] + data.stringArray[38] + data.stringArray[39]
                + data.stringArray[40] + data.stringArray[41] + data.stringArray[42] + data.stringArray[43] + data.stringArray[44]
                + data.stringArray[45] + data.stringArray[46] + data.stringArray[47] + data.stringArray[48] + data.stringArray[49];

        blackhole.consume(result);
    }


    @Benchmark
    @CompilerControl(EXCLUDE)
    public void operatorPlusWithoutJit100(Data data, Blackhole blackhole) {

        var result = data.stringArray[0] + data.stringArray[1] + data.stringArray[2] + data.stringArray[3] + data.stringArray[4]
                + data.stringArray[5] + data.stringArray[6] + data.stringArray[7] + data.stringArray[8] + data.stringArray[9]
                + data.stringArray[10] + data.stringArray[11] + data.stringArray[12] + data.stringArray[13] + data.stringArray[14]
                + data.stringArray[15] + data.stringArray[16] + data.stringArray[17] + data.stringArray[18] + data.stringArray[19]
                + data.stringArray[20] + data.stringArray[21] + data.stringArray[22] + data.stringArray[23] + data.stringArray[24]
                + data.stringArray[25] + data.stringArray[26] + data.stringArray[27] + data.stringArray[28] + data.stringArray[29]
                + data.stringArray[30] + data.stringArray[31] + data.stringArray[32] + data.stringArray[33] + data.stringArray[34]
                + data.stringArray[35] + data.stringArray[36] + data.stringArray[37] + data.stringArray[38] + data.stringArray[39]
                + data.stringArray[40] + data.stringArray[41] + data.stringArray[42] + data.stringArray[43] + data.stringArray[44]
                + data.stringArray[45] + data.stringArray[46] + data.stringArray[47] + data.stringArray[48] + data.stringArray[49]
                + data.stringArray[50] + data.stringArray[51] + data.stringArray[52] + data.stringArray[53] + data.stringArray[54]
                + data.stringArray[55] + data.stringArray[56] + data.stringArray[57] + data.stringArray[58] + data.stringArray[59]
                + data.stringArray[60] + data.stringArray[61] + data.stringArray[62] + data.stringArray[63] + data.stringArray[64]
                + data.stringArray[65] + data.stringArray[66] + data.stringArray[67] + data.stringArray[68] + data.stringArray[69]
                + data.stringArray[70] + data.stringArray[71] + data.stringArray[72] + data.stringArray[73] + data.stringArray[74]
                + data.stringArray[75] + data.stringArray[76] + data.stringArray[77] + data.stringArray[78] + data.stringArray[79]
                + data.stringArray[80] + data.stringArray[81] + data.stringArray[82] + data.stringArray[83] + data.stringArray[84]
                + data.stringArray[85] + data.stringArray[86] + data.stringArray[87] + data.stringArray[88] + data.stringArray[89]
                + data.stringArray[90] + data.stringArray[91] + data.stringArray[92] + data.stringArray[93] + data.stringArray[94]
                + data.stringArray[95] + data.stringArray[96] + data.stringArray[97] + data.stringArray[98] + data.stringArray[99];

        blackhole.consume(result);
    }


    @State(Scope.Thread)
    public static class Data {

        @Param({"15"})
        int stringLength;
        int stringCount = 100;

        String[] stringArray;

        @Setup
        public void setup() {
            stringArray = Stream.generate(() -> StringUtil.generate(stringLength))
                    .limit(stringCount)
                    .toArray(String[]::new);
        }

    }

}
