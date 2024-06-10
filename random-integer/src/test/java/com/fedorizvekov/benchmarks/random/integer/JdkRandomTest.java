package com.fedorizvekov.benchmarks.random.integer;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    private JdkRandom.Data data;


    @BeforeEach
    void setUp() {
        data = new JdkRandom.Data();
        data.rangeMin = 0;
        data.rangeMax = 100;
        data.setup();
    }


    @Test
    @DisplayName("Should generate random integer using Random")
    void shouldGenerate_randomInteger_usingRandom() {
        benchmark.random(data, blackhole);
        verify(blackhole).consume(anyInt());
    }


    @Test
    @DisplayName("Should generate random integer using SplittableRandom")
    void shouldGenerate_randomInteger_usingSplittableRandom() {
        benchmark.splittableRandom(data, blackhole);
        verify(blackhole).consume(anyInt());
    }


    @Test
    @DisplayName("Should generate random integer using ThreadLocalRandom")
    void shouldGenerate_randomInteger_usingThreadLocalRandom() {
        benchmark.threadLocalRandom(data, blackhole);
        verify(blackhole).consume(anyInt());
    }


    @Test
    @DisplayName("Should generate random integer using SecureRandom")
    void shouldGenerate_randomInteger_usingSecureRandom() {
        benchmark.secureRandom(data, blackhole);
        verify(blackhole).consume(anyInt());
    }

}
