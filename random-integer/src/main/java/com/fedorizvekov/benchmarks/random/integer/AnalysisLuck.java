package com.fedorizvekov.benchmarks.random.integer;

import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.MATH_RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.SECURE_RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.SPLITTABLE_RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.SPLIT_MIX_64_RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.THREAD_LOCAL_RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.XO_RO_SHI_RO_128_PLUS_PLUS_RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.XO_RO_SHI_RO_128_PLUS_RANDOM;
import static com.fedorizvekov.benchmarks.random.integer.model.RandomType.XO_RO_SHI_RO_128_STAR_STAR_RANDOM;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import com.fedorizvekov.benchmarks.random.integer.model.LuckyResult;
import com.fedorizvekov.benchmarks.random.integer.model.RandomResult;
import com.fedorizvekov.benchmarks.random.integer.model.RandomType;
import it.unimi.dsi.util.SplitMix64Random;
import it.unimi.dsi.util.XoRoShiRo128PlusPlusRandom;
import it.unimi.dsi.util.XoRoShiRo128PlusRandom;
import it.unimi.dsi.util.XoRoShiRo128StarStarRandom;

public class AnalysisLuck {

    private final Map<RandomType, RandomFunctional> functions = new EnumMap<>(RandomType.class);
    private final List<RandomResult> results = new ArrayList<>();
    private int rangeMin = 1;
    private int[] maxRanges = {10, 100, 1000, 10000};
    private int numberOfChecks = 10_000_000;


    AnalysisLuck(int rangeMin, int[] maxRanges, int numberOfChecks) {
        this();
        this.rangeMin = rangeMin;
        this.maxRanges = maxRanges;
        this.numberOfChecks = numberOfChecks;
    }


    public AnalysisLuck() {
        functions.put(RANDOM, (min, max) -> new Random().nextInt(min, max + 1));
        functions.put(SPLITTABLE_RANDOM, (min, max) -> new SplittableRandom().nextInt(min, max + 1));
        functions.put(THREAD_LOCAL_RANDOM, (min, max) -> ThreadLocalRandom.current().nextInt(min, max + 1));
        functions.put(SECURE_RANDOM, (min, max) -> new SecureRandom().nextInt(min, max + 1));
        functions.put(MATH_RANDOM, (min, max) -> min + (int) (Math.random() * (max + 1 - min)));
        functions.put(SPLIT_MIX_64_RANDOM, (min, max) -> new SplitMix64Random().nextInt(min, max + 1));
        functions.put(XO_RO_SHI_RO_128_PLUS_RANDOM, (min, max) -> new XoRoShiRo128PlusRandom().nextInt(min, max + 1));
        functions.put(XO_RO_SHI_RO_128_PLUS_PLUS_RANDOM, (min, max) -> new XoRoShiRo128PlusPlusRandom().nextInt(min, max + 1));
        functions.put(XO_RO_SHI_RO_128_STAR_STAR_RANDOM, (min, max) -> new XoRoShiRo128StarStarRandom().nextInt(min, max + 1));
    }


    public List<RandomResult> runAnalyze() {

        for (var rangeMax : maxRanges) {
            var rangeMid = rangeMax / 2;

            for (Map.Entry<RandomType, RandomFunctional> functionEntry : functions.entrySet()) {

                int totalCounter = 0;

                var luckyCounters = new HashMap<Integer, Integer>() {{
                    put(rangeMin, 0);
                    put(rangeMid, 0);
                    put(rangeMax, 0);
                }};

                for (var check = 0; check < numberOfChecks; check++) {

                    var number = functionEntry.getValue().generate(rangeMin, rangeMax);

                    luckyCounters.computeIfPresent(number, (key, count) -> count + 1);

                    totalCounter++;

                }

                var result = RandomResult.builder()
                        .randomType(functionEntry.getKey())
                        .rangeMin(rangeMin)
                        .rangeMax(rangeMax)
                        .totalCounter(totalCounter)
                        .addLuckyResult(
                                LuckyResult.builder()
                                        .totalCounter(totalCounter)
                                        .luckyNumber(rangeMin)
                                        .luckyCounter(luckyCounters.get(rangeMin))
                                        .build()
                        )
                        .addLuckyResult(
                                LuckyResult.builder()
                                        .totalCounter(totalCounter)
                                        .luckyNumber(rangeMid)
                                        .luckyCounter(luckyCounters.get(rangeMid))
                                        .build()
                        )
                        .addLuckyResult(
                                LuckyResult.builder()
                                        .totalCounter(totalCounter)
                                        .luckyNumber(rangeMax)
                                        .luckyCounter(luckyCounters.get(rangeMax))
                                        .build()
                        )
                        .build();

                results.add(result);


            }
        }

        return results;
    }


    @FunctionalInterface
    interface RandomFunctional {
        int generate(int min, int max);
    }

}
