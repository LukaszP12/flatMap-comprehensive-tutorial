package pl.piwowarski.flatMapDemo.streams.exampleWithRecursion2;

import java.util.List;
import java.util.stream.Stream;

class Main {

    static Stream<Employee> flatten(Employee employee) {
        return Stream.concat(
                Stream.of(employee),
                employee.subordinates.stream()
                        .flatMap(Main::flatten) // recursive flatten
        );
    }

    public static void main(String[] args) {
        Employee e4 = new Employee("Dev A", 3000, List.of());
        Employee e5 = new Employee("Dev B", 3200, List.of());
        Employee e2 = new Employee("Manager A", 5000, List.of(e4, e5));

        Employee e6 = new Employee("Dev C", 3100, List.of());
        Employee e3 = new Employee("Manager B", 5200, List.of(e6));

        Employee boss = new Employee("CEO", 10000, List.of(e2, e3));

        double sum = flatten(boss)
                .mapToDouble(emp -> emp.salary)
                .sum();
        System.out.println("Salary of all employees: " + sum);
    }
}
