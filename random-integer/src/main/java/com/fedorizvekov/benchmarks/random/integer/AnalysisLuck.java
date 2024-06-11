package com.fedorizvekov.benchmarks.random.integer;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class AnalysisLuck {

    private final Map<String, Consumer<Integer>> methods = Map.of(
            "Random", this::random,
            "SplittableRandom", this::splittableRandom,
            "ThreadLocalRandom", this::threadLocalRandom,
            "SecureRandom", this::secureRandom
    );

    private final int rangeMin = 1;
    private final int[] maxRanges = {10, 100, 1000, 10000};
    private final int numberOfChecks = 1_000_000;
    private final int luckyNumber = 1;

    private final Random random = new Random(); // pseudo-random
    private final SplittableRandom splittableRandom = new SplittableRandom(); // pseudo-random
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current(); // pseudo-random
    private final SecureRandom secureRandom = new SecureRandom();  // cryptographically strong pseudo-random

    private int totalCounter;
    private int luckyCounter;


    public void runAnalyze() {

        for (var rangeMax : maxRanges) {

            for (Map.Entry<String, Consumer<Integer>> method : methods.entrySet()) {

                totalCounter = 0;
                luckyCounter = 0;

                for (var check = 0; check < numberOfChecks; check++) {

                    method.getValue().accept(rangeMax);

                }

                System.out.println(
                        method.getKey() + " (range " + rangeMin + " - " + rangeMax +
                                "): Total random numbers = " + totalCounter +
                                ", Lucky random numbers = " + luckyCounter +
                                ", % success = " + ((double) luckyCounter / totalCounter) * 100
                );

            }
        }
    }


    private void random(int rangeMax) {
        var number = rangeMin + random.nextInt(rangeMax - rangeMin);
        analyzeLuck(number);
    }


    private void splittableRandom(int rangeMax) {
        var number = rangeMin + splittableRandom.nextInt(rangeMax - rangeMin);
        analyzeLuck(number);
    }


    private void threadLocalRandom(int rangeMax) {
        var number = rangeMin + threadLocalRandom.nextInt(rangeMax - rangeMin);
        analyzeLuck(number);
    }


    private void secureRandom(int rangeMax) {
        var number = rangeMin + secureRandom.nextInt(rangeMax - rangeMin);
        analyzeLuck(number);
    }


    private void analyzeLuck(int number) {
        if (number == luckyNumber) {
            luckyCounter++;
        }
        totalCounter++;
    }

}
