package pl.piwowarski.flatMapDemo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class Basic {
    public static void main(String[] args) {
        Stream<List<Integer>> numbers = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4));
        Stream<Integer> flatMappedList = numbers.flatMap(List::stream);
        flatMappedList.forEach(System.out::println);

        System.out.println();
        Stream<Set<Integer>> setStream = Stream.of(Set.of(1, 2, 3), Set.of(4, 5, 6));
        Stream<Integer> flatMappedSet = setStream.flatMap(Set::stream);
        flatMappedSet.forEach(System.out::println);

        List<List<String>> listOfLetters = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );
        Stream<String> stringStream = listOfLetters.stream().flatMap(List::stream);
        stringStream.forEach(System.out::println);
    }
}
