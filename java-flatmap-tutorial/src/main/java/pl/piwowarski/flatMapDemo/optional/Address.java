package pl.piwowarski.flatMapDemo.optional;

import java.util.Optional;

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }
}
