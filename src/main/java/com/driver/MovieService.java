package com.driver;


import java.util.ArrayList;
import java.util.List;

public class MovieService {
    static MovieRepository movieRepository = new MovieRepository();
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public static void addPair(String movie, String director){
        movieRepository.addPair(movie,director);
    }
    public static Movie getMovieByName(String movie){
        return MovieRepository.getMovieByName(movie);
    }
    public static Director getDirectorByName(String director){
        return MovieRepository.getDirectorByName(director);
    }
    public static List<String> getMoviesByDirector(String director){
        Director thisDirector = MovieRepository.getDirectorByName(director);
        List<String> returningThis = new ArrayList<>();
        List<Movie> movieList = MovieRepository.getList(thisDirector);
        for(Movie movies : movieList){
            returningThis.add(movies.getName());
        }
        return returningThis;
    }
    public static List<Movie> getAllMovies(){
        return MovieRepository.getAllMovies();
    }
    public static void deleteDirector(String director){
        MovieRepository.deleteDirector(director);
    }
    public static void deleteAllDirectors(){
        MovieRepository.deleteAllD();
    }
}
