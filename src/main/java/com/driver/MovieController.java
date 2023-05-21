package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    MovieService movieService = new MovieService();
    @PostMapping("add-movie")
    public ResponseEntity<String> addMovies(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    @PostMapping("add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @PutMapping("add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie ,@RequestParam String director){
        MovieService.addPair(movie,director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie){
        Movie thisMovie = MovieService.getMovieByName(movie);
        return new ResponseEntity<>(thisMovie , HttpStatus.OK);
    }
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String director){
        Director thisDirector = MovieService.getDirectorByName(director);
        return new ResponseEntity<>(thisDirector , HttpStatus.OK);
    }
    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> list = MovieService.getMoviesByDirector(director);
        return new ResponseEntity<>(list , HttpStatus.OK);
    }
    @GetMapping("get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> allMovies = MovieService.getAllMovies();
        return new ResponseEntity<>(allMovies , HttpStatus.OK);
    }
    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        MovieService.deleteDirector(director);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        MovieService.deleteAllDirectors();
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
