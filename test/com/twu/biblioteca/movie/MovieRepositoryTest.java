package com.twu.biblioteca.movie;

import org.junit.Test;
import java.time.Year;
import static org.junit.Assert.*;

public class MovieRepositoryTest {
    Movie movie = new Movie("Upcoming movie","YUE", Year.of(2023));

    @Test
    public void MovieCanBeAddedInMOVIELIST(){
        assertEquals(MovieRepository.availableMovies.stream().filter(movie -> movie.getTitle().equals("Upcoming movie")).findFirst().orElse(null),null);
        MovieRepository.availableMovies.add(movie);
        assertNotEquals(MovieRepository.availableMovies.stream().filter(movie -> movie.getTitle().equals("Upcoming movie")).findFirst().orElse(null),null);
    }

    @Test
    public void MovieCanBeReturnMOVIELIST(){
        MovieRepository.availableMovies.add(movie);
        assertTrue(MovieRepository.getAvailableMovies().contains(movie));
    }

    @Test
    public void AvailableMovieCanBeCheckOutMovieLIST(){
        assertTrue(MovieRepository.judgment_checkOutMovie("Green Book"));
        assertFalse(MovieRepository.judgment_returnMovie("WrongMovie"));
    }

    public void AvailableMovieCanBeReturnMOVIELIST(){
        assertTrue(MovieRepository.judgment_returnMovie("1917"));
        assertFalse(MovieRepository.judgment_returnMovie("WrongMovie"));
    }
}