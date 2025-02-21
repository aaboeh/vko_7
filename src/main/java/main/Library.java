package main;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listBooks() {
        int bookCount = 0;
        for (Book book : books) {
            book.displayInfo();
            bookCount += book.copies;
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + bookCount);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }
    
}
