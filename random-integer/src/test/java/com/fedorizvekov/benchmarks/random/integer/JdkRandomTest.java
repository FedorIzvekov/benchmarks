package com.fedorizvekov.benchmarks.random.integer;

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
class JdkRandomTest {

    @InjectMocks
    private JdkRandom benchmark;

    @Mock
    private Blackhole blackhole;

    @Captor
    private ArgumentCaptor<Integer> integerCaptor;

    private JdkRandom.Data data;


    @BeforeEach
    void setUp() {
        data = new JdkRandom.Data();
        data.rangeMin = 1;
        data.rangeMax = 2;
        data.setup();
    }


    @DisplayName("Should generate random integer using Random")
    @Test
    void shouldGenerate_randomInteger_usingRandom() {
        benchmark.random(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @DisplayName("Should generate random integer using SplittableRandom")
    @Test
    void shouldGenerate_randomInteger_usingSplittableRandom() {
        benchmark.splittableRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @DisplayName("Should generate random integer using ThreadLocalRandom")
    @Test
    void shouldGenerate_randomInteger_usingThreadLocalRandom() {
        benchmark.threadLocalRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @DisplayName("Should generate random integer using SecureRandom")
    @Test
    void shouldGenerate_randomInteger_usingSecureRandom() {
        benchmark.secureRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @DisplayName("Should generate random integer using Math.random()")
    @Test
    void shouldGenerate_randomInteger_usingMathRandom() {
        benchmark.mathRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }

}
