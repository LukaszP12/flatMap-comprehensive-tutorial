package pl.piwowarski.flatMapDemo.optional.example1;

import java.util.Optional;

class User {
    private Optional<Contact> contact;
    public User(Optional<Contact> contact) { this.contact = contact; }
    public Optional<Contact> getContact() { return contact; }
}
