package pl.piwowarski.flatMapDemo.optional.example1;

import java.util.Optional;

class OptionalFlatMapExample {

    public static void main(String[] args) {
        Country usa = new Country("+1");
        Phone phone = new Phone(Optional.of(usa));
        Contact contact = new Contact(Optional.of(phone));
        User user = new User(Optional.of(contact));

        String result = Optional.of(user)
                .flatMap(User::getContact)
                .flatMap(Contact::getPhone)
                .flatMap(Phone::getCountry)
                .map(Country::getDialingCode)
                .orElse("N/A");

        System.out.println("Dialing Code: " + result);
    }
}
