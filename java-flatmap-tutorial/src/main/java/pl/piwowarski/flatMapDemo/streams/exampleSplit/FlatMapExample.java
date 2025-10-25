package pl.piwowarski.flatMapDemo.streams.exampleSplit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> sentences = List.of(
                "hello world",
                "flatMap is powerful"
        );

        List<String> letters = sentences.stream()
                .flatMap(sentence -> Stream.of(sentence.split(" ")))
                .flatMap(word -> Stream.of(word.split("")))
                .collect(Collectors.toList());
        System.out.println(letters);
    }
}
