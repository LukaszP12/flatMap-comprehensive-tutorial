package pl.piwowarski.flatMapDemo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Examples {
    public static void main(String[] args) {
        Stream<String[]> data = Stream.of(new String[]{"a", "b"}, new String[]{"c", "d"});
        List<String> flat = data
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(flat);

        System.out.println();
        Stream<int[]> streamNums = Stream.of(new int[]{1, 2}, new int[]{3, 4});
        List<Integer> result = streamNums
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);

        Stream<Integer[]> streamNums2 = Stream.of(new Integer[]{1, 2}, new Integer[]{3, 4});
        List<Integer> result2 = streamNums2
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
