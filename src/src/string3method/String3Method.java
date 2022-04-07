package string3method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class String3Method {
	   int lps(String s) {
	        // code here
	       int[] arr = new int[s.length()];
	       int i = 1;
	       int j = 0;
	       
	       while(i < s.length()){
	           if(s.charAt(i) ==s.charAt(j)){
	               arr[i++] = (j++)+1;
	           } else{
	               if(j==0){
	                   arr[i++] = 0;
	               }else{
	                   j = arr[j-1];
	               }
	           }
	       }
	       return j;
	    }
	   boolean areKAnagrams(String s1, String s2, int k) {
	        // code here
	        
	        if(s1.length()!=s2.length()){
	            return false;
	        }
	        
	        int a[] = new int[26];
	        int b[] = new int[26];
	        
	      
	        
	        int count = 0;
	        
	        for(int i = 0 ; i < s1.length() ; i++){
	            a[s1.charAt(i) - 'a']++;
	            b[s2.charAt(i) - 'a']++;
	        }
	        
	        for(int i = 0 ; i < 26 ; i++){
	            if(a[i] > b[i]){
	                count += a[i] - b[i];
	            }
	        }
	        
	        if(count <= k){
	            return true;
	        }
	        else{
	            return false;
	        }
	        }
	   
	   int longestUniqueSubsttr(String S){
		      
		      int[] arr = new int[26];
		      
		      arr[S.charAt(0)-'a']++;
		      
		      int i = 0 ;
		      int j = 1;
		      int output = 1 ;
		      
		      while(j < S.length()){
		          int x = S.charAt(j) - 'a';
		          if(arr[x] > 0){
		              arr[S.charAt(i) - 'a']--;
		              i++;
		          } else{
		              arr[x]++;
		              j++;
		          }
		          output = Math.max(output,j-i);
		      }
		      return output;
		    }
	   
	   public boolean rotate(String str1, String str2) {
		   
		   List<Character> list = new ArrayList<>();
		   
		   if(str1.length() != str2.length()) {
			   return false;
		   }
		   
		   for(int i = 0 ; i < str1.length() ; i++) {
			   list.add(str1.charAt(i));
		   }
		   int length = str1.length();
		   for(int i = 0 ; i < str1.length() ; i++) {
			if(i == 0) {
				list.add(i,str1.charAt(length-1));
				list.remove(length);
			}
			if(i == 1) {
				list.add(i,str1.charAt(length-2));
				list.remove(length);
			}
		   }
		
		   StringBuilder build = new StringBuilder();
		   for(Character ch : list) {
			   build.append(ch);
		   }
		   String output = build.toString();
		   
		   if(output.equals(str2)) {
			   return false;
		   }
		   return true;
	   }
	   
	   public String fragment(int n , String[] input) {
		   
		
		   
		   return "";
	   }
	   
	   public String unMatchPair(String str1,String str2) {
		   
		   
		   int i = 0;
		   String output = "";
		   while(i < str1.length()) {
			   if(str1.charAt(i)==str2.charAt(i)) {
				   i++;
				   continue;
			   } else {
				  output += str1.charAt(i)+""+str2.charAt(i)+",";
			   }
			   i++;
		   }
		   return output;
	   }
	   
	  public boolean checkPalindrome(String input) {
		  int i = 0 ;
		  int j = input.length() -1;
		  
		  while(i<j) {
			  if(input.charAt(i++)!=input.charAt(j--)) {
				  return false;
			  }
		  }
		  return true;
	  }
	  
	  public String removePalindrome(String input) {
		  
		  String output = "";
		  String separate = "";
		  for(int i = 0 ; i < input.length() ; i++) {
			  
			  if(input.charAt(i)!=' ') {
				  separate += input.charAt(i);
			  } else {
				  if(!(checkPalindrome(separate))) {
					  output += separate +" ";
				  }
				  separate ="" ;
			  }
		  }
		  
		  return output;
	  }
	   
	   
	   public String balancedWord(String input) {
		   return "STEAD";
	   }
	   
}