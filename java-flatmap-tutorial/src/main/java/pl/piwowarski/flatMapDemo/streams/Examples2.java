package pl.piwowarski.flatMapDemo.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Examples2 {
    public static void main(String[] args) {
//        Flatten Stream<int[]>
        Stream<int[]> stream = Stream.of(new int[]{1, 2}, new int[]{3, 4});

        IntStream flat = stream.flatMapToInt(Arrays::stream);

        flat.forEach(System.out::println);

        Stream<int[]> stream1 = Stream.of(new int[]{5, 6}, new int[]{7, 8});
        IntStream intStream = stream1.flatMapToInt(Arrays::stream);
        intStream.forEach(System.out::println);

        // Example 2: Sum of all nested integers
        Stream<int[]> stream2 = Stream.of(new int[]{5, 10}, new int[]{15, 20});
        int sum = stream2
                .flatMapToInt(Arrays::stream)
                .sum();
        System.out.println("sum: " + sum);

        Stream<Object[]> stream3 = Stream.of(
                new Object[]{1, 2},
                new Object[]{"a", "b"}
        );
        Stream<Object> objectStream = stream3.flatMap(Arrays::stream);

//        Example 3: Filter + flatMapToInt + average
        Stream<int[]> stream4 = Stream.of(
                new int[]{2, 8, 10},
                new int[]{3, 9, 12}
        );
        double avg = stream4
                .flatMapToInt(Arrays::stream)
                .filter(n -> n % 2 == 0)
                .average()
                .orElse(0);
        System.out.println("avg: " + avg);
    }
}
