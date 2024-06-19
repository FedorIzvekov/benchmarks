package com.fedorizvekov.benchmarks.random.integer.model;

import java.util.List;
import lombok.Builder;
import lombok.Singular;

@Builder
public class RandomResult {

    private final RandomType randomType;
    private final int rangeMin;
    private final int rangeMax;
    private final int totalCounter;
    @Singular("addLuckyResult")
    private final List<LuckyResult> luckyResults;


    @Override
    public String toString() {

        var luckCounter = luckyResults.stream().mapToInt(LuckyResult::luckyCounter).sum();

        return randomType.name() +
                ", rangeMin = " +
                rangeMin +
                ", rangeMax = " +
                rangeMax +
                ", totalCounter = " +
                totalCounter +
                ", luckCounter = " +
                luckCounter +
                ", percentSuccess = " +
                ((double) luckCounter / totalCounter) * 100 +
                ", distributionOfCoincidences = " +
                luckyResults;

    }

}
