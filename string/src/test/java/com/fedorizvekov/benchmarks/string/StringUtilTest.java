package com.fedorizvekov.benchmarks.string;

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

}
