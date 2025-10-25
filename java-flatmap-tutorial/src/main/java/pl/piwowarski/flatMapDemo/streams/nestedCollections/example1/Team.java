package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;

public class Team {
    List<Employee> employees;
    public Team(List<Employee> employees) { this.employees = employees; }
    public List<Employee> getEmployees() { return employees; }

    @Override
    public String toString() {
        return "Team{" +
                "employees=" + employees +
                '}';
    }
}
