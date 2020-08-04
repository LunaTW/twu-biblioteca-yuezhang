package com.twu.biblioteca.book;

import java.time.Year;

public class Book {
    private String index;
    private String author;
    private String isbn;
    private String title;
    private Year year;

    public Book(String index, String title, String author, String isbn, Year year) {
        this.index=index;
        this.title=title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getindex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Year getYear() {
        return year;
    }
    public String getIsbn() {
        return isbn;
    }
}
