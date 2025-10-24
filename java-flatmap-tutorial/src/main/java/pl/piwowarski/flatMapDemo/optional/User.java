package pl.piwowarski.flatMapDemo.optional;

import java.util.Optional;

class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
