package com.fedorizvekov.benchmarks.random.integer;

import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Arrays.asList;

import java.util.stream.Stream;
import com.fedorizvekov.benchmarks.random.integer.model.RandomType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnalysisLuckTest {

    private final AnalysisLuck analysisLuck = new AnalysisLuck();


    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
                Arguments.of(1, 100, new int[]{1, 12, 23, 34, 45, 56, 67, 78, 89, 100}),
                Arguments.of(1, 1000, new int[]{1, 112, 223, 334, 445, 556, 667, 778, 889, 1000}),
                Arguments.of(1, 10000, new int[]{1, 1112, 2223, 3334, 4445, 5556, 6667, 7778, 8889, 10000})
        );
    }


    @DisplayName("Should return list with all RandomResults")
    @MethodSource("provideData")
    @ParameterizedTest
    void ShouldReturnList_withAllRandomResults(int rangeMin, int rangeMax) {
        var numberOfChecks = 5;

        analysisLuck.rangeMin = rangeMin;
        analysisLuck.maxRanges = new int[]{rangeMax};
        analysisLuck.numberOfChecks = numberOfChecks;

        var result = analysisLuck.runAnalyze();

        assertThat(result)
                .hasSize(RandomType.values().length)
                .extracting("randomType")
                .containsExactlyInAnyOrder(
                        RANDOM, SECURE_RANDOM, THREAD_LOCAL_RANDOM, SPLITTABLE_RANDOM, MATH_RANDOM,
                        SPLIT_MIX_64_RANDOM, XOROSHIRO_128_PLUS_RANDOM, XOROSHIRO_128_PLUS_PLUS_RANDOM, XOROSHIRO_128_STAR_STAR_RANDOM,
                        MATH3_WELL_512_A, MATH3_MERSENNE_TWISTER, MATH3_ISAAC_RANDOM
                );

        assertThat(result)
                .extracting("rangeMin")
                .containsOnly(rangeMin);

        assertThat(result)
                .extracting("rangeMax")
                .containsOnly(rangeMax);

        assertThat(result)
                .extracting("totalCounter")
                .containsOnly(numberOfChecks);
    }


    @DisplayName("Should return list with all luckyNumber")
    @MethodSource("provideData")
    @ParameterizedTest
    void ShouldReturnList_withAllLuckyNumber(int rangeMin, int rangeMax, int[] luckyNumber) {
        analysisLuck.rangeMin = rangeMin;
        analysisLuck.maxRanges = new int[]{rangeMax};
        analysisLuck.numberOfChecks = 1;

        var result = analysisLuck.runAnalyze().getFirst();

        assertThat(result)
                .extracting("luckyResults").asList()
                .hasSize(luckyNumber.length)
                .extracting("luckyNumber")
                .containsExactlyInAnyOrderElementsOf(asList(luckyNumber));
    }

}
