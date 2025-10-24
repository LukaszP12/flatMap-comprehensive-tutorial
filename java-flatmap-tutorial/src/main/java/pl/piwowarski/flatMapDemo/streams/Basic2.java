package pl.piwowarski.flatMapDemo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Basic2 {
    public static void main(String[] args) {
        List<List<String>> names = List.of(
                List.of("Alex", "Brian"),
                List.of("Charles", "David")
        );
        Stream<String> stringStream = names.stream().flatMap(List::stream);
        System.out.println("stringStream.collect(Collectors.toList()) " + stringStream.collect(Collectors.toList()));

        Stream<String[]> data = Stream.of(new String[]{"a", "b"}, new String[]{"c", "d"});
        Stream<String> stringStream1 = data.flatMap(Arrays::stream);
        List<String> result = stringStream1.collect(Collectors.toList());
        System.out.println(result);
    }
}
