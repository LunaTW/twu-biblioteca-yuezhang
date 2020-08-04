package com.twu.biblioteca.book;

import java.time.Year;

public class Book {
    private String index;
    private String author;
    private String isbn;
    private String title;
    private Year year;
    private String borrowed;

    public Book(String index, String title, String author, String isbn, Year year,String borrowed) {
        this.index=index;
        this.title=title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.borrowed = borrowed;
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
    public String getBorrowed() {
        return borrowed;
    }
}
