package pl.piwowarski.flatMapDemo.optional;

import java.util.Optional;

class Basic {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        Optional<Integer> length = optional.flatMap(s -> Optional.of(s.length()));
        System.out.println("length.get(): " + length.get());
    }
}
