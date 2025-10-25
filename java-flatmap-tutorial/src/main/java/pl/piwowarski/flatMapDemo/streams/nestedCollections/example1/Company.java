package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;

class Company {
    List<Department> departments;
    Company(List<Department> departments) { this.departments = departments; }
    List<Department> getDepartments() { return departments; }
}
