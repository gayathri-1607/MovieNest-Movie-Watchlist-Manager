package com.movie.service;

import java.util.List;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;

public interface MovieService {
	void addMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie getMovieById(int id) throws MovieNotFoundException;

    void updateMovie(Movie movie) throws MovieNotFoundException;

    void deleteMovie(int id) throws MovieNotFoundException;
}
