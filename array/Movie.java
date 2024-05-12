package array;

import java.util.*;
import java.io.*;
import array.HAT.*;

public class Movie{
	public HAT<String> movieList; 
	public ArrayList<MovieInfo> list; 
	public Movie(){
		this.movieList = new HAT<String>(6); 
		this.list = new ArrayList<MovieInfo>(); 
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

				if(movieArr.length > 15){
					int numOfCommas = 0;
					String movieTitle = movieStr.substring(movieStr.indexOf('"'), movieStr.indexOf('"', 2));
					for(int i = 0; i < movieTitle.length(); i++){
						if (movieTitle.charAt(i) == ','){
							numOfCommas++;
						}
					}

					String[] newMovieArr = new String[movieArr.length - numOfCommas];
					int newIndex = 0;
					boolean titleAdded = false;
					for(int i = 0; i < movieArr.length; i++){
						if(!titleAdded && movieArr[i].contains("\"")){
							newMovieArr[newIndex++] = movieArr[i].substring(1);
							while (!movieArr[i].endsWith("\"")) {
           						i++;
           						newMovieArr[newIndex - 1] += "," + movieArr[i];
							}
							newMovieArr[newIndex - 1] = newMovieArr[newIndex - 1].substring(0, newMovieArr[newIndex - 1].length() - 1);
           					titleAdded = true;
						} else {
						newMovieArr[newIndex++] = movieArr[i];
						}
					}
					// String newTitle = "";
					// for(int i = 0; i < numOfCommas; i++){
					// 	newTitle += movieArr[i];
					// }
					// newMovieArr[0] = newTitle;
					// for(int i = 1; i < newMovieArr.length; i++){
					// 	newMovieArr[i] = movieArr[i + numOfCommas];
					// }
					movieArr = newMovieArr;
				}

				MovieInfo movie = new MovieInfo(movieArr[0], movieArr[1], movieArr[2], Integer.parseInt(movieArr[3]), Double.parseDouble(movieArr[6]), movieArr[8], movieArr[10]);
				list.add(movie); 
            }
		}
		catch(FileNotFoundException e){
			 System.err.println("File not found: " + e.getMessage());
		}
		System.out.println("(Injested "+this.list.size()+" from the file)");
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

    // to get the sortted HAT  
    public HAT<String> getArray(){
    	return this.movieList; 
	}

	// insertion sort that is called on the instance variable arraylist to sort all of the movies 
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

		for (int i = 0; i < n2; i++){
    		String toAdd = l.get(i).getName(); 
    		if (!movieList.contains(toAdd)){
    			this.movieList.add(toAdd + " (" + insert + ", " + l.get(i).getScore() + ")");
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
            	System.out.println("Your sorted array:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 2){
            	System.out.println(); 
            	System.out.println("Which genre?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.getList(new ScoreComparator(), strChoice); 
            	System.out.println(); 
            	System.out.println("Your sorted array:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 3){
            	System.out.println(); 
            	System.out.println("Which year? [1986-2020]"); 
            	System.out.println(); 
            	int intChoice2 = getIntFromUser();  
            	list.getList(new ScoreComparator(), Integer.toString(intChoice2)); 
            	System.out.println(); 
            	System.out.println("Your sorted array:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 4){
            	System.out.println(); 
            	System.out.println("Which director?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.getList(new ScoreComparator(), strChoice); 
            	System.out.println(); 
            	System.out.println("Your sorted array:");
            	System.out.println(list.getArray()); 
            }

            if (intChoice == 5){
            	System.out.println(); 
            	System.out.println("Which actor/actress?"); 
            	System.out.println(); 
            	String strChoice = getStringFromUser(); 
            	list.getList(new ScoreComparator(), strChoice); 
            	System.out.println(); 
            	System.out.println("Your sorted array:");
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
	
