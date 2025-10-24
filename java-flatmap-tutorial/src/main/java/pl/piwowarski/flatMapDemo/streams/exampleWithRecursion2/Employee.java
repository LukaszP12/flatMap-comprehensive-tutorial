package pl.piwowarski.flatMapDemo.streams.exampleWithRecursion2;

import java.util.List;

class Employee {
    String name;
    double salary;
    List<Employee> subordinates;

    public Employee(String name, double salary, List<Employee> subordinates) {
        this.name = name;
        this.salary = salary;
        this.subordinates = subordinates;
    }
}
