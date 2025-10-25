package pl.piwowarski.flatMapDemo.optional.example1;

import java.util.Optional;

class User {
    private Contact contact;

    public User(Contact contact) {
        this.contact = contact;
    }

    public Optional<Contact> getContact() {
        return Optional.ofNullable(contact);
    }
}
