package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;

public class Company {
    List<Department> departments;
    public Company(List<Department> departments) { this.departments = departments; }
    public List<Department> getDepartments() { return departments; }
}
