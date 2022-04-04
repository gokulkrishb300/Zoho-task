package array1method;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array1Method {

	
	public int findMin(int arr[], int n ) {
	Arrays.sort(arr);
	return arr[0];
	}
	
    static int getKey(Map<Integer,Integer> map,int value){
        for(Integer key : map.keySet()){
            if(value == map.get(key)){
                return key;
            }
        }
        return 0;
    }
        // Complete the function

        public int firstNonRepeating(int arr[], int n) 
        { 
            // Complete the function
            Map<Integer,Integer> map = new HashMap<>();
            int count = 0;
            for(int i = 0 ; i < n ; i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i],++count);
                }
                else{
                    count = 0;
                    map.put(arr[i],++count);
                }
            }
            
           
              for(int i=0;i<n;i++){
                  
              if(map.get(arr[i])==1)
              
                return arr[i];
          }
          return 0;
        }
}
