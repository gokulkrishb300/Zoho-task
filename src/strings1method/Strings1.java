package strings1method;

import java.util.Arrays;
import java.util.List;

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
	    	
	   
	    int length = S.length();
	    String reverse = "";
	    String storeRev[] = new String[length];
	    int count = 0 ;
        for(int i = 0 ; i < length ; i++) {
        int j = i*2;
        System.out.println(j);
        	if(S.charAt(i)=='.') {

        	  storeRev[count++] = reverse.substring(0);
        	  System.out.println(reverse);
        	}
        	reverse = S.charAt(i)+reverse;
        }
	    System.out.print(Arrays.toString(storeRev));
	
	    return reverse;
	
	    }
	    
	    public String reverseWithSpacesIntact(String S) {
	    	int length = S.length();
	    	String output ="";
	    	for(int i = 0 ; i < length ; i++) {
	    		output = S.charAt(i) + output;
	    	}
	    	return output;
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
	    	int length = s.length();
	    	int count = 0 ;
	    	for(int i=1;i<length-1;i++) {
	    		count++;
	    	}
	    	if(count>0) {
	    		return count;
	    	}
	    	else {
	    		return -1;
	    	}
}
	    
	    public List<String> find_permutation(String S){
	    	return null;
	    }
}
