package com.fedorizvekov.benchmarks.random.integer;

import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.fedorizvekov.benchmarks.random.integer.model.RandomType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnalysisLuckTest {

    private final int rangeMin = 2;
    private final int rangeMax = 3;
    private final int numberOfChecks = 5;

    private final AnalysisLuck analysisLuck = new AnalysisLuck(rangeMin, new int[]{rangeMax}, numberOfChecks);


    @DisplayName("Should return list with all RandomResults")
    @Test
    void ShouldReturnList_withAllRandomResults() {
        var result = analysisLuck.runAnalyze();

        assertThat(result)
                .hasSize(RandomType.values().length)
                .extracting("randomType")
                .containsExactlyInAnyOrder(
                        RANDOM, SECURE_RANDOM, THREAD_LOCAL_RANDOM, SPLITTABLE_RANDOM, MATH_RANDOM,
                        SPLIT_MIX_64_RANDOM, XO_RO_SHI_RO_128_PLUS_RANDOM, XO_RO_SHI_RO_128_PLUS_PLUS_RANDOM, XO_RO_SHI_RO_128_STAR_STAR_RANDOM,
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

}
