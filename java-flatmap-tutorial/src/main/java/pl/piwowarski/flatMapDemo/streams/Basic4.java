package pl.piwowarski.flatMapDemo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Basic4 {
    public static void main(String[] args) {
        List<String[]> list = List.of(
                new String[]{"x", "y"},
                new String[]{"z"}
        );

        List<String> result = list.stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        Stream<Stream<Integer>> nested = Stream.of(
                Stream.of(1, 2),
                Stream.of(3, 4)
        );

        List<Integer> result2 = nested
                .flatMap(Function.identity())
                .collect(Collectors.toList());
        System.out.println("result2" + result2);

//        Example 8: Flatten IntStream from a list of String lengths
        List<String> words = List.of("java", "rocks");

        int sum = words.stream()
                .map(String::length)
                .flatMapToInt(IntStream::of)
                .sum();
        System.out.println("sum: " + sum);
    }
}
