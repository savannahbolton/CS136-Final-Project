package array;

import java.util.*; 
import java.io.*; 

/**
 * Interface that specifies the methods used by our parent array, as well as child arrays that
 * are pointed to by each element in the parent array. 
 */ 
public interface List<T>{
	public abstract void add(T element); 

	public abstract void set(int parentIndex, int childIndex, T element); 

	public abstract int size(); 

	public abstract boolean isEmpty(); 

	public abstract boolean contains(T element): 

	public abstract T get(int parentIndex, int childIndex); 
}