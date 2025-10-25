package pl.piwowarski.flatMapDemo.streamIterateDemo.streamGenerate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Demo {
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
//        👉 Each element is independent of the previous one.

        System.out.println("vs Stream.iterate() – Build number sequences");
        // vs Stream.iterate() – Build number sequences
        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::println);

        // Same value repeated
        Stream.generate(() -> "Hello")
                .limit(5)
                .forEach(System.out::println);

//        ✅ Example 2 – Fill a list with default values
        List<String> defaults = Stream.generate(() -> "N/A")
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(defaults);
//        ✅ Example 3 – Initialize boolean flags
        List<Boolean> flags = Stream.generate(() -> false)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(flags);
//        ✅ Example 4 – Repeating Objects
        Person p = new Person("Alice");
        Stream.generate(() -> p)
                .limit(3)
                .forEach(System.out::println);
    }
}
