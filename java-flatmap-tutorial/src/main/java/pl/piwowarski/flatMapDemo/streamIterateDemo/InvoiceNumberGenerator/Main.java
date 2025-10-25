package pl.piwowarski.flatMapDemo.streamIterateDemo.InvoiceNumberGenerator;

import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        // ✅ Example: Custom Format Invoice
        System.out.println("Example: Custom Format Invoice");
        Stream.iterate(1000, n -> n + 1)
                .limit(5)
                .forEach(n -> System.out.println("INV-" + n));
        // ✅ Example: Stop when condition met (Java 9+)
        System.out.println("Example: Stop when condition met (Java 9+)");
        Stream.iterate(1000, n -> n <= 1005, n -> n + 1)
                .map(n -> "INV-" + n)
                .forEach(System.out::println);
//        ✅ Realistic Business Rule Example
        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .map(n -> {
                    String branch = (n <= 100) ? "EU" : "US";
                    return String.format("%s-INV-%04d", branch, n);
                })
                .forEach(System.out::println);
    }
}
