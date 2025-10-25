package pl.piwowarski.flatMapDemo.combiningOptionalStream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class OptionalStreamExample {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(new Contact("alice@example.com")),
                new User(null),
                new User(new Contact(null)),
                new User(new Contact("bob@example.com"))
        );

        List<String> emails = users.stream()
                .map(User::getContact)
                .flatMap(Optional::stream)
                .map(Contact::getEmail)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println(emails);
    }
}
