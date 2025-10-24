package pl.piwowarski.flatMapDemo.optional;

import java.util.Optional;


class Basic2 {
    public static void main(String[] args) {
        Optional<String> maybeNumber = Optional.of("123");

        Optional<Integer> result = maybeNumber.flatMap(Basic2::parseInt);
        System.out.println(result);
    }

    public static Optional<String> getCity(User user) {
        return Optional.ofNullable(user)
                .flatMap(User::getAddress)       // returns Optional<Address>
                .flatMap(Address::getCity);      // returns Optional<String>
    }

    static Optional<Integer> parseInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
