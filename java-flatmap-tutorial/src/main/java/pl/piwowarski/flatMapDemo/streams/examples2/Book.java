package pl.piwowarski.flatMapDemo.streams.examples2;

import java.util.List;

class Book {
    String title;
    List<Author> authors;
    Book(String title, List<Author> authors) {
        this.title = title;
        this.authors = authors;
    }
    public List<Author> getAuthors() { return authors; }
}
