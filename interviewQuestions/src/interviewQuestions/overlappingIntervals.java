package interviewQuestions;

public class overlappingIntervals {
/*

Given 2 sets of intervals.

Interval is defined with left and right border and discrete points, like [2, 3], [0, 0], etc.

Set of intervals is non intersected set of sorted intervals, for example: [0, 0], [2, 2], [5, 10] is a valid set of intervals, but [0, 0], [1, 2] is not valid, because you can write it as [0, 2]. [0, 2], [1, 5] is not valid as well, since these two intervals intersect.

You need to find the AND or OR operation of these two sets. For example:

1st set: [0, 2], [5, 10], [16, 20]
2nd set:   [1, 5], [10, 18], [20, 23]

AND Result: [1, 2], [5, 5], [10, 10], [16, 18], [20, 20]
OR Result: [0, 23]

0 1 2   5 6 7 8 9 10                16 17 18 19 20 
  1 2 3 4 5       10 11 12 13 14 15 16 17 18    20 21 22 23
  
 


THIS SOLUTION SUCKS AND DOES NOT WORK...YET. Super Brute force 	
  
*/

	
  public static void main(String[] args) {
      int[][] set1 = new int[][]{
          {0,2},   //set1[0][0], set1[0][1]
          {5,10},  //set1[1][0], set1[1][1]
          {16,20}  //set1[2][0], set1[2][1]
      };
      
      int[][] set2 = new int[][]{
          {1,5},
          {10,18},
          {20,23}
          
      };
      
      printResults(set1, set2);
  }
  
  public static void printResults(int[][]set1, int[][]set2) {

	  // {3, 2} 
	  
	  // {1, 5} 

	  // AND: {3, 2} 
    


    
    for (int i = 0; i < 3; i++ ) {
      // CASE: set1[i][0] > set2[i][0]
      // i.e set2 has the starting integer in the intervals
      if (set1[i][0] > set2[i][0]){
        
        // Iterate through all the integers between set2[i][0] and set2[i][1]
        for(int j = set2[i][0]; j < set2[i][1]; j++) {
          
          // When j == set2[i][0], then we have our starting point
          if(j == set1[i][0]) {
            System.out.print("[" + j + ", ");
            break;
          } 
        }
        
        // CASE: set1 ends after set2 
        // i.e set2 contains the ending point
        if (set1[i][1] > set2[i][1]) {
          
          // Iterate through all the integers between set1[i][0] and set1[i][1]
          for (int j = set1[i][0]; j < set1[i][1]; j++) { 
            
            // Iterate through all the integers between set2[i][0] and set2[i][1]
            for (int k = set2[i][0]; k < set2[i][1]; k++) {
              
              // When j == set2[i][1], then we have our ending point
              if (j == k) {
                System.out.print( j + "] ");
                System.out.println();
                break;
              }
            }
          }
        }  else { // CASE: set2 ends after set1 i.e set1 contains the ending point
              
          // Iterate through all the integers between set2[i][0] and set2[i][[1]
          for (int j = set2[i][0]; j < set2[i][1]; j++) 

            // Iterate through all the integers between set1[i][0] and set1[i][[1]
            for (int k = set1[i][0]; k < set1[i][1]; k++) {
              
              // When j == set1[i][1], then we have our ending point
              if (j == k) {
                System.out.print( j + "] ");
                System.out.println();
                break;
              }
            }
          }
        
        } else if (set1[i][0] < set2[i][0]) { // CASE: set1[i][0] < set2[i][0] i.e set1 has the starting integer in the intervals
          for (int j = set1[i][0]; j < set2[i][1]; j++) {
            if (j == set2[i][0]) {
              System.out.print("[" + j +", ");
            }
          }   
          // CASE: set1 ends after set2 
          // i.e set2 contains the ending point
          if (set1[i][1] > set2[i][1]) {
            
            // Iterate through all the integers between set1[i][0] and set1[i][1]
            for (int j = set1[i][0]; j < set1[i][1]; j++) { 
                
                // When j == set2[i][1], then we have our ending point
                if (j == set2[i][1]) {
                  System.out.print( j + "] ");
                  System.out.println();
                  break;
                }
             
            }
                       
          }  else { // CASE: set2 ends after set1 i.e set1 contains the ending point
                
            // Iterate through all the integers between set2[i][0] and set2[i][[1]
            for (int j = set2[i][0]; j < set2[i][1]; j++) 
                
		        // When j == set1[i][1], then we have our ending point
		        if (j == set1[i][1]) {
		          System.out.print( j + "] ");
		          System.out.println();
		          break;
		        }
            }
        } else if (set1[i + 1][0] < set2[i][0]) {
        	
        }
    }      
  }
}
