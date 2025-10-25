package pl.piwowarski.flatMapDemo.optional.example1;


import java.util.Optional;

class Phone {
    private Optional<Country> country;
    public Phone(Optional<Country> country) {
        this.country = country;
    }
    public Optional<Country> getCountry() {
        return country;
    }
}
