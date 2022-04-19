package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Node;

public class MatrixMethod {
	
   public int sumOfMatrix(int N, int M, int[][] Grid) {
        // code here
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                sum += Grid[i][j];
            }
        }
        System.out.println(Grid[0].length);
        return sum;
    }
   
   public void rotate(int matrix[][]) 
   {
       // Code Here
      int n = matrix.length;
      
      int k = 0;
      
      int[][] temp = new int[n][n];
      
      for(int i = n-1 ; i >= 0 ; i--,k++){
          for(int j = 0 ; j < n ; j++){
              temp[k][j] = matrix[j][i];
          }
      }
      
      for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < n ;j++){
              matrix[i][j] = temp[i][j];
          }
      }
      for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < n ;j++){
             System.out.print(matrix[i][j]+" ");
          }
          System.out.println();
      }
   }
   
   public void transpose(int matrix[][], int n)
   {
       // code here
       int temp[][] = new int[n][n];
       
       int k = 0;
       
       for(int i = 0 ; i < n ; i++,k++){
           for(int j = 0 ; j < n ; j++){
               temp[k][j] = matrix[j][i];
           }
       }
       for(int i = 0 ; i < n ; i++){
           for(int j = 0 ; j < n ; j++){
               matrix[i][j] = temp[i][j];
           }
       }
   }
   
   public  ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
   {
       //add code here.
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();
    Set<ArrayList<Integer>> set = new HashSet<>();
    
    for(int i = 0 ; i < r ; i++){
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int j = 0 ; j < c ; j++){
            list.add(a[i][j]);
        }
        if(!set.contains(list)){
            set.add(list);
            output.add(list);
        }
    }
    return output;
   }
   
   public void maximumOne(int a[][], int r , int c) {
	   
	   int count = 0;
	   int target = 0;
	   int target2 = 0;
	   int max = Integer.MIN_VALUE;
	   
	   for(int i = 0 ; i < r ; i++) {
		   for(int j = 0 ; j < c ; j++) {
			   if(a[i][j] == 1) {
				   count++;
			   }
		   }
		   if(count>max) {
		   max = Math.max(max, count);
		   target = i;
		   }
		   if(count == max) {
			   target2 = i;
		   }
		   count = 0;
	   }
	
	  
	   for(int i = 0 ; i < r ; i++) {
		   for(int j = 0 ; j < c ; j++) {
			   if(target == i || ((target2 ==i) && target2 > 0))  {
				   if(a[i][j]==1) {
					   a[i][j] = 0;
				   }
			   }
		   }
	   }
	   
	   for(int i = 0 ; i < r ; i++) {
		   for(int j = 0 ; j < c ; j++) {
			   System.out.print(a[i][j]+" ");
		   }
		   System.out.println();
	   }
   }
   
   public void setZeroes(int[][] matrix) {
       
       int m = matrix.length;
       int n = matrix[0].length;
       
       int[] row = new int[m];
       int[] column = new int[n];
       
       for(int i = 0 ; i < m ; i++ ){
           for(int j = 0 ; j < n ; j++){
           if(matrix[i][j]==0){
               row[i] = 1;
               column[j] = 1;
           }
           }
       }
       
       for(int i = 0 ; i < m ; i++){
           for(int j = 0 ; j < n ; j++){
               if(row[i]==1||column[j]==1){
                matrix[i][j] = 0;
               }
           }
       }
   }
   
   public void matrixSorting(int[][] matrix) {
	   
	   int[] output = new int[matrix.length];
	   int n = matrix.length;
	   int count = 0 ;
	   for(int i = 0 ; i < n ; i++) {
		   for(int j = 0 ; j < n ;j++) {
			   if(i==j) {
				   output[count++] = matrix[i][j];
			   }
		   }
	   }
       count = 0;
       
       quickSort(output,0,output.length-1);
       for(int i = 0 ; i < n ; i++) {
    	   for(int j = 0 ; j < n ;j++) {
    		   if(i==j) {
    			   matrix[i][j] = output[count++];
    		   }
    	   }
       }
	   
	   System.out.println(Arrays.deepToString(matrix));
   }
   
   public static void quickSort(int[] arr , int low ,int high) {
	   if(low < high) {
		   int pi = partition(arr,low,high);
		   quickSort(arr,low,pi-1);
		   quickSort(arr,pi+1,high);
	   }
   }
   
   public static void swap(int[] arr, int i , int j) {
	   int temp = arr[i];
	   arr[i] = arr[j];
	   arr[j] = temp;
   }
   
   public static int partition(int[] arr , int low , int high) {
	   
	   int i = (low-1);
	   int pivot = arr[high];

	   for(int j = low ; j <= high-1 ; j++) {
		   if(arr[j]<=pivot) {
			   i++;
			   swap(arr,i,j);
		   }
	   }
	   Node node = null;
	   swap(arr,i+1,high);
	   return (i+1);
   }
   
}
