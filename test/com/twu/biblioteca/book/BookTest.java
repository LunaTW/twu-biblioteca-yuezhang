package com.twu.biblioteca.book;

import java.time.Year;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book = new Book("01","The little prince","Antoine de Saint-Exupery","9787539998312", Year.of(2017),"*");

    @Test
    public void Book_CheckFunctionCanBeUsed_Title_Author_Isbn_Year(){
        assertEquals(book.getindex(),"01");
        assertEquals(book.getTitle(),"The little prince");
        assertEquals(book.getAuthor(),"Antoine de Saint-Exupery");
        assertEquals(book.getIsbn(),"9787539998312");
        assertEquals(book.getYear(),Year.of(2017));
        assertEquals(book.getBorrowed(),"*");
    }
}