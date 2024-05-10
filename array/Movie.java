package array;

import java.util.*;
import java.io.*;
import array.HAT.*;

public class Movie{
	public HAT<String> movieList; 
	public Movie(){
		this.movieList = new HAT<String>(6); 
	}

	// fix this so that commas within the title, etc. do not conflict with the indexing 
	public void injestData(boolean isToy){
		String filePath = ""; 
		if(isToy) {filePath = "array/toyMovies.csv";}
		else {filePath = "array/movies.csv";}

		try{
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);
			scanner.nextLine(); 
			while (scanner.hasNextLine()) {
				String movieStr = scanner.nextLine();
				String[] movieArr = movieStr.split(","); 

				MovieInfo movie = new MovieInfo(movieArr[0], movieArr[1], movieArr[2], Integer.parseInt(movieArr[3]), 
													Double.parseDouble(movieArr[6]), movieArr[8], movieArr[10]);
				movieList.add("\n" + movie.toString() + "\n"); 
            }
		}
		catch(FileNotFoundException e){
			 System.err.println("File not found: " + e.getMessage());
		}
		System.out.println("(Injested "+this.movieList.size()+" from the file)");
		System.out.println(); 
	}

	// from past labs 
	public static int getIntFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) { scanner.nextLine(); }
        return scanner.nextInt();
    }

    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) { scanner.nextLine(); }
        return scanner.nextLine();
    }

    public HAT<String> getArray(){
		return this.movieList; 
	}

	public static void main(String[] args){
		Movie list = new Movie(); 
		boolean isToy = true; 
		// isToy = false; 
		list.injestData(isToy); 
		// System.out.println(list.getArray()); 
		System.out.println(); 

		System.out.println("Welcome to HATboxd :D");
        System.out.println("- Choose a query to filter & sort by (type & enter the number):");
        System.out.println("-- 1) Rating   2) Genre   3) Year   4) Director   5) Star");
        System.out.println("--- type & enter 0 to quit"); 

        while (true) {  
        	int intChoice = getIntFromUser(); 
            if (intChoice == 1){
            	System.out.println(); 
            	System.out.println("Which rating?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	// sort 
            }

            if (intChoice == 0){
            	System.out.println("program end D:");
            	break; 
            }

            System.out.println(list.getArray()); 
       		System.out.println(); 
        	System.out.println("- Sort by another query?");
        	System.out.println("-- 1) Rating   2) Genre   3) Year   4) Director   5) Star");
        	System.out.println("--- type & enter 0 to quit");
        }
    } 
}
	
