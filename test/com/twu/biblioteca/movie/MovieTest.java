package com.twu.biblioteca.movie;

import org.junit.Test;
import java.time.Year;
import static org.junit.Assert.assertEquals;

public class MovieTest {
    Movie movie = new Movie("Green Book","Peter Farrelly",Year.of(2018));

    @Test
    public void Movie_CheckFunctionCanBeUsed_Title_Director_Year(){
        assertEquals(movie.getTitle(),"Green Book");
        assertEquals(movie.getDirector(),"Peter Farrelly");
        assertEquals(movie.getYear(),Year.of(2018));
    }
}
