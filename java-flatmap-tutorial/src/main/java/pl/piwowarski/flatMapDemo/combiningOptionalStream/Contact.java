package pl.piwowarski.flatMapDemo.combiningOptionalStream;

import java.util.Optional;

class Contact {
    private String email;
    public Contact(String email) { this.email = email; }
    public Optional<String> getEmail() { return Optional.ofNullable(email); }
}
