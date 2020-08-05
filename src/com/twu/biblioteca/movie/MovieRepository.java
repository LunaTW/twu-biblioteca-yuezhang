package com.twu.biblioteca.movie;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {
    public static List<Movie> availableMovies = new ArrayList<>(Arrays.asList(
            new Movie("Green Book","Peter Farrelly", Year.of(2018)),
            new Movie("The Shawshank Redemption","Frank Darabont",Year.of(1994)),
            new Movie("The Godfather","Francis Ford Coppola",Year.of(1972)),
            new Movie("The Godfather: Part II","Francis Ford Coppola",Year.of(1974))
    ));

    public static List<Movie> checkedOutMovies = new ArrayList<>(Arrays.asList(
            new Movie("Back to the Future","Robert Zemeckis",Year.of(1985)),
            new Movie("1917","Sam Mendes",Year.of(2019))
    ));

    public MovieRepository(List<Movie> availableMovies) {
    }

    public static List<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public static List<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }
    public void addMovie(Movie movie) {
        availableMovies.add(movie);
    }

    public static boolean judgment_checkOutMovie(String title){
        Movie MovieWouldLikeToCheckOut = availableMovies.stream().filter(movie -> movie.getTitle().equals(title))
                .findFirst().orElse(null);
        if(MovieWouldLikeToCheckOut != null){
            availableMovies.remove(MovieWouldLikeToCheckOut);
            checkedOutMovies.add(MovieWouldLikeToCheckOut);
            return true;
        }else{
            return false;
        }
    }

    public static boolean judgment_returnMovie(String title) {
        Movie MovieWouldLikeToReturn = checkedOutMovies.stream().filter(movie -> movie.getTitle().equals(title))
                .findFirst().orElse(null);
        if(MovieWouldLikeToReturn != null){
            availableMovies.add(MovieWouldLikeToReturn);
            checkedOutMovies.remove(MovieWouldLikeToReturn);
            return true;
        }else{
            return false;
        }
    }

    public static void displayMovies(){
        System.out.printf("%-30s%-2s%-30s%-2s%-6s%n","** Title **","|", "** Director **","|","** Year **");
        for(Movie movie:getAvailableMovies()){
            System.out.printf("%-30s%-2s%-30s%-2s%-6s%n", movie.getTitle(),"|",movie.getDirector(),"|",movie.getYear());
        }
    }

    public static void checkOutMovie(String movieName){
        String input = movieName;
        System.out.println(judgment_checkOutMovie(input)? "Thank you! Enjoy the movie." : "Sorry, that movie is not available.");
    }

    public static void returnMovie(String movieName){
        String input = movieName;
        System.out.println(judgment_returnMovie(input)? "Thanks for your return, have a good day" : "This movie may not borrowed from our library, please contact the librarian if not.");
    }
}
