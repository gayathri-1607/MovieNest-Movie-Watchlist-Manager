package com.movie.service;

import java.util.List;

import com.movie.dao.MovieDao;
import com.movie.dao.MovieDaoImpl;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;

public class MovieServiceImpl implements MovieService {

    MovieDao dao = new MovieDaoImpl();

    public void addMovie(Movie movie) {
        dao.save(movie);
    }

    public List<Movie> getAllMovies() {
        return dao.findAll();
    }

    public Movie getMovieById(int id) throws MovieNotFoundException {
        return dao.findById(id);
    }

    public void updateMovie(Movie movie) throws MovieNotFoundException {
        dao.update(movie);
    }

    public void deleteMovie(int id) throws MovieNotFoundException {
        dao.deleteById(id);
    }
}
