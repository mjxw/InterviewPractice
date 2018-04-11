package interviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


class SortByString implements Comparator<String>{

    public int compare(String str1, String str2){
      
			return Integer.valueOf(str1) - Integer.valueOf(str2);
    }
}

public class SortNumericStrings {
	

	
	public static void main(String[] args) {
		String[] arr = new String[] {"2", "1", "4", "7", "2", "30" };
//		Arrays.sort(arr, new SortByString());
		Arrays.sort(arr, Collections.reverseOrder(new SortByString()));

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
 }
