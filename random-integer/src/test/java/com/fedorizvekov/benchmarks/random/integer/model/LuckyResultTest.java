package com.fedorizvekov.benchmarks.random.integer.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LuckyResultTest {


    @DisplayName("Should return string with valid percent")
    @CsvSource({
            "0, 'luckyNumber 777, luckyCounter = 0, success = 0.0 %'",
            "1, 'luckyNumber 777, luckyCounter = 1, success = 25.0 %'",
            "2, 'luckyNumber 777, luckyCounter = 2, success = 50.0 %'",
            "3, 'luckyNumber 777, luckyCounter = 3, success = 75.0 %'",
            "4, 'luckyNumber 777, luckyCounter = 4, success = 100.0 %'"
    })
    @ParameterizedTest
    void ShouldReturnString_withValidPercent(int luckyCounter, String expectedString) {

        var result = LuckyResult.builder()
                .luckyNumber(777)
                .totalCounter(4)
                .luckyCounter(luckyCounter)
                .build()
                .toString();

        assertThat(result).isEqualTo(expectedString);
    }

}
