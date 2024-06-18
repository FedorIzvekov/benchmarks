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
class Math3RandomTest {

    @InjectMocks
    private Math3Random benchmark;

    @Mock
    private Blackhole blackhole;

    @Captor
    private ArgumentCaptor<Integer> integerCaptor;

    private Math3Random.Data data;


    @BeforeEach
    void setUp() {
        data = new Math3Random.Data();
        data.rangeMin = 1;
        data.rangeMax = 2;
        data.setup();
    }


    @Test
    @DisplayName("Should generate random integer using Well512a")
    void shouldGenerate_randomInteger_usingWell512a() {
        benchmark.well512aRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @Test
    @DisplayName("Should generate random integer using MersenneTwister")
    void shouldGenerate_randomInteger_usingMersenneTwister() {
        benchmark.mersenneTwisterRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @Test
    @DisplayName("Should generate random integer using ISAACRandom")
    void shouldGenerate_randomInteger_usingISAACRandom() {
        benchmark.isaacRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }

}
