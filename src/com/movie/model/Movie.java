package com.movie.model;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private double rating;
    private String status;
	
	public Movie() {
		super();
	}

	public Movie(int id, String title, String genre, double rating, String status) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.status = status;
	}

	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", rating=" + rating + ", status=" + status
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
