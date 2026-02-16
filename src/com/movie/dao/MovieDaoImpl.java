package com.movie.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.movie.connection.ConnectionFactory;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;

public class MovieDaoImpl implements MovieDao {
	
	public void createTable() {

	    String sql = "CREATE TABLE IF NOT EXISTS movie (" +
	            "id INT PRIMARY KEY," +
	            "title VARCHAR(100)," +
	            "genre VARCHAR(50)," +
	            "rating DOUBLE," +
	            "status VARCHAR(20)" +
	            ")";

	    try (Connection con = ConnectionFactory.getConnection();
	         Statement stmt = con.createStatement()) {

	        stmt.execute(sql);
	        System.out.println("Table created or already exists");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

    public void save(Movie movie) {

        String sql = "INSERT INTO movie VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, movie.getId());
            ps.setString(2, movie.getTitle());
            ps.setString(3, movie.getGenre());
            ps.setDouble(4, movie.getRating());
            ps.setString(5, movie.getStatus());

            ps.executeUpdate();
            System.out.println("Movie Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> findAll() {

        List<Movie> list = new ArrayList<>();
        String sql = "SELECT * FROM movie";

        try (Connection con = ConnectionFactory.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Movie(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Movie findById(int id) throws MovieNotFoundException {

        String sql = "SELECT * FROM movie WHERE id=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Movie(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                );
            } else {
                throw new MovieNotFoundException("Movie Not Found: " + id);
            }

        } catch (SQLException e) {
            throw new MovieNotFoundException("Database Error: " + e.getMessage());
        }
    }

    public void update(Movie movie) throws MovieNotFoundException {

        String sql = "UPDATE movie SET title=?, genre=?, rating=?, status=? WHERE id=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setDouble(3, movie.getRating());
            ps.setString(4, movie.getStatus());
            ps.setInt(5, movie.getId());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new MovieNotFoundException("Movie Not Found: " + movie.getId());
            }

            System.out.println("Movie Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) throws MovieNotFoundException {

        String sql = "DELETE FROM movie WHERE id=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new MovieNotFoundException("Movie Not Found: " + id);
            }

            System.out.println("Movie Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
