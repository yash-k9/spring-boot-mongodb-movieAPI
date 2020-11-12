package com.movieApp.MovieAPI.controller;

import com.movieApp.MovieAPI.document.Movie;
import com.movieApp.MovieAPI.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


/**Todo
 * Add Description to API EndPoints
 */

@RestController
@RequestMapping("rest/movies")
public class MovieResource {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/AddMovie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            Movie _movie = movieRepository.save(movie);
            return new ResponseEntity<>(_movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/{val}")
    public ResponseEntity<Movie> findById(@PathVariable("val") String id){
        try{
            Optional<Movie> movie = movieRepository.findById(id);
            if(movie.isPresent()) {
                Movie _movie = movie.get();
                return new ResponseEntity<>(_movie, HttpStatus.FOUND);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/modifyMovie")
    public ResponseEntity<Movie> modifyMovie(@RequestBody Movie movie){
        try {
            Optional<Movie> _movie = movieRepository.findById(movie.getId());
            if(_movie.isPresent()){
                movieRepository.save(_movie.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAll(){
        try {
            movieRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
        try {
            movieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
