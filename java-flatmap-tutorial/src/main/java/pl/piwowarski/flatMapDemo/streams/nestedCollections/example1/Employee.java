package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

public class Employee {
    String name;
    public Employee(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
