package com.fedorizvekov.benchmarks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StringUtilTest {

    @Test
    @DisplayName("Should generate string of length 10")
    void should_generate_string_of_length_10() {
        String result = StringUtil.generate(10);
        assertThat(result).hasSize(10);
        assertThat(result).matches("[A-Za-z]+");
    }


    @Test
    @DisplayName("Should generate string of length 100")
    void should_generate_string_of_length_100() {
        String result = StringUtil.generate(100);
        assertThat(result).hasSize(100);
        assertThat(result).matches("[A-Za-z]+");
    }


    @Test
    @DisplayName("Should repeat 1 times")
    void should_repeat_1_times() {
        String result = StringUtil.repeat("Test", 1);
        assertThat(result).hasSize(4);
        assertThat(result).isEqualTo("Test");
    }


    @Test
    @DisplayName("Should repeat 5 times")
    void should_repeat_5_times() {
        String result = StringUtil.repeat("Test", 5);
        assertThat(result).hasSize(20);
        assertThat(result).isEqualTo("TestTestTestTestTest");
    }

}
