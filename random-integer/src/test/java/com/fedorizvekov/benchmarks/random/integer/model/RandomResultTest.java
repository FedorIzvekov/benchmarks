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
            "SPLITTABLE_RANDOM, ' (range 1 - 5): totalCounter = 1, luckyResults = [luckyNumber 111, luckyCounter = 1, success = 100.0 %, luckyNumber 777, luckyCounter = 0, success = 0.0 %]'",
            "THREAD_LOCAL_RANDOM, ' (range 1 - 5): totalCounter = 1, luckyResults = [luckyNumber 111, luckyCounter = 1, success = 100.0 %, luckyNumber 777, luckyCounter = 0, success = 0.0 %]'",
    })
    @ParameterizedTest
    void ShouldReturnString_withValidRandomType(RandomType randomType, String expectedString) {

        var result = RandomResult.builder()
                .randomType(randomType)
                .rangeMin(1)
                .rangeMax(5)
                .totalCounter(1)
                .addLuckyResult(
                        LuckyResult.builder()
                                .luckyNumber(111)
                                .totalCounter(1)
                                .luckyCounter(1)
                                .build()
                )
                .addLuckyResult(
                        LuckyResult.builder()
                                .luckyNumber(777)
                                .totalCounter(1)
                                .luckyCounter(0)
                                .build()
                )
                .build()
                .toString();

        assertThat(result).isEqualTo(randomType + expectedString);
    }

}
