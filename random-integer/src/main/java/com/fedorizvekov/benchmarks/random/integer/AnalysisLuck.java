package com.fedorizvekov.benchmarks.random.integer;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import com.fedorizvekov.benchmarks.random.integer.model.LuckyResult;
import com.fedorizvekov.benchmarks.random.integer.model.RandomResult;
import com.fedorizvekov.benchmarks.random.integer.model.RandomType;

public class AnalysisLuck {

    private final List<RandomResult> results = new ArrayList<>();
    int rangeMin = 1;
    int[] maxRanges = {10, 100, 1000, 10000};
    int numberOfChecks = 10_000_000;


    public List<RandomResult> runAnalyze() {

        for (RandomType randomType : RandomType.values()) {

            for (var rangeMax : maxRanges) {

                var totalCounter = 0;
                var luckyCounters = initializeLuckyCounters(rangeMin, rangeMax);

                while (totalCounter < numberOfChecks) {

                    var number = randomType.generate(rangeMin, rangeMax);

                    luckyCounters.computeIfPresent(number, (key, count) -> count + 1);

                    totalCounter++;

                }

                results.add(
                        RandomResult.builder()
                                .randomType(randomType)
                                .rangeMin(rangeMin)
                                .rangeMax(rangeMax)
                                .totalCounter(numberOfChecks)
                                .luckyResults(createLuckyResults(luckyCounters))
                                .build()
                );

            }
        }

        return results;
    }


    private Map<Integer, Integer> initializeLuckyCounters(int rangeMin, int rangeMax) {

        var step = (rangeMax - rangeMin) / 9;

        return IntStream.range(0, 10)
                .mapToObj(i -> rangeMin + i * step)
                .collect(toMap(luckyNumber -> luckyNumber, luckyCounter -> 0));
    }


    private List<LuckyResult> createLuckyResults(Map<Integer, Integer> luckyCounters) {
        return luckyCounters.keySet().stream()
                .sorted()
                .map(luckyNumber -> LuckyResult.builder()
                        .luckyNumber(luckyNumber)
                        .luckyCounter(luckyCounters.get(luckyNumber))
                        .build()
                )
                .collect(toList());

    }

}
