package com.movieApp.MovieAPI.config;

import com.movieApp.MovieAPI.repository.MovieRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.config.DefaultRepositoryBaseClass;
import org.springframework.stereotype.Repository;

@Configuration
@EnableMongoRepositories(basePackageClasses = MovieRepository.class)
public class MongoDbConfig {
}
