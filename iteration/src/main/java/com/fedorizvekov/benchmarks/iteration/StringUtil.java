package com.fedorizvekov.benchmarks.iteration;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.openjdk.jmh.infra.Blackhole;

public class StringUtil {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new Random();


    public static String generate(int length) {

        return IntStream.range(0, length)
                .mapToObj(i -> CHARACTERS.charAt(random.nextInt(CHARACTERS.length())))
                .map(Object::toString)
                .collect(Collectors.joining());
    }


    public static String workingLoad(String element, Blackhole blackhole) {
        if (element.equals("abcdefghijklmno")) {
            element = element + "abc";
        }

        blackhole.consume(element);
        return element;
    }

}
