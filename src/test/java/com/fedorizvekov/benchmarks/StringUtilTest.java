package com.fedorizvekov.benchmarks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilTest {

    @Test
    public void should_generate_string_of_length_10() {
        String result = StringUtil.generate(10);
        assertThat(result).hasSize(10);
        assertThat(result).matches("[A-Za-z]+");
    }


    @Test
    public void should_generate_string_of_length_100() {
        String result = StringUtil.generate(100);
        assertThat(result).hasSize(100);
        assertThat(result).matches("[A-Za-z]+");
    }


    @Test
    public void should_repeat_1_times() {
        String result = StringUtil.repeat("Test", 1);
        assertThat(result).hasSize(4);
        assertThat(result).isEqualTo("Test");
    }


    @Test
    public void should_repeat_5_times() {
        String result = StringUtil.repeat("Test", 5);
        assertThat(result).hasSize(20);
        assertThat(result).isEqualTo("TestTestTestTestTest");
    }

}
