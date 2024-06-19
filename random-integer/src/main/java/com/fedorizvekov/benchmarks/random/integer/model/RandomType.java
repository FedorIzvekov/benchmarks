package com.fedorizvekov.benchmarks.random.integer.model;

import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import it.unimi.dsi.util.SplitMix64Random;
import it.unimi.dsi.util.XoRoShiRo128PlusPlusRandom;
import it.unimi.dsi.util.XoRoShiRo128PlusRandom;
import it.unimi.dsi.util.XoRoShiRo128StarStarRandom;
import org.apache.commons.math3.random.ISAACRandom;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.Well512a;

public enum RandomType {

    RANDOM((min, max) -> new Random().nextInt(min, max + 1)),
    SPLITTABLE_RANDOM((min, max) -> new SplittableRandom().nextInt(min, max + 1)),
    THREAD_LOCAL_RANDOM((min, max) -> ThreadLocalRandom.current().nextInt(min, max + 1)),
    SECURE_RANDOM((min, max) -> new SecureRandom().nextInt(min, max + 1)),
    MATH_RANDOM((min, max) -> min + (int) (Math.random() * (max + 1 - min))),
    SPLIT_MIX_64_RANDOM((min, max) -> new SplitMix64Random().nextInt(min, max + 1)),
    XOROSHIRO_128_PLUS_RANDOM((min, max) -> new XoRoShiRo128PlusRandom().nextInt(min, max + 1)),
    XOROSHIRO_128_PLUS_PLUS_RANDOM((min, max) -> new XoRoShiRo128PlusPlusRandom().nextInt(min, max + 1)),
    XOROSHIRO_128_STAR_STAR_RANDOM((min, max) -> new XoRoShiRo128StarStarRandom().nextInt(min, max + 1)),
    MATH3_WELL_512_A((min, max) -> min + new Well512a().nextInt(max + 1 - min)),
    MATH3_MERSENNE_TWISTER((min, max) -> min + new MersenneTwister().nextInt(max + 1 - min)),
    MATH3_ISAAC_RANDOM((min, max) -> min + new ISAACRandom().nextInt(max + 1 - min));


    private final RandomFunctional randomGenerator;


    RandomType(RandomFunctional randomGenerator) {
        this.randomGenerator = randomGenerator;
    }


    public int generate(int min, int max) {
        return randomGenerator.generate(min, max);
    }


    @FunctionalInterface
    interface RandomFunctional {
        int generate(int min, int max);
    }

}
