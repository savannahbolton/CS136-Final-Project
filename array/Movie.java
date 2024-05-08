package array;

import java.util.*;
import java.io.*;
import array.HAT.*;

public class Movie{
	public HAT<String> movieList; 
	public Movie(){
		this.movieList = new HAT<String>(6); 
	}

	public void injestData(boolean isToy){
		String filePath = ""; 
		if(isToy) {filePath = "array/toyMovies.csv";}
		else {filePath = "array/movies.csv";}

		try{
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				scanner.nextLine(); 
				String movieStr = scanner.nextLine();
				String[] movieArr = movieStr.split(","); 

				MovieInfo movie = new MovieInfo(movieArr[0], movieArr[1], movieArr[2], Integer.parseInt(movieArr[3]), Double.parseDouble(movieArr[5]), movieArr[7], movieArr[9]);
				movieList.add(movie.toString()); 
            }
		}
		catch(FileNotFoundException e){
			 System.err.println("File not found: " + e.getMessage());
		}
		System.out.println("Injested "+this.movieList.size()+" from the file"); 
	}

	public static void main(String[] args){
		Movie list = new Movie(); 
		boolean isToy = true; 
		// isToy = false; 
		list.injestData(isToy); 
		System.out.println(list); 
	}
}