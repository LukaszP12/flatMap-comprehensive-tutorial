package pl.piwowarski.flatMapDemo.optional.example1;


import java.util.Optional;

class Phone {
    private Country country;

    public Phone(Country country) {
        this.country = country;

    }

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }
}
