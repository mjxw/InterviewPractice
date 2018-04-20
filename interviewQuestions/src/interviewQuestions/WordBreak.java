package interviewQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("sand");
		wordDict.add("dog");
		String s = "catsanddog";
		
		System.out.println(s + ": " + wordBreak(s, wordDict));
	}
	
	
    public static boolean wordBreak(String s, List<String> wordDict) {
       
    		Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        
        // starting point for BFS
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                
            		for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
    
}
