package pl.piwowarski.flatMapDemo.streams.examples6;

import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie(List.of(new Actor("Tom"), new Actor("Emma"))),
                new Movie(List.of(new Actor("Tom"), new Actor("Chris")))
        );

        List<String> actorsName = movies.stream()
                .map(Movie::getCast)
                .flatMap(List::stream)
                .map(actor -> actor.name)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("actorsName: ");
        System.out.println(actorsName);
    }
}
