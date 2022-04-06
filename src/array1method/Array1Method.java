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
        
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int count = 0;
            int[] output = new int[nums.length];
        
            for(int i = 0 ; i < nums.length ; i ++){
                for(int j = 0 ; j < nums.length ; j++){
                    if(nums[i]>nums[j]){
                        count++;
                    }
                }
                output[i] = count;
                count = 0;
            }
      
            return output;
        }
        
        long maxSubarraySum(int arr[], int n){
            
            // Your code here
        long output = arr[0];
        long max = arr[0];
        for(int i = 1 ; i < n ;i++){
            max = Math.max(max+arr[i],arr[i]);
            output = Math.max(output,max);
        }
        return output;
            }
        
        public static void convertToWave(int arr[], int n){
            
            // Your code here
            
            int temp;
            
            for(int i = 1 ; i < arr.length ; i+=2){           
               temp = arr[i];
               arr[i] = arr[i-1];
               arr[i-1] = temp;
           }
        }
       public static int majorityElement(int a[], int size)
        {
            // your code here
        
            if(size ==1 ){
                return a[0];
            }
            
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0 ; i < size ; i++){
              if(map.containsKey(a[i])){
                  int value = map.get(a[i])+1;
                  map.put(a[i], value);
              
              if(value == size/2){
                  return a[i];
              }
              }
              else{
                  map.put(a[i],0);
              }
        }
        return -1;
    }
        
        long minValueToBalance(long a[] ,int n)
        {

        int sumLeft = 0;
        int sumRight = 0;
        int balance = n/2;
        for(int i = 0 ; i < n ; i++){
            if(i < balance){
            sumLeft += a[i];
            
            } else if(i >= balance){
                sumRight += a[i];
            }
        }
        
        long output = sumLeft - sumRight;
        
        if(output<0){
            return -(output);
        }
        
        return output;
        }
        
        public int[] shuffle(int[] nums, int n) {
        	   
            
            
            int[] output = new int[nums.length];
            
            for(int i = 0 ; i < n ; i++){
                output[i*2] = nums[i];
                output[i*2 +1] = nums[i+n];
            }


           return output;
        }
}
