package strings1method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Strings1 {

	    public void middlePattern(String input) {
		
		int length = input.length();
				
		int secondPhase = length/2;
		
		String secondInput = input.substring(secondPhase);
		
		int firstPhase = secondInput.length();
				
		String result = "";
		
	
		for(int i = 0 ; i <firstPhase; i++ ) {
			System.out.print(String.valueOf(result += secondInput.charAt(i)).toUpperCase()+'$'+" ");
		}
		System.out.println();
		for(int i = 0 ; i < secondPhase ; i++) {
			System.out.print(String.valueOf(result += input.charAt(i)).toUpperCase()+'$'+" ");
		}
		
	}
	    
	    public String remainingString(String S, char ch, int count) {
	    	
	    	int length = S.length();
	    	int counter = 0 ;
	    	if(count == 0) {
	    	 return String.valueOf(S);
	    	} 
	    	else {
	    	for(int i = 0 ; i < length ; i++) {
	    		
	    		if(S.charAt(i)== ch) {
	    			if(++counter == count) {
	    				if((S.substring(i+1)).length()>=1) {
	    					return S.substring(i+1);
	    				}
	    				else if((S.substring(i+1)).length()==0){
	    					return "Empty string";
	    				}
	    			}
	    		}
	    	}
	    	
	    } 
	    	  return "Empty string";
	    }
	    
	    
	    
	    public String reverseWords(String S) {
	    	
	    	Stack<Character> stack = new Stack<Character>();
	    	
	    	int length = S.length();
	    	
	    	String result ="";
	    	
	    	for(int i = 0 ; i < length ; i++) {
	    		
	    		if(S.charAt(i)!='.') {
	    			stack.push(S.charAt(i));
	    		}
	    		else {
	    			while(!stack.isEmpty()) {
	    				result += stack.pop();
	    			}
	    			result+= ".";
	    		}
	    	}
	    	while(!stack.isEmpty()) {
	    		result += stack.pop();
	    	}
	    	return result;
	    }
	    
	    public String reverseWithSpacesIntact(String S) {
	    
	    	int length = S.length();
	    	String output = "";
	    	List<Character> input = new ArrayList<Character>();
	    	
	    	for(int i = 0 ; i < length ; i++) {
	    		if(!(S.charAt(i)==' ')) {
	    			input.add(S.charAt(i));
	    		}
	    	}
	    	
	    	Collections.reverse(input);
	    	
	    	for(int i = 0 ; i < length ; i++) {
	    		if(S.charAt(i)==' ') {
	    			input.add(i, ' ');
	    		}
	    	}
	    	
	    	for(Character letter : input) {
	    		output += letter;
	    	}
	    	
	    	return output;
	    
}
	    
	    public String crossPattern(String S) {
	    	
           int length = S.length();
	    	
	    	StringBuilder result =new StringBuilder();
	    	
	    	StringBuilder build = new StringBuilder(S);
	    	
	    	String reverse = build.reverse().toString();
		
			char[] stack = new char[S.length()*S.length()];
			
			int count = 0;
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (i == j) {
						stack[count++] = S.charAt(i);
					}
					else if(i+j == length -1) {
						stack[count++] = reverse.charAt(i);
					}
					else {
						stack[count++] = ' ';
					}
				}
			}
			int stackLength = stack.length;
			
            for(int i = 0 ; i < stackLength; i++) {
            	
            	result.append(stack[i] );
            }
	    	return String.valueOf(result);
	    }
	    
	    boolean kPangram(String str, int k) 
	    {
	     int count = 0 ;
	     Set<Character> set = new HashSet<>();
	     
	     for(int i = 0 ; i < str.length(); i++){
	         if(str.charAt(i)!=' '){
	             set.add(str.charAt(i));
	             count++;
	         }
	     }
	     if(count<26){
	         return false;
	     }
	     if(k+set.size()>=26){
	         return true;
	     }
	     return false;
	    }
	    
	    public int maxChars(String s) {
	 
	    	  HashMap<Character,Integer> map = new HashMap<>();
	    	  
	          int result=-1;
	          
	          int length = s.length();
	          
	          for(int i=0;i<length;i++){
	        	  
	              if(map.containsKey(s.charAt(i))){
	            	  
	                  result=Math.max(result,  i - map.get(s.charAt(i)) - 1);
	                 
	              }
	              else{
	            	  
	              map.put(s.charAt(i),i);
	              
	              }
	          }
	          return result;
}
	    
	    public void findpermutation(String s, String ans, ArrayList<String> list){
	        if(s.length()== 0){
	            
	            list.add(ans);
	            
	            return;
	        }
	        
	        for(int i =  0; i < s.length(); i++){
	            
	            String ros = s.substring(0,i) + s.substring(i+1);
	            
	            findpermutation(ros,ans + s.charAt(i),list);
	        }
	    }
	    public List<String> find_permutation(String S) {
	        // Code here
	        ArrayList<String> list =  new ArrayList<>();
	        
	        findpermutation(S,"",list);
	        
	       
	        
	        return list;
	    }
	    	
	    
	    
