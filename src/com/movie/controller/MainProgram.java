package com.movie.controller;

import java.util.List;

import com.movie.model.Movie;
import com.movie.service.MovieService;
import com.movie.service.MovieServiceImpl;
import com.movie.dao.MovieDaoImpl;
import com.movie.exception.MovieNotFoundException;

public class MainProgram {

    public static void main(String[] args) {
    	
    	MovieDaoImpl dao = new MovieDaoImpl();

        dao.createTable();
         
        MovieService service = new MovieServiceImpl();
       
        service.addMovie(new Movie(1, "Inception", "Sci-Fi", 9.0, "Watched"));
        service.addMovie(new Movie(2, "Interstellar", "Sci-Fi", 9.2, "Watched"));
        service.addMovie(new Movie(3, "Jawan", "Action", 8.0, "Not Watched"));

        System.out.println("All Movies:");
        List<Movie> movies = service.getAllMovies();
        movies.forEach(System.out::println);

        try {
            System.out.println("\nFind Movie By ID:");
            System.out.println(service.getMovieById(1));

            service.deleteMovie(3);

        } catch (MovieNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
