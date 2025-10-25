package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

class Employee {
    String name;
    Employee(String name) { this.name = name; }
    String getName() { return name; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
