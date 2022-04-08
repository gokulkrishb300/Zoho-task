package strings2method;

import java.util.Arrays;
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
	   
	    
	    public int romanToInt(String s) {
	    int length = s.length();
	    int output = 0 ;
	    Map<Character, Integer> map = new HashMap<>();
	    map.put('I',1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	int i = 0 ; 
    	
    	while(i < length) {
    		if(i == length -1 || map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
    			output += map.get(s.charAt(i));
    		}
    		else {
    			output += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
    			i++;
    		}
    		i++;
    	}
    	return output ;
	    }
	    
	    


   public String countAndSay(int n) {
	           
	        if(n == 1)
	        {
	            return "1";
	        }
	        
	        StringBuilder ans = new StringBuilder();
	        
	        String str = countAndSay(n - 1);
	        
	        int count = 0;
	        
	        for(int i = 0; i < str.length();i++)
	        {
	            count++;
	            if(i == str.length() - 1 ||str.charAt(i) != str.charAt(i+1))
	            {
	                ans.append(count).append(str.charAt(i));
	                count = 0;
	            }    
	        }
	    return ans.toString();     
	    }
	    
   public String modify (String str)
   {
    int i = 0;
    int j = str.length()-1;
    char[] s = str.toCharArray(); 
    while(i<j) {
    	if(!(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i]=='u')) {
    		i++;
    		continue;
    	}
    	if(!(s[j] == 'a' || s[j] == 'e' || s[j]== 'i' || s[j] == 'o' || s[j]=='u')) {
    		j--;
    		continue;
    	}
    	
    	char letter = s[i];
    	s[i] = s[j];
    	s[j] = letter;
    	i++;
    	j--;
    }
    return String.valueOf(s);
}
	   

   public String encryptString(String S){
 	        // code here
 	       
 	        String output = "";
 	        int length = S.length();
 	        for(int i = 0 ; i < length; i++){
 	              int count = 1;
 	            while(i<length-1 && S.charAt(i) == S.charAt(i+1)){
 	                count++;
 	                i++;
 	            }
 	         
 	         output = String.valueOf(Integer.toHexString(count))+ S.charAt(i)+output;
 	        }
 	      
 	   return output;
 	    }
   
   public boolean areIsomorphic(String str1,String str2)
  {
     if(str1.length()!= str2.length()) {
    	 return false;
     }
     
     int[] freq1 = new int[256];
     int[] freq2 = new int[256];
     
     int str = str1.length();
     
     for(int i = 0 ; i < str ; i++) {
    	 freq1[str1.charAt(i)]++;
    	 freq2[str2.charAt(i)]++;
     }
     
     for(int i = 0 ; i < str ; i++) {
    	 if(freq1[str1.charAt(i)]!=freq2[str2.charAt(i)]) {
    		 return false;
    	 }
     }
     return true;
      
}
   public int minimumNumberOfDeletions(String S) {
       //your code here
   StringBuilder build = new StringBuilder(S);
   String r = build.reverse().toString();
   
   char[] x = S.toCharArray();
   char[] y = r.toCharArray();
   int m = x.length;
   int n = m;
   
   
   int [][] arr = new int[m+1][n+1];
   

   
   
   for(int i = 1 ; i < m+1 ; i++){
       for(int j = 1 ; j < n+1 ; j++){
           if(x[i-1] == y[j-1]){
               arr[i][j] = 1 + arr[i-1][j-1];
           } else{
               arr[i][j] = Math.max(arr[i][j-1],arr[i-1][j]);
           }
       }
   }
   return m - arr[m][n];
   }

   public static boolean isRotated(String str1, String str2)
   {
       // Your code here
       
       if(str1.length()!=str2.length()){
           return false;
       }
       
       int start = str1.length() - 2;
       int started = start -1;
       int end = str1.length() - 1;
       
    
      
       if((str1.substring(0,1)).equals(str2.substring(start,end)) &&
       (str1.substring(2,end)).equals(str2.substring(0,started))){
           return true;
       } else if((str1.substring(start,end)).equals(str2.substring(0,1)) && 
       (str1.substring(0,started).equals(str2.substring(2,end)))){
           return true;
       }
       
      return false;
   }
   public boolean isValidIP(String s){
	    String num[] = s.split("\\.");
	        
	        if(num.length!=4) return false;
	        if(s.charAt(s.length()-1)=='.') return false;
	        
	        for(int i=0; i<num.length; i++)
	        {
	            if(num[i].length()==0 || num[i].length()>3) return false;
	            try
	            {
	                int x = Integer.parseInt(num[i]);
	                if(x>255 || x<0) return false;
	                if(x==0 && num[i].length()>1) return false;
	                if(x>0 && num[i].charAt(0)=='0') return false;
	            }
	            catch(Exception e)
	            {
	                
	                return false;
	        
	}
	}
	        
	        
	        return true;
	    }
   static int countMin(String s1)
   {
       // code here
       
       StringBuilder sb=new StringBuilder();

       sb.append(s1);

       String s2=sb.reverse().toString();

       int n=s2.length();

       int t[][]=new int[n+1][n+1];
       
       for(int i=0;i<n+1;i++){

           for(int j=0;j<n+1;j++){

               if(i==0 || j==0){

                   t[i][j]=0;

               }

           }

       }

       for(int i=1;i<n+1;i++){

           for(int j=1;j<n+1;j++){

               if(s1.charAt(i-1)==s2.charAt(j-1)){

                   t[i][j]=1+t[i-1][j-1];
               }
               else{
                   t[i][j]=Integer.max(t[i-1][j],t[i][j-1]);
               }
           }
       }
       return n-t[n][n];
   }
   
}
