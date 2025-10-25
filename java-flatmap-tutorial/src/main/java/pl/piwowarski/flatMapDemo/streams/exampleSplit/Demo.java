package pl.piwowarski.flatMapDemo.streams.exampleSplit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Demo {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", List.of("111", "222")),
                new Person("Bob", List.of("333")),
                new Person("Charlie", List.of("444", "555"))
        );

        List<String> singleDigits = people.stream()
                .flatMap(person -> person.getPhones().stream())
                .flatMap(phone -> Stream.of(phone.split("")))
                .collect(Collectors.toList());

        System.out.println("allPhones digits: ");
        System.out.println(singleDigits);

//        ✅ Solution 1: Keep order, remove duplicates (distinct())
        List<String> uniqueDigits = people.stream()
                .flatMap(person -> person.getPhones().stream())
                .flatMap(phone -> Stream.of(phone.split("")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("uniqueDigits" + uniqueDigits);

//        ✅2. Counting how many times each digit appears next?
        Map<String, Long> digitCounts = people.stream()
                .flatMap(person -> person.getPhones().stream())
                .flatMap(phone -> Stream.of(phone.split("")))
                .collect(Collectors.groupingBy(digit -> digit,
                        Collectors.counting()));
        System.out.println(digitCounts);

//        ✅ Optional: Sorted by digit
        LinkedHashMap<String, Long> sortedDigitCounts  = digitCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        System.out.println("sortedDigitCounts ");
        System.out.println(sortedDigitCounts);
    }
}
