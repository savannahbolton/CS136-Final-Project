package array;

import java.util.*
import java.io.*

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
	pulic HAT(){
		parent = new Object[DEFAULT_INITIAL_CAPACITY][DEFAULT_INITIAL_CAPACITY];
		parentPosition = 0; 
		childPosition = 0; 
	}

	//Savannah
	//add an element to both parent and child arrays. If reaches capacity, double the size of the array.
	@Override
	public void add(T element){
		checkExpand(); 
		for (int i = 0; i < parent.size(); i++){
			for (int j = 0; j < parent.size(); j++){
				if (parent[i][j] == null){
					parent[i][j] = element; 
					size++; 
					break;
				}
			}
		}
	}

	// fix this tomorrow lol 
	private void checkExpand(){
		if (size == parent.length){
			int newSize = (int) parent.length * GROWTH_FACTOR; 
			Object[][] newArray = Object[newSize][newSize]; 

			for (int i = 0; i < newSize; i++){
				for (int j = 0; j < newSize; j++){
				newArray[i][j] = parent[i][j]; 
				}
			}
			this.parent = newArray; 
		}
	}

	//Natalia 
	//Set element in index if it's empty.
	@Override
	public void set(int parentIndex, int childIndex, T element){
		if(!parent.get(parentIndex).get(childIndex)){
			parent.add(element);
		}
	}

	//returns the size of the tree
	//Savannah
	@Override 
	public int size(){
		return size; 
	}

	//returns true if the tree isEmpty
	//Natalia
	@Override 
	public boolean isEmpty(){
		return size() == 0;
	}

	//returns true if contains element 
	//Natalia
	@Override
	public boolean contains(T element){
		for(int i = 0; i < parent.size(); i++){
			for(int j = 0; i < parent.get(i).size(); j++){
				return parent.get(i).get(j) == element
			}		
		}
	}

	//gets the element at a specified parent and child index
	//Savannah
	@Override
	public T get(int parentIndex, int childIndex){
		return parent[parentIndex][childIndex]; 
	}

	public static void main(String[] args){

	}

}
