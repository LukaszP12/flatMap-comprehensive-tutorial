package pl.piwowarski.flatMapDemo.streams.nestedCollections.groupingByExample;


import pl.piwowarski.flatMapDemo.streams.nestedCollections.example1.Company;
import pl.piwowarski.flatMapDemo.streams.nestedCollections.example1.Department;
import pl.piwowarski.flatMapDemo.streams.nestedCollections.example1.Employee;
import pl.piwowarski.flatMapDemo.streams.nestedCollections.example1.Team;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class groupingByExample {
    public static void main(String[] args) {
        Company company = new Company(List.of(
                new Department("Engineering", List.of(
                        new Team(List.of(new Employee("Alice"), new Employee("Bob"))),
                        new Team(List.of(new Employee("Carol")))
                )),
                new Department("Sales", List.of(
                        new Team(List.of(new Employee("Dave"))),
                        new Team(List.of(new Employee("Eve"), new Employee("Frank")))
                ))
        ));

        Map<String, List<String>> result = company.getDepartments().stream()
                .flatMap(dept -> dept.getTeams().stream()
                        .flatMap(team -> team.getEmployees().stream()
                                .map(emp -> Map.entry(dept.getName(), emp.getName()))
                        )
                ).collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,
                                Collectors.toList())
                ));

        result.forEach((dept, employees) ->
        {
            System.out.println(dept + " -> " + employees);
        });
    }
}
