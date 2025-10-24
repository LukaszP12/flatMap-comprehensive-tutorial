package pl.piwowarski.flatMapDemo.streams.examples;

import java.util.List;

class Department {
    List<Employee> employees;
    Department(List<Employee> employees) { this.employees = employees; }
    public List<Employee> getEmployees() { return employees; }
}
