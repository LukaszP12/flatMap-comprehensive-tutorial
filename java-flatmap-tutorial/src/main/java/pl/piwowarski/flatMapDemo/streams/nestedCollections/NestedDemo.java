package pl.piwowarski.flatMapDemo.streams.nestedCollections;

import java.util.List;
import java.util.stream.Collectors;

class NestedDemo {
    public static void main(String[] args) {
        List<List<List<String>>> data = List.of(
                List.of(
                        List.of("a", "b"),
                        List.of("c")
                ),
                List.of(
                        List.of("d", "e"),
                        List.of("f")
                )

        );
        List<String> result = data.stream()
                .flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
