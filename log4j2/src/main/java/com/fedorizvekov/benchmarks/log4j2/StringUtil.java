package com.fedorizvekov.benchmarks.log4j2;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtil {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new Random();


    public static String generate(int length) {

        return IntStream.range(0, length)
                .mapToObj(i -> CHARACTERS.charAt(random.nextInt(CHARACTERS.length())))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

}
