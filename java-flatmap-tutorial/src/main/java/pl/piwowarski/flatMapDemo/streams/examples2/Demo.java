package pl.piwowarski.flatMapDemo.streams.examples2;

import java.util.List;
import java.util.stream.Collectors;

class Demo {
    public static void main(String[] args) {
        List<Library> libraries = List.of(
                new Library("City Library", List.of(
                        new Book("Java 101", List.of(new Author("Alice"), new Author("Bob"))),
                        new Book("Spring Boot", List.of(new Author("Charlie")))
                )),
                new Library("Community Library", List.of(
                        new Book("Data Structures", List.of(new Author("Alice"), new Author("David"))),
                        new Book("Algorithms", List.of(new Author("Eve")))
                ))
        );

        List<String> authors = libraries.stream()
                .flatMap(library -> library.getBooks().stream())
                .flatMap(book -> book.authors.stream())
                .map(Author::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(authors);
    }
}
