package pl.piwowarski.flatMapDemo.streamIterateDemo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

class Demo {
    public static void main(String[] args) {
        System.out.println("Basic Example – Generate Even Numbers");
//        ✅ Basic Example – Generate Even Numbers
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
//        ✅ Example 2 – Fibonacci Sequence
        System.out.println("Example 2 – Fibonacci Sequence");
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(10)
                .map(arr -> arr[0])
                .forEach(System.out::println);

        System.out.println("Custom array ");
        Stream.iterate(new int[]{2, 4}, arr -> new int[]{arr[1], arr[0] + arr[1] + 1})
                .limit(15)
                .forEach(x -> Arrays.stream(x).forEach(System.out::println));

//        ✅ Example 3 – Generate Dates
        System.out.println("Example 3 – Generate Dates ");
        Stream.iterate(LocalDate.now(), date -> date.plusDays(1))
                .limit(5)
                .forEach(System.out::println);
//        ✅ Example 4 – iterate with Predicate (Java 9+)
        Stream.iterate(1, n -> n <= 100, n -> n * 2)
                .forEach(System.out::println);
//        ✅ Example 5 – Retry Logic Simulation
        Stream.iterate(1, attempt -> attempt + 1)
                .limit(3)
                .forEach(attempt -> System.out.println("Attempt " + attempt));
    }
}
