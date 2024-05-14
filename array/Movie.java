package array;

import java.util.*;
import java.io.*;
import array.HAT.*;

public class Movie{

	public HAT<String> movieList; // the hashed array tree that the filtered & sorted elements will be added to 
	public ArrayList<MovieInfo> list; // a list of every movie from the data set so that it can be filtered

	// constructor 
	public Movie(){
		this.movieList = new HAT<String>(6); 
		this.list = new ArrayList<MovieInfo>(); 

	}

	// to injest the data, accounting for any additional commas that may be in titles or dates 
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

    // to get the sorted HAT
    public HAT<String> getArray(){
    	return this.movieList; 
	}

	// sort that is called on the instance variable arraylist to sort all of the movies.
	// it will check if any part of a MovieInfo object is equal to the inserted string (which will be the 
	// user input obtained from the getStringFromUser())
	public void getList(String insert){
		ArrayList<MovieInfo> l = new ArrayList<MovieInfo>();
		this.movieList = new HAT<String>(6);
		int n1 = this.list.size(); 
		for (int i = 0; i < n1; i++){
			if (list.get(i).getRating().equals(insert) || list.get(i).getGenre().equals(insert) || Integer.toString(list.get(i).getYear()).equals(insert) || Double.toString(list.get(i).getScore()).equals(insert) || list.get(i).getDirector().equals(insert) || list.get(i).getStar().equals(insert)){
				MovieInfo toAdd = this.list.get(i); 
				l.add(toAdd); 
			}
		}

		// gnomesort written following the given pseudocode (linked in the readme)
		int q = 0; 
		int p = l.size(); 
			while (q < p){
				if (q == 0 || l.get(q).getScore() <= l.get(q - 1).getScore()){
				q++; 
				} else {
					// swapping the elements
					MovieInfo temp = l.get(q); 
					l.set(q, l.get(q - 1)); 
					l.set((q - 1), temp); 
					q--; 
				}
			}

		// if there is no information that fits the particular query 
		if (l.size() == 0){
			System.out.println("Nothing fits this query!"); 
		}

		// if there is information that fits, but not five things, so it will add what it has 
		if (l.size() < 5){
			for (int i = 0; i < l.size(); i++){
				String toAdd = l.get(i).getName(); 
				if (!movieList.contains(toAdd)){
    			this.movieList.add(toAdd + " (" + insert + ", " + l.get(i).getScore() + ")");
    			}
			}
		}

		// adds the top five rated films that fit the query 
		else{
			for (int i = 0; i < 5; i++){
    			String toAdd = l.get(i).getName(); 
    			if (!movieList.contains(toAdd)){
    			this.movieList.add(toAdd + " (" + insert + ", " + l.get(i).getScore() + ")");
    			}
    		}
		}
	}

	// method to call outside the main method for use in the MovieGraphics class
	public void graphics(String insert){
		this.getList(insert); 
		System.out.println(movieList); 
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
            	list.graphics(strChoice); 
            }

            if (intChoice == 2){
            	System.out.println(); 
            	System.out.println("Which genre?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.graphics(strChoice); 
            }

            if (intChoice == 3){
            	System.out.println(); 
            	System.out.println("Which year? [1986-2020]"); 
            	System.out.println(); 
            	int intChoice2 = getIntFromUser();  
            	list.graphics(Integer.toString(intChoice2)); 
            }

            if (intChoice == 4){
            	System.out.println(); 
            	System.out.println("Which director?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.graphics(strChoice); 
            }

            if (intChoice == 5){
            	System.out.println(); 
            	System.out.println("Which actor/actress?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.graphics(strChoice); 
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
