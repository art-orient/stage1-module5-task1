package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if (s.charAt(0) < 'A' || s.charAt(0) > 'Z') {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        List<Integer> list = new ArrayList<>();
        return x -> {
            for (Integer integer : x) {
                if (integer % 2 == 0) {
                    list.add(integer);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String value : values) {
                String[] words = value.split(" ");
                if (value.endsWith(".") && value.charAt(0) > 'A' && value.charAt(0) < 'Z' &&
                    words.length > 3) {
                    list.add(value);
                }
            }
            values.retainAll(list);
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, t) -> {
            x.addAll(t);
            return x;
        };
    }
}
