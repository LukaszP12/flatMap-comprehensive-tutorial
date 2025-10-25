package pl.piwowarski.flatMapDemo.combiningOptionalStream;

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
