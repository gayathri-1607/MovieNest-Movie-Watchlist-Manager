package com.movie.dao;

import java.util.List;
import com.movie.model.Movie;
import com.movie.exception.MovieNotFoundException;

public interface MovieDao {
	
	void createTable(); 
	
    void save(Movie movie);

    List<Movie> findAll();

    Movie findById(int id) throws MovieNotFoundException;

    void update(Movie movie) throws MovieNotFoundException;

    void deleteById(int id) throws MovieNotFoundException;
}

