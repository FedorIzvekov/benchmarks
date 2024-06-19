package com.fedorizvekov.benchmarks.random.integer.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RandomResultTest {


    @DisplayName("Should return string with valid RandomType")
    @CsvSource({
            "RANDOM, 0, 0, ', rangeMin = 1, rangeMax = 5, totalCounter = 9, luckCounter = 0, percentSuccess = 0.0, distributionOfCoincidences = [1 - 0, 2 - 0, 5 - 0]'",
            "SPLITTABLE_RANDOM, 1, 2, ', rangeMin = 1, rangeMax = 5, totalCounter = 9, luckCounter = 3, percentSuccess = 33.33333333333333, distributionOfCoincidences = [1 - 1, 2 - 2, 5 - 0]'",
            "THREAD_LOCAL_RANDOM, 5, 4, ', rangeMin = 1, rangeMax = 5, totalCounter = 9, luckCounter = 9, percentSuccess = 100.0, distributionOfCoincidences = [1 - 5, 2 - 4, 5 - 0]'"
    })
    @ParameterizedTest
    void ShouldReturnString_withValidRandomType(RandomType randomType, int firstCounter, int secondCounter, String expectedString) {

        int rangeMin = 1;
        int rangeMax = 5;
        int totalCounter = 9;

        var result = RandomResult.builder()
                .randomType(randomType)
                .rangeMin(rangeMin)
                .rangeMax(rangeMax)
                .totalCounter(totalCounter)
                .addLuckyResult(
                        LuckyResult.builder().luckyNumber(rangeMin).luckyCounter(firstCounter).build()
                )
                .addLuckyResult(
                        LuckyResult.builder().luckyNumber(rangeMax /2).luckyCounter(secondCounter).build()
                )
                .addLuckyResult(
                        LuckyResult.builder().luckyNumber(rangeMax).luckyCounter(0).build()
                )
                .build()
                .toString();

        assertThat(result).isEqualTo(randomType + expectedString);
    }

}
