package array;

import java.util.*;
import java.io.*;
import array.HAT.*;
import array.Movie.*; 

public class Reviews{
	public String title; 
	public ArrayList<String> filmReviews; 

	public Reviews(String title){
		this.title = title; 
		this.filmReviews = new ArrayList<String>(); 
	}

	public ArrayList<String> get(){
		return filmReviews;  
	}

	public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) { scanner.nextLine(); }
        return scanner.nextLine();
    }
	
	public static void main(String[] args){
		System.out.println("Enter a movie name: ");
		String name = getStringFromUser(); 

		Reviews test = new Reviews(name); 
		System.out.println("Enter your review: "); 
		String text = getStringFromUser(); 
		test.get().add(text); 
	}
}

