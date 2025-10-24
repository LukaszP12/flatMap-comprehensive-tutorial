package pl.piwowarski.flatMapDemo.streams.examples;

import java.util.List;

class Company {
    List<Department> departments;
    Company(List<Department> departments) { this.departments = departments; }
    public List<Department> getDepartments() { return departments; }
}
