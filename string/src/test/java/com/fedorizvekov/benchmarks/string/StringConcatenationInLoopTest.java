package com.fedorizvekov.benchmarks.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openjdk.jmh.infra.Blackhole;

@ExtendWith(MockitoExtension.class)
class StringConcatenationInLoopTest {

    @InjectMocks
    private StringConcatenationInLoop benchmark;

    @Mock
    private Blackhole blackhole;

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    private StringConcatenationInLoop.Data data;
    private MockedStatic<StringUtil> stringUtil;


    @BeforeEach
    void setUp() {
        stringUtil = mockStatic(StringUtil.class);

        data = new StringConcatenationInLoop.Data();
        data.stringLength = 6;
        data.stringCount = 2;

        stringUtil.when(() -> StringUtil.generate(anyInt())).thenReturn("test_1").thenReturn("test_2");

        data.setup();
    }


    @AfterEach
    void tearDown() {
        stringUtil.close();
    }


    @Test
    @DisplayName("Should invoke stringBuilder")
    void should_invoke_stringBuilder() {
        benchmark.stringBuilder(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringBuilderWithCapacity")
    void should_invoke_stringBuilderWithCapacity() {
        benchmark.stringBuilderWithCapacity(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringBuffer")
    void should_invoke_stringBuffer() {
        benchmark.stringBuffer(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringBufferWithCapacity")
    void should_invoke_stringBufferWithCapacity() {
        benchmark.stringBufferWithCapacity(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringJoiner")
    void should_invoke_stringJoiner() {
        benchmark.stringJoiner(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringStreamJoining")
    void should_invoke_stringStreamJoining() {
        benchmark.stringStreamJoining(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringFormat")
    void should_invoke_stringFormat() {
        benchmark.stringFormat(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringFormatted")
    void should_invoke_stringFormatted() {
        benchmark.stringFormatted(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringConcat")
    void should_invoke_stringConcat() {
        benchmark.stringConcat(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }


    @Test
    @DisplayName("Should invoke stringPlus")
    void should_invoke_stringPlus() {
        benchmark.operatorPlus(data, blackhole);

        verify(blackhole).consume(stringCaptor.capture());
        assertThat(stringCaptor.getValue()).isEqualTo("test_1test_2");
    }

}
