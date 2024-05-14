package array;

import java.util.*;
import java.io.*;

public class HAT<T> implements List<T> {

	// constants 
	private static final double GROWTH_FACTOR = 2.0;
	private static final int DEFAULT_INITIAL_CAPACITY = 4; // a power of 2 default capacity (as given by the rules of a HAT)

	//instance variables
	// using position instance variables largely to keep runtime down when appending 
	private int size; // number of elements inside the entire array (both parent & child)
	private int parentPosition; // indices to keep track in the parent array 
	private int childPosition; // child array that is attached to each element in the parent
	private Object[][] parent;

	// specified capacity constructor
	// throws an error if the given capacity is not a power of 2
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
	// prints the hashed array tree in square brackets, with a case that checks if 
	// a space is null (will not print the null spaces if included)
	public String toString(){
		String out = "[";
		for (int i = 0; i < parent.length; i++){
			for (int j = 0; j < parent.length; j++){
				if(parent[i][j]==null){
					out+= "]";
					return out;
				}
				out += parent[i][j] + ", ";
			}
		}
		out += "]";
		return out; 
	}

	// adds a specified element to a spot inside a child aray of the parent. if reaches capacity, 
	// double the size of the array.
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

	// Natalia 
	// set an element inside the array to an element with the specified indices 
	public void set(int parentIndex, int childIndex, T element){
		parent[parentIndex][childIndex] = element;
	}

	// Savannah
	// returns the size of the tree
	public int size(){
		return size; 
	}

	// Natalia
	// returns true if the tree is empty (if there are no elements inside the HAT)
	public boolean isEmpty(){
		return size() == 0;
	}

	// Natalia
	// returns true if the HAT contains the specified element 
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

	// Savannah
	// gets the element at a specified parent and child index
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
		test.add(17); 
		test.add(18); 
		System.out.println(test); 
		test.add(17); 
		System.out.println();
		System.out.println("HAT with 17 elements after being resized with a new capacity of 8");
		System.out.println(test);
	}
}
