package com.movieApp.MovieAPI.repository;

import com.movieApp.MovieAPI.document.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String>{

}