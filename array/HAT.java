package array;

import java.util.*
import java.io.*

public class HAT<T> implements List<T> {

	private static final double GROWTH_FACTOR = 2.0;

	//Instance variables
	private int size;
	private Object[][] parent;

	public HAT(int capacity){
		parent = new Object[capacity][capacity]; 
		size = 0; 
	}

	//Savannah
	//add an element to both parent and child arrays. If reaches capacity, double the size of the array.
	@Override
	public void add(T element){
		for (int i = 0; i < parent.size(); i++){
			for (int j = 0; j < parent.get(j).size(); j++){
				if (parent.get(j) == null){

				}
			}
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
			for(int j = 0; i < parent[i].size(); j++){
				return parent[][] == element;
			}		
		}
	}

	//gets the element at a specified index
	//Savannah
	@Override
	public T get(int parentIndex, int childIndex){

	}

	public static void main(String[] args){

	}

}