//	    public int[][] searchWord(char[][] grid, String word){
//	    	
//	    	return 0;
//	    }
	    
	    public String restoreString(String S, int[] indices) {
	    	
	    	int length = indices.length;
	    	
	        char ch[] = new char[length];
	        
	    	for(int i = 0 ; i < length; i++) {
	    		ch [indices[i]]= S.charAt(i);
	    	}
	         return String.valueOf(ch);
	    }
	    
	 
	    
	    public List<List<String>> Anagrams(String[] string_list){
	    	
	    	List<List<String>>res=new ArrayList<>();
	    	
	        HashMap<String,List<String>>map=new HashMap<>();
	        
	        for(int i=0;i<string_list.length;i++)
	        {
	            String word=string_list[i];
	            
	            char[] value=word.toCharArray();
	            
	            Arrays.sort(value);
	            
	            String b= String.valueOf(value);
	            
	            if(map.containsKey(b))
	            {
	                map.get(b).add(word);
	            }
	            else
	            {
	                List<String>a=new ArrayList<>();
	                
	                a.add(string_list[i]);
	                
	                map.put(b,a);
	            }
	        }
	        for(Map.Entry<String,List<String>>e:map.entrySet())
	        {
	            res.add(e.getValue());
	        }
	        return res;
	    }
	    
	    public static int wordBreak(String A, ArrayList<String> B) {
	    	return 0;
	    }
	    
	    public int CountWays(String str) {
	    	
	    	int input = Integer.parseInt(str);
	    	
	        int length = str.length();
	    	
	    	String output = "";
	    	
	    	char[] letters = new char[length];
	    	
	    	if(input < 100) {
	 
	              return 1;
	    	}
	    	else if(input > 110) {
	    		for(int i = 0 ; i < length ; i++) {
	    			
	    			int number = str.charAt(i);
	    			
	    			letters[i] = (char) (number+48);
	    			
	    			output += Character.toUpperCase(letters[i]);
	    		}
	    	}
	    	
	    	
	    	System.out.println(output);
	    	
	    	return 0;
	    	
	    	
	    }
	    
	 // recuring function to find
	    // ways in how many ways a
	    // string can be decoded of length
	    // greater than 0 and starting with
	    // digit 1 and greater.
	    
	    static int countDecoding(char[] digits, int n)
	    {
	        // base cases
	        if (n == 0 || n == 1)
	            return 1;

	        // for base condition "01123" should return 0
	        if (digits[0] == '0')
	            return 0;

	        // Initialize count
	        int count = 0;

	        // If the last digit is not 0, then
	        // last digit must add to
	        // the number of words
	        if (digits[n - 1] > '0')
	            count = countDecoding(digits, n - 1);

	        // If the last two digits form a number
	        // smaller than or equal to 26,
	        // then consider last two digits and recur
	        if (digits[n - 2] == '1'
	            || (digits[n - 2] == '2'
	                && digits[n - 1] < '7'))
	            count += countDecoding(digits, n - 2);

	        return count;
	    }

	    // Given a digit sequence of length n,
	    // returns count of possible decodings by
	    // replacing 1 with A, 2 with B, ... 26 with Z
	    static int countWays(char[] digits, int n)
	    {
	        if (n == 0 || (n == 1 && digits[0] == '0'))
	            return 0;
	        return countDecoding(digits, n);
	    }

	 	// Rows and columns in the given grid
	 	static int R, C;

	 	// For searching in all 8 direction
	 	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	 	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	 	// This function searches in all
	 	// 8-direction from point
	 	// (row, col) in grid[][]
	 	static boolean search2D(char[][] grid, int row,
	 							int col, String word)
	 	{
	 		// If first character of word
	 		// doesn't match with
	 		// given starting point in grid.
	 		if (grid[row][col] != word.charAt(0))
	 			return false;

	 		int len = word.length();

	 		// Search word in all 8 directions
	 		// starting from (row, col)
	 		for (int dir = 0; dir < 8; dir++) {
	 			// Initialize starting point
	 			// for current direction
	 			int k, rd = row + x[dir], cd = col + y[dir];

	 			// First character is already checked,
	 			// match remaining characters
	 			for (k = 1; k < len; k++) {
	 				// If out of bound break
	 				if (rd >= R || rd < 0 || cd >= C || cd < 0)
	 					break;

	 				// If not matched, break
	 				if (grid[rd][cd] != word.charAt(k))
	 					break;

	 				// Moving in particular direction
	 				rd += x[dir];
	 				cd += y[dir];
	 			}

	 			// If all character matched,
	 			// then value of must
	 			// be equal to length of word
	 			if (k == len)
	 				return true;
	 		}
	 		return false;
	 	}

	 	// Searches given word in a given
	 	// matrix in all 8 directions
	 	static void patternSearch(
	 		char[][] grid,
	 		String word)
	 	{
	 		// Consider every point as starting
	 		// point and search given word
	 		for (int row = 0; row < R; row++) {
	 			for (int col = 0; col < C; col++) {
	 				if (grid[row][col]==word.charAt(0) &&
	 					search2D(grid, row, col, word))
	 						System.out.println(
	 							"pattern found at " + row + ", " + col);
	 			}
	 		}
	 	}

	 	// Driver code
		/*
		 * public static void main(String args[]) { R = 3; C = 13; char[][] grid = { {
		 * 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' }, { 'G',
		 * 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' }, { 'I', 'D',
		 * 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		 * patternSearch(grid, "GEEKS"); System.out.println(); patternSearch(grid,
		 * "EEE"); }
		 */
	 

	 // This code is contributed by rachana soma

	    
}
