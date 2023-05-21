package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
    static List<Movie> moviesList = new ArrayList<>();
    static List<Director> directorsList = new ArrayList<>();
    static HashMap<Director, List<Movie>> movieDirectorPair = new HashMap<>();
    public void addMovie(Movie movie){
        moviesList.add(movie);
    }
    public void addDirector(Director director){
        directorsList.add(director);
    }
    public static Director getDirectorByName(String director){
        for(Director directors : directorsList){
            if(directors.getName().equals(director)){
                return directors;
            }
        }
        return null;
    }
    public static Movie getMovieByName(String movie){
        for(Movie movies : moviesList){
            if(movies.getName().equals(movie)){
                return movies;
            }
        }
        return null;
    }
    public void addPair(String movie , String director){
        Director tempDirector = getDirectorByName(director);
        Movie tempMovie = getMovieByName(movie);
        List<Movie> addingMovie = movieDirectorPair.getOrDefault(tempDirector,new ArrayList<>());
        addingMovie.add(tempMovie);
        movieDirectorPair.put(tempDirector,addingMovie);
    }
    public static List<Movie> getList(Director director){
        return movieDirectorPair.getOrDefault(director,new ArrayList<>());
    }
    public static List<Movie> getAllMovies(){
        return moviesList;
    }
    public static void deleteDirector(String director){
        Director directorToRemove = getDirectorByName(director);
        List<Movie> movieList = movieDirectorPair.getOrDefault(directorToRemove,new ArrayList<>());
        for(Movie movie : movieList){
            moviesList.remove(movie);
        }
        directorsList.remove(directorToRemove);
        movieDirectorPair.remove(directorToRemove);
    }
    public static void deleteAllD(){
        for(Director director : directorsList){
            deleteDirector(director.getName());
        }
        directorsList.clear();
    }
}
