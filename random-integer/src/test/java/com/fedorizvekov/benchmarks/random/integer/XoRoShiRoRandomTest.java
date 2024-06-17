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
class XoRoShiRoRandomTest {

    @InjectMocks
    private XoRoShiRoRandom benchmark;

    @Mock
    private Blackhole blackhole;

    @Captor
    private ArgumentCaptor<Integer> integerCaptor;

    private XoRoShiRoRandom.Data data;


    @BeforeEach
    void setUp() {
        data = new XoRoShiRoRandom.Data();
        data.rangeMin = 1;
        data.rangeMax = 2;
        data.setup();
    }


    @Test
    @DisplayName("Should generate random integer using SplitMix64Random")
    void shouldGenerate_randomInteger_usingSplitMix64Random() {
        benchmark.splitMix64Random(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @Test
    @DisplayName("Should generate random integer using XoRoShiRo128PlusRandom")
    void shouldGenerate_randomInteger_usingXoRoShiRo128PlusRandom() {
        benchmark.xoRoShiRo128PlusRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @Test
    @DisplayName("Should generate random integer using XoRoShiRo128PlusPlusRandom")
    void shouldGenerate_randomInteger_usingXoRoShiRo128PlusPlusRandom() {
        benchmark.xoRoShiRo128PlusPlusRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }


    @Test
    @DisplayName("Should generate random integer using XoRoShiRo128StarStarRandom")
    void shouldGenerate_randomInteger_usingXoRoShiRo128StarStarRandom() {
        benchmark.xoRoShiRo128StarStarRandom(data, blackhole);

        verify(blackhole).consume((int) integerCaptor.capture());
        assertThat(integerCaptor.getValue()).isBetween(1, 2);
    }

}
