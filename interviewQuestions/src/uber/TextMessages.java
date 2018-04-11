package uber;


import java.util.ArrayList;


/**
 * Implement Paginate

  

Write a function 'paginate' which splits a string into an array of 

strings of a specified character length (page size). At the beginning of each page, insert a prefix string indicating the current page and the total # of pages in the message - "(2/11)" for example. 
Please note: the length of the prefix counts towards the total character limit per page.
 Words should not be split across pages
 *
 */

public class TextMessages {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        int limit = 20;
        String s = "I'm at a company called Uber and I am interviewing. It is very fun, and challenging, and cool and swag";
        ArrayList arr = new ArrayList();
        paginate(s, limit, arr);
        System.out.println("array size: " + arr.size());
        for (int i = 0; i < arr.size();i++) {
            System.out.println(arr.get(i));
        }
    }
    
    public static void paginate(String s, int limit, ArrayList arr) {
        int length = s.length();
        int prefixLength = length / limit; 
        int padding = prefixLength + (prefixLength / 2); 
        int offset = padding + prefixLength; 
        
        int count = 0;
        
        int curr = 0;
        int pages = 1;
        
        
        System.out.println("offset: " + offset);
        System.out.println("string size: " + s.length());

        
        
        for (int i = 0; i < s.length(); i++ ) {
            count++;
            StringBuilder substr = new StringBuilder();
            String shortened = "";
            String remaining = "";
            if (count == limit - offset) {
                int index = i;
                
                if (s.charAt(index) == ' ') {
                    shortened = s.substring(0, index);
                } else {
                    while(s.charAt(index) != ' ') {
                        index--;
                    }    
                    shortened = s.substring(0, index);
                }
                
                
                if (pages != 1) {
                    pages++;
                    curr++;
                } else if (pages == 1) {
                    curr++;
                }
                
                String prefix = curr + "/" + pages + " ";
                substr.append(shortened);
                substr.insert(0, prefix);
                
                remaining = s.substring(index, s.length());
                
            }
            arr.add(substr); 
            
        }
        
        
        
    }
}
