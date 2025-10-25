package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;

class Team {
    List<Employee> employees;
    Team(List<Employee> employees) { this.employees = employees; }
    List<Employee> getEmployees() { return employees; }

    @Override
    public String toString() {
        return "Team{" +
                "employees=" + employees +
                '}';
    }
}
