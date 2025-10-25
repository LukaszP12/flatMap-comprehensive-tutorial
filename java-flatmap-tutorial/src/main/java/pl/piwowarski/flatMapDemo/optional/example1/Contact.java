package pl.piwowarski.flatMapDemo.optional.example1;

import java.util.Optional;

class Contact {
    private Optional<Phone> phone;
    public Contact(Optional<Phone> phone) {
        this.phone = phone;
    }

    public Optional<Phone> getPhone() {
        return phone;
    }
}
