package array;

import java.util.*;
import java.io.*;

public class MovieInfo{
	private String movieName; 
	private String rating;
	private String genre; 
	private int year; 
	private double score; 
	private String director; 
	private String star; 

	public MovieInfo(String movieName, String rating, String genre, int year, double score, String director, String star){
		this.movieName = movieName; 
		this.rating = rating; 
		this.genre = genre; 
		this.year = year; 
		this.score = score; 
		this.director = director; 
		this.star = star; 
	}

	@Override
	// each object starts and ends with a curly bracket to differentiate each object inside a list 
	public String toString(){
		return "{" + movieName + "\n" + rating + ", " + genre + ", " + year + ", " + score + ", " + director + ", " + star + "}"; 
	}

	// getter methods for each part of a movie we are looking at 
	public String getName(){
		return movieName; 
	}

	public String getRating(){
		return rating; 
	}

	public String getGenre(){
		return genre; 
	}

	public int getYear(){
		return year; 
	}

	public double getScore(){
		return score; 
	}

	public String getDirector(){
		return director; 
	}

	public String getStar(){
		return star; 
	}

	public static void main(String[] args){
		MovieInfo test = new MovieInfo("The Shining", "R", "Drama", 1980, 8.4, "Stanley Kubrick", "Jack Nicholson"); 
		System.out.println(test); 
		System.out.println(test.getName()); 
		System.out.println(test.getRating()); 
		System.out.println(test.getGenre()); 
		System.out.println(test.getYear()); 
		System.out.println(test.getScore()); 
		System.out.println(test.getDirector()); 
		System.out.println(test.getStar()); 
	}
}
