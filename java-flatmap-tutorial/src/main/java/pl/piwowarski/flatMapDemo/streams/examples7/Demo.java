package pl.piwowarski.flatMapDemo.streams.examples7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Demo {
    public static void main(String[] args) {
        List<Company> companies = List.of(
                new Company(List.of(
                        new Employee("Alice", List.of("Java", "Spring")),
                        new Employee("Bob", List.of("JavaScript", "React"))
                )),
                new Company(List.of(
                        new Employee("Charlie", List.of("Python")),
                        new Employee("Dave", List.of("AWS", "Docker"))
                ))
        );

        Stream<String> allSkills = companies.stream()
                .flatMap(company -> company.employees.stream())
                .flatMap(employee -> employee.skills.stream())
                .distinct();

        List<String> withoutPython = allSkills
                .filter(skill -> !skill.equals("Python"))
                .collect(Collectors.toList());
        System.out.println("without Python: ");
        System.out.println(withoutPython);
    }
}
