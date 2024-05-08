package array;

import java.util.*;
import java.io.*;

public class HAT<T> implements List<T> {

	// constants 
	private static final double GROWTH_FACTOR = 2.0;
	private static final int DEFAULT_INITIAL_CAPACITY = 4; // a power of 2 default capacity (as given by the rules of a HAT)

	//instance variables
	private int size; // number of elements inside the entire array (both parent & child)
	private int parentPosition; // indices to keep track to keep runtime down (parent array)
	private int childPosition; // (child array that is attached to each element in the parent)
	private Object[][] parent;

	// specified capacity constructor 
	public HAT(int capacity){
		if (capacity % 2 != 0) throw new IllegalArgumentException("capacity is not a power of 2");
		parent = new Object[capacity][capacity];
		size = 0;
		parentPosition = 0;
		childPosition = 0;
	}

	// default capacity constructor 
	public HAT(){
		parent = new Object[DEFAULT_INITIAL_CAPACITY][DEFAULT_INITIAL_CAPACITY];
		size = 0; 
		parentPosition = 0; 
		childPosition = 0; 
	}

	@Override
	public String toString(){
		String out = "[";
		for (int i = 0; i < parent.length; i++){
			for (int j = 0; j < parent.length; j++){
				// if(parent[i][j]==null){
				// 	out+= "]";
				// 	return out;
				// }
				out += parent[i][j] + ", ";
			}
		}
		out += "]";
		return out; 
	}

	//Savannah
	//add an element to both parent and child arrays. If reaches capacity, double the size of the array.
	public void add(T element){
		checkExpand();
		if (childPosition == parent.length){
			childPosition = 0; 
			parentPosition++; 
			parent[parentPosition][childPosition] = element; 
		}
		parent[parentPosition][childPosition++] = element; 
		size++; 
	}

	/**
	 * works when the capacity resizes from two to four, fix so that it works for 
	 * later resizes 
	 */ 
	private void checkExpand(){
		if (size == Math.pow(parent.length,2)){
			int oldSize = size;
			int newSize = (int) (parent.length * GROWTH_FACTOR);
			Object[][] newParent = new Object[newSize][newSize]; 

			int newParentPosition = 0;
			int newChildPosition = 0;  	
			for (int i = 0; i < parent.length; i++){
                for (int j = 0; j < parent.length; j++){
                    if (newChildPosition == newSize){
                    	newChildPosition = 0;
                    	newParentPosition++;	
                    }  
                    newParent[newParentPosition][newChildPosition++] = parent[i][j];
                }
            }
            parentPosition = size/newSize;
            childPosition = 0;
            parent = newParent;
		}
	}

	//Natalia 
	//Set element in index if it's empty.
	public void set(int parentIndex, int childIndex, T element){
		parent[parentIndex][childIndex] = element;
	}

	// //returns the size of the tree
	// //Savannah
	public int size(){
		return size; 
	}

	// //returns true if the tree isEmpty
	// //Natalia
	public boolean isEmpty(){
		return size() == 0;
	}

	// //returns true if contains element 
	// //Natalia
	public boolean contains(T element){
		for(int i = 0; i < parent.length; i++){
			for(int j = 0; j < parent.length; j++){
				if(parent[i][j] == element){
					return true;
				}
			}		
		}
		return false; 
	}

	// //gets the element at a specified parent and child index
	// //Savannah
	public Object get(int parentIndex, int childIndex){
		return parent[parentIndex][childIndex]; 
	}

	public static void main(String[] args){
		HAT test = new HAT<Integer>(2); 
		System.out.println();
		System.out.println("HAT with 4 elements and capacity of 2: ");
		test.add(0); 
		test.add(1);
		test.add(3); 
		test.add(4); 
		System.out.println(test);
		test.add(5);
		System.out.println();
		System.out.println("HAT with 5 elements after being resized with a new capacity of 4: ");
		System.out.println(test); 
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		test.add(11);
		test.add(12);
		test.add(13);
		test.add(14);
		test.add(15);
		test.add(16);
		System.out.println();
		System.out.println("HAT with 16 elements with a capacity of 4: ");
		System.out.println(test); 

		test.add(17); 
		System.out.println();
		System.out.println("HAT with 17 elements after being resized with a new capacity of 8");
		System.out.println(test);
	}

}
