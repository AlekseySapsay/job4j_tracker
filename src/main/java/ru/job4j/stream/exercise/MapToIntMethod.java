package ru.job4j.stream.exercise;

import java.util.List;

public class MapToIntMethod {
    public static long sum(List<Character> characters) {
        return characters.stream().mapToInt(ch -> (int) ch).sum();
    }
}
