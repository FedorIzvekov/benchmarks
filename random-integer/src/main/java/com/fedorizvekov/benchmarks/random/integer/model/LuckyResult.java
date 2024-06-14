package com.fedorizvekov.benchmarks.random.integer.model;

import lombok.Builder;

@Builder
public class LuckyResult {

    private final int totalCounter;
    private final int luckyNumber;
    private final int luckyCounter;


    @Override
    public String toString() {
        return "luckyNumber " +
                luckyNumber +
                ", luckyCounter = " +
                luckyCounter +
                ", success = " +
                ((double) luckyCounter / totalCounter) * 100 +
                " %";
    }

}
