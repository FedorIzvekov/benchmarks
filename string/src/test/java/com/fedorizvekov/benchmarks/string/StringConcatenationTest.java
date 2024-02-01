package com.fedorizvekov.benchmarks.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openjdk.jmh.infra.Blackhole;

@ExtendWith(MockitoExtension.class)
class StringConcatenationTest {

    @InjectMocks
    private StringConcatenation benchmark;

    @Mock
    private Blackhole blackhole;

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    private StringConcatenation.Data data;


    @BeforeEach
    void setUp() {
        data = new StringConcatenation.Data();
        data.stringLength = 15;
        data.setup();
    }


    @Test
    @DisplayName("Should invoke operatorPlus10")
    void should_invoke_operatorPlus10() {
        benchmark.operatorPlus10(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue().length()).isEqualTo(150);
    }


    @Test
    @DisplayName("Should invoke operatorPlus50")
    void should_invoke_operatorPlus50() {
        benchmark.operatorPlus50(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue().length()).isEqualTo(750);
    }


    @Test
    @DisplayName("Should invoke operatorPlus100")
    void should_invoke_operatorPlus100() {
        benchmark.operatorPlus100(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue().length()).isEqualTo(1500);
    }


    @Test
    @DisplayName("Should invoke operatorPlusWithoutJit10")
    void should_invoke_operatorPlusWithoutJit10() {
        benchmark.operatorPlusWithoutJit10(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue().length()).isEqualTo(150);
    }


    @Test
    @DisplayName("Should invoke operatorPlusWithoutJit50")
    void should_invoke_operatorPlusWithoutJit50() {
        benchmark.operatorPlusWithoutJit50(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue().length()).isEqualTo(750);
    }


    @Test
    @DisplayName("Should invoke operatorPlusWithoutJit100")
    void should_invoke_operatorPlusWithoutJit100() {
        benchmark.operatorPlusWithoutJit100(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue().length()).isEqualTo(1500);
    }

}
