package Minted;
import java.io.*;
import java.util.*;

public class ZeroOneParents {	
	/*

	For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
	1   2   4
	 \ /   / \
	  3   5   8
	   \ / \   \
	    6   7   9

	Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

	Sample output (pseudocode):
	[
	  [1, 2, 4],   // Individuals with zero parents
	  [5, 7, 8, 9] // Individuals with exactly one parent
	]

	*/

	public static void main(String[] args) {
	    int[][] parentChildPairs = new int[][] {
	        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
	        {4, 5}, {4, 8}, {8, 9}
	    };
	    ArrayList<Integer> zero = getZeroParent(parentChildPairs);
	    ArrayList<Integer> one = getOneParent(parentChildPairs);
	    
	    for (int i = 0 ; i < zero.size(); i++) {
	      System.out.print("ZERO: " + zero.get(i) + ", ");
	    }
	    
	    for (int i = 0 ; i < one.size(); i++) {
	      System.out.print("ONE: " + one.get(i) + ", ");
	    }
	 }
	  
	  
	  public static ArrayList<Integer> getOneParent (int[][] m) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    
	    for (int i = 0; i < m.length; i++) {
	      if (map.containsKey(m[i][1])) {
	        map.put(m[i][1], map.get(m[i][1]) + 1);
	      }
	      if (!map.containsKey(m[i][1])) {
	        map.put(m[i][1], 1);
	      }  
	    }
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
	      
	      if (entry.getValue() == 1) {
	        arr.add(entry.getKey());
	      }
	    }   
	    return arr;
	  }
	  
	  public static ArrayList<Integer> getZeroParent (int[][] m) {
	    ArrayList<Integer> arr = new ArrayList<Integer>();

	    int parent = 0;
	    int child = 0;
	    for (int i = 0; i < m.length; i++) {
		  boolean hasParent = false;
	      parent = m[i][0];
	      
	      for (int k = 0; k < m.length; k++) {
	        child = m[k][1];
	        if (i != k) {
	          if(parent == child) {
	            hasParent = true;
	          } 
	        }
	      }
	      if (!hasParent && arr.indexOf(parent) == -1) {
	        arr.add(parent);
	      }
	    }
	    return arr;
	  }
}
