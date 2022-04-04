package strings2method;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class String2Method {
	   public boolean checkIfPangram(String sentence) {
	        Set<Character> set = new HashSet<>();
	   
	        
	        for(int i = 0 ; i < sentence.length() ; i++){
	                set.add(sentence.charAt(i));
	        }
	    
	        if(set.size()==26){
	            return true;
	        }
	     return false;
	    }
	   
	 
	    static String removeChars(String string1, String string2){
	        // code here
	       
	   
	        for(int i = 0 ; i < string2.length(); i++){
	          string1 = string1.replace(String.valueOf(string2.charAt(i)),"");
	        }
	        
	     return string1;
	}
	    public boolean isValid(String s) {
	        
	        
	        Stack<Character> stack = new Stack<>();
	        for(int i = 0 ; i < s.length() ; i++){
	          
	            char symbol = s.charAt(i);
	            switch(symbol){
	                case '(' :
	                    stack.push(')');
	                break;
	                
	                case '{' :
	                     stack.push('}');
	                break;
	                
	                case '[' :
	                     stack.push(']');
	                break;
	                
	                default:
	                     if(stack.isEmpty() || stack.pop() != symbol){
	                         return false;
	                     }
	                     }
	            }
	            return stack.isEmpty();
	        }
	    String firstAlphabet(String S) {
	        // code here
	        
	        String output = String.valueOf(S.charAt(0));
	        for(int i = 0 ; i < S.length() ; i++) {
	            if(S.charAt(i) == ' '){
	                output += S.charAt(i+1);
	            }
	        }
	        return output;
	    }
	    
	    static String encryptString(String S){
	        // code here
	        

	        Map<Character, Integer> map = new HashMap<>();
	        int count = 0 ;
	        String output = "";
	        for(int i = 0 ; i < S.length() ; i++){
	            
	            if(map.containsKey(S.charAt(i))){
	                map.put(S.charAt(i),++count);
	            }
	          
	                else{
	                    count = 0;
	                map.put(S.charAt(i),++count);
	            }
	            
	        }
	       map.forEach((key,value) ->  System.out.println((key)+""+value));
	     
	      return S;
	    }
	    
	    void store(Character key) {
	    	
	    }
	    
}
