package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DemoNested {
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

        List<String> allEmployeeNames = company.getDepartments().stream()
                .flatMap(department -> department.getTeams().stream())
                .flatMap(team -> team.getEmployees().stream())
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(allEmployeeNames);

        // group employees by department using streams
        Map<Department, List<Employee>> employeesByDept = company.getDepartments().stream()
                .collect(Collectors.toMap(
                        dept -> dept,
                        dept -> dept.getTeams().stream()
                                .flatMap(team -> team.getEmployees().stream())
                                .collect(Collectors.toList())
                ));

        employeesByDept.forEach(((dept, employees) -> {
            System.out.println(dept + " -> " + employees);
        }
        ));

//        ✅ Stream solution – grouping by department name
        Map<String, List<String>> employeesByDeptName = company.getDepartments().stream()
                .collect(Collectors.toMap(
                        dept -> dept.name,
                        dept -> dept.getTeams().stream()
                                .flatMap(team -> team.getEmployees().stream())
                                .map(Employee::getName)
                                .collect(Collectors.toList())
                ));

        employeesByDeptName.forEach((deptName, employees) ->
                System.out.println(deptName + " -> " + employees)
        );
    }
}
