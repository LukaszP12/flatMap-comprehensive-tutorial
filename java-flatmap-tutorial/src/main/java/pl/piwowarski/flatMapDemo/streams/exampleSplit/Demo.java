package pl.piwowarski.flatMapDemo.streams.exampleSplit;

import java.util.List;
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
    }
}
