package array;

import java.util.*;
import java.io.*;
import array.HAT.*;

public class Movie{

	public HAT<String> movieList; // the hashed array tree that the filtered & sorted elements will be added to 
	public ArrayList<MovieInfo> list; // a list of every movie from the data set so that it can be filtered

	public Movie(){
		this.movieList = new HAT<String>(6); 
		this.list = new ArrayList<MovieInfo>(); 
	}

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

				if(movieArr.length != 15){
					int startPosition = 0;
					int arrayPosition = 0;
					boolean isInQuotes = false;
					String[] newMovieArr = new String[15];
					for(int i = 0; i < movieStr.length(); i++){
						if(i == movieStr.length() || movieStr.charAt(i) == ','){
							if(!isInQuotes){
								newMovieArr[arrayPosition++] = movieStr.substring(startPosition, i);
               					startPosition = i + 1;
							}
						} else if (movieStr.charAt(i) == '\"'){
							isInQuotes = !isInQuotes;
						}
					}
					movieArr = newMovieArr;
				}

				MovieInfo movie = new MovieInfo(movieArr[0], movieArr[1], movieArr[2], Integer.parseInt(movieArr[3]), Double.parseDouble(movieArr[5]), movieArr[7], movieArr[9]);
				list.add(movie); 	
            }
		}
		catch(FileNotFoundException e){
			 System.err.println("File not found: " + e.getMessage());
		}
		System.out.println("(Injested "+this.list.size()+" films from the file)");
	}

	// to get the query category from the user 
	public static int getIntFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) { scanner.nextLine(); }
        return scanner.nextInt();
    }

    // to get the specific information to filter by 
    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) { scanner.nextLine(); }
        return scanner.nextLine();
    }

    // to get the sorted HAT
    public HAT<String> getArray(){
    	return this.movieList; 
	}

	// insertion sort that is called on the instance variable arraylist to sort all of the movies.
	// it will check if any part of a MovieInfo object is equal to the inserted string (which will be the 
	// user input obtained from the getStringFromUser())
	// from lab 5
	public void getList(Comparator<MovieInfo> comp, String insert){
		ArrayList<MovieInfo> l = new ArrayList<MovieInfo>();
		this.movieList = new HAT<String>(6);
		int n1 = this.list.size(); 
		for (int i = 0; i < n1; i++){
			if (list.get(i).getRating().equals(insert) || list.get(i).getGenre().equals(insert) || Integer.toString(list.get(i).getYear()).equals(insert) || Double.toString(list.get(i).getScore()).equals(insert) || list.get(i).getDirector().equals(insert) || list.get(i).getStar().equals(insert)){
				MovieInfo toAdd = this.list.get(i); 
				l.add(toAdd); 
			}
		}

		int n2 = l.size(); 
		for (int i = 1; i < n2; i++){
			MovieInfo temp = l.get(i);
			int j = i;

			while (j > 0 && comp.compare(l.get(j - 1), temp) > 0){
					l.set(j, l.get(j - 1));
					j--;
				}

			l.set(j, temp);
		}

		if (l.size() == 0){
			System.out.println("Nothing fits this query!"); 
		}

		if (l.size() < 5){
			for (int i = 0; i < l.size(); i++){
				String toAdd = l.get(i).getName(); 
				if (!movieList.contains(toAdd)){
    			this.movieList.add(toAdd + " (" + insert + ", " + l.get(i).getScore() + ")");
    			}
			}
		}

		else{
			for (int i = 0; i < 5; i++){
    			String toAdd = l.get(i).getName(); 
    			if (!movieList.contains(toAdd)){
    			this.movieList.add(toAdd + " (" + insert + ", " + l.get(i).getScore() + ")");
    			}
    		}
		}
	}

	public static void main(String[] args){
		Movie list = new Movie(); 
		boolean isToy = true; 
		isToy = false; 
		list.injestData(isToy);
		
		System.out.println("Welcome to HATboxd :D");
        System.out.println("- Choose a query to filter & sort by (type & enter the number):");
        System.out.println("-- 1) Rating   2) Genre   3) Year   4) Director   5) Star");
        System.out.println("--- type & enter 0 to quit"); 

        while (true) {  
        	int intChoice = getIntFromUser(); 
            if (intChoice == 1){
            	System.out.println(); 
            	System.out.println("Which rating? [G, PG, PG-13, R, Unrated]"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.getList(new ScoreComparator(), strChoice); 
            	System.out.println(); 
            	System.out.println("Your HATboxd:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 2){
            	System.out.println(); 
            	System.out.println("Which genre?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.getList(new ScoreComparator(), strChoice); 
            	System.out.println(); 
            	System.out.println("Your HATboxd:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 3){
            	System.out.println(); 
            	System.out.println("Which year? [1986-2020]"); 
            	System.out.println(); 
            	int intChoice2 = getIntFromUser();  
            	list.getList(new ScoreComparator(), Integer.toString(intChoice2)); 
            	System.out.println(); 
            	System.out.println("Your HATboxd:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 4){
            	System.out.println(); 
            	System.out.println("Which director?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.getList(new ScoreComparator(), strChoice); 
            	System.out.println(); 
            	System.out.println("Your HATboxd:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 5){
            	System.out.println(); 
            	System.out.println("Which actor/actress?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.getList(new ScoreComparator(), strChoice); 
            	System.out.println(); 
            	System.out.println("Your HATboxd:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 0){
            	System.out.println("program end D:");
            	break; 
            }
            System.out.println();
       		System.out.println(); 
        	System.out.println("- Sort by another query?");
        	System.out.println("-- 1) Rating   2) Genre   3) Year   4) Director   5) Star");
        	System.out.println("--- type & enter 0 to quit");
        }
    } 
}

class ScoreComparator implements Comparator<MovieInfo>{
    public int compare(MovieInfo movie1, MovieInfo movie2){
    	double rating1 = movie1.getScore();
    	double rating2 = movie2.getScore(); 
        if (rating1 < rating2) return 1; 
        if (rating1 > rating2) return -1; 
        return 0; 
    }
}
	
