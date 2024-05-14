package array;

import java.util.*;
import java.io.*;
import array.HAT.*;
import array.Movie.*; 

/**
 * A review class specifically for the reviews section of our interface. 
 * -- uses printwriter, filereader & bufferedreader to add text to the 
 * reviews.txt file, and to read that in to an arraylist that stores the 
 * information in strings
 */
public class Reviews{
	public String title; 
	public ArrayList<String> filmReviews; 

	public Reviews(){
		this.title = title; 
		this.filmReviews = new ArrayList<String>(); 
	}

	public static String getStringFromUser(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) { scanner.nextLine(); }
        return scanner.nextLine();
    }

    public void print(String name, String text) throws IOException{
    	PrintWriter pw = new PrintWriter(new FileWriter("array/reviews.txt", true));
		pw.write(name + ": " + text + "\n"); 
		pw.close(); 
    }

    public ArrayList<String> file() throws IOException{
    	FileReader f = new FileReader("array/reviews.txt");
    	BufferedReader t = new BufferedReader(f); 
    	String l = "";
    	while ((l = t.readLine()) != null){
    		filmReviews.add(l); 
    		System.out.println(l);
    		System.out.println(filmReviews);
    	}

    	f.close(); 
    	t.close(); 

    	ArrayList<String> newFilmReviews = new ArrayList<String>(); 
    	for (int i = 0; i < filmReviews.size(); i++){
    		String add = filmReviews.get(i);
    		if (!newFilmReviews.contains(add)){
    			newFilmReviews.add(add); 
    		}
    	}

    	return filmReviews = newFilmReviews; 
    }
	
	public static void main(String[] args) throws IOException{
		Reviews test = new Reviews(); 
		System.out.println("HATboxd reviews");
		System.out.println("Enter a film: "); 
		String input = getStringFromUser(); 
		System.out.println("Enter your review: ");
		String rev = getStringFromUser(); 
		test.print(input, rev); 
		System.out.println(test.file()); 

	}
}

