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
import java.util.TreeSet;

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
	    
	    public boolean kPangram(String str, int k) {
	    	
	    	int count = 0;
	    	Set<Character> set = new HashSet<>();
	    	for(int i = 0 ; i < str.length();i++) {
	    		if(!(str.charAt(i)==' ')) {
	    			set.add(str.charAt(i));
	    			count++;
	    		}
	    	}
	    	
	    	if(count<26) {
	    		return false;
	    	}
	    	if(k+set.size() >=26) {
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
	        Collections.sort(list);
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
	            
	            String b=new String(value);
	            
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
	    	 int size[]=new int[A.length()];
	         for(int i=0;i <A.length();i++){
	             for(int j=0;j<=i;j++){
	                 if(B.contains(A.substring(j,i+1))){
	                     size[i]+=j>0?size[j-1]:1;
	                 }
	             }
	         }
	         return size[A.length()-1];
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
	    			
	    		}
	    	}
	    	
	    	
	    	System.out.println(output);
	    	
	    	return 0;
	    	
	    	
	    }
	    
}
/*
 * int number = str.charAt(i);
 * 
 * letters[i] = (char) (number+48);
 * 
 * output += Character.toUpperCase(letters[i]);
 */
