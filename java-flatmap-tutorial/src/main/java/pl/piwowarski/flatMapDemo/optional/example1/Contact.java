package pl.piwowarski.flatMapDemo.optional.example1;

import java.util.Optional;

class Contact {
    private Phone phone;

    public Contact(Phone phone) {
        this.phone = phone;
    }

    public Optional<Phone> getPhone() {
        return Optional.ofNullable(phone);
    }
}
