package pl.piwowarski.flatMapDemo.streams.examples;

import java.util.List;
import java.util.stream.Collectors;

class Demo {
    public static void main(String[] args) {
        List<Company> companies = List.of(
                new Company(List.of(
                        new Department(List.of(new Employee("Alice"), new Employee("Bob"))),
                        new Department(List.of(new Employee("Charlie")))
                )),
                new Company(List.of(
                        new Department(List.of(new Employee("David"), new Employee("Eva")))
                ))
        );

        List<String> allEmployeeNames = companies.stream()
                .flatMap(company -> company.getDepartments().stream())
                .flatMap(dept -> dept.getEmployees().stream())
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(allEmployeeNames);
    }
}
