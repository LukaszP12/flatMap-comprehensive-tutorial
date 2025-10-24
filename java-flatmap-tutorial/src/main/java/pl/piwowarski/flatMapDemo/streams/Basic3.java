package pl.piwowarski.flatMapDemo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Basic3 {
    public static void main(String[] args) {
        List<String[]> data = List.of(
                new String[]{"apple", "banana"},
                new String[]{"cherry", "date"}
        );

        List<String> result = data.stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(result);


        List<String> sentences = List.of(
                "hello world",
                "java stream api"
        );

        List<String> words = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());
        System.out.println(words);

        Map<String, List<Integer>> scores = Map.of(
                "Alice", List.of(85, 90),
                "Bob", List.of(78, 82)
        );

        List<Integer> allScores = scores.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(allScores);

        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> result2 = numbers.stream()
                .flatMap(n -> Stream.of(n, n * n, n * n * n))
                .collect(Collectors.toList());
        System.out.println(result2);
    }
}
