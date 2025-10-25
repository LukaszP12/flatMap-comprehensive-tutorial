package pl.piwowarski.flatMapDemo.streams.exampleSplit;

import java.util.List;

class Person {
    String name;
    List<String> phones;
    Person(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }
}
