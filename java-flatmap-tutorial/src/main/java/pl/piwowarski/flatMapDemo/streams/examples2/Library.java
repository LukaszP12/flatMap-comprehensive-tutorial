package pl.piwowarski.flatMapDemo.streams.examples2;

import java.util.List;

class Library {
    String name;
    List<Book> books;
    Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
    public List<Book> getBooks() { return books; }
}
