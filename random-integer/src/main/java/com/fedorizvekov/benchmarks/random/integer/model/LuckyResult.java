package com.fedorizvekov.benchmarks.random.integer.model;

import lombok.Builder;

@Builder
public record LuckyResult(int luckyNumber, int luckyCounter) {


    @Override
    public String toString() {
        return luckyNumber + " -> " + luckyCounter;
    }

}
