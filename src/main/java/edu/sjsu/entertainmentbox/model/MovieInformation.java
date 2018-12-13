package edu.sjsu.entertainmentbox.model;

public class MovieInformation {
	
	   private int movieId;
	   private String movieTitle;
	   private String movieLink;
	   private String disabled;
	   private String note;
	   MovieInformation() {
		   
	   }
	   
	public MovieInformation(int movieId, String movieTitle, String movieLink, String disabled, String note) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieLink = movieLink;
		this.disabled = disabled;
		this.note = note;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieLink() {
		return movieLink;
	}
	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
