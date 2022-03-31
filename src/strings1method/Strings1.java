package strings1method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
	    	String result ="";
	    	int position = 0 ;
	    	int count = 0;
	    	char ch[] = new char[length];
	    	int flag = 1;
	    	
	    	for(int i = 0 ; i < length ; i++) {
	    		if(S.charAt(i) == ' ') {
	    			position = i;
	    			count++;
	    		}
	    		else {
	    		 result = S.charAt(i)+result;
	    		}	
	    	}
	    	
	    	
	    	int finalLength = result.length();
	    	String spaceLetter= "";
	    	
	    	for(int i = 0 ; i < finalLength ; i++) {
	    	if(i == position) {
	    		spaceLetter =  String.valueOf(result.charAt(i));
	    		ch[i] = ' ';
	    	}
	    	else {
	    		ch[i]= result.charAt(i);
	    	
	    	}
	    	}
	    	
	    	String newResult ="";
	    	for(int i = 0 ; i < finalLength; i++) {
	    		if(S.charAt(i)==' ') {
	    			
	    			flag = 0;
	    		}
	    		if(flag == 0) {
	    			newResult = spaceLetter;
	    			System.out.println(newResult);
	    			
	    			flag =1;
	    		}
	    		
	    	}
	    
	    
	    	System.out.println("new Result : "+newResult);
	    	
	    	
	    	return String.valueOf(ch)+" "+newResult;
}
	    
	    public String crossPattern(String S) {
	    	int length = S.length();
	    	String output ="";
	    	for(int i = 0 ; i < length ; i++) {
	    		output = S.charAt(i) + output+ " ";
	    	}
	    	return output;
	    }
	    
	    public boolean kPangram(String str, int k) {
	    	int length = str.length();
	    	return true;
	    }
	    
	    public int maxChars(String s) {
	 
	    	  HashMap<Character,Integer> map = new HashMap<>();
	          int result=-1;
	          int length = s.length();
	          for(int i=0;i<length;i++){
	              if(map.containsKey(s.charAt(i))){
	                  result=Math.max(result,i - map.get(s.charAt(i)) - 1);
	              }
	              else{
	              map.put(s.charAt(i),i);
	              }
	          }
	          return result;
}
	    
	    public List<String> find_permutation(String S){
	    	return null;
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
	    	return null;
	    }
	    
	    public static int wordBreak(String A, ArrayList<String> B) {
	    	return 0;
	    }
	    
	    public int CountWays(String str) {
	    	return 0;
	    }
	    
}
