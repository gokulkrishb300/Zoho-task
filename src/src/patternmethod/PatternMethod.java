package patternmethod;

import java.util.ArrayList;
import java.util.List;

public class PatternMethod {

	public void pyramidpattern(int n) {
		
		for(int i = n-1 ; i >= 0 ; i-- ) {
			for(int j = 0 ; j < n ; j++) {
				if(j >= i) {
					System.out.print("* "+i+" "+j);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void rightTriangle(int n) {
		for(int i = 0 ; i < n ;i ++) {
			for(int j = 0 ; j < n ; j++) {
				if(i >= j) {
					System.out.print("* ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		
		/*
		 * public void rightTriangle(int n) { for(int i = n-1 ; i >= 0 ; i-- ) { for(int
		 * j = 0 ; j < n ; j++) { if(j >= i) { System.out.print("*"+" "); } } }
		 * System.out.println(); }
		 */
	}
	
	public void leftTriangle(int n) {
		for(int i = n-1 ; i >= 0 ; i-- ) {
			for(int j = 0 ; j < n ; j++) {
				if(j>=i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
				}
			System.out.println();
			}
			
		}
	
	public void diamond(int n) {
		  n = n*2 -1;
		  for(int i = n-1 ; i >= 0 ;i-=2) {
			  for(int j = 0 ; j < n ; j++) {
				  if(j>=i) {
					  
		  System.out.print("* "); 
		  } else { System.out.print(" ");
		  } 
				  }
		  System.out.println(); 
		  }
		 
		for(int i = 0 ; i < n ; i+=2) {
			if(i==0) {continue;}
			for(int j = 0 ; j < n ; j++) {
				
				if(i<=j) {
					System.out.print("* ");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void rightPascal(int n) {
		
		
		  for(int i = 0 ;i < n ; i++) {
			  for(int j = 0 ; j < n ;j++) {
				  if(i>=j) {	  
		  System.out.print("* "); 
		  } 
		else { 
			System.out.print(" "); 
			} 
				  }
		  System.out.println();
		  }
		 
		for(int i = n-1 ; i >=0 ; i--) {
			if(i == n-1) { continue; }
			for(int j = 0 ; j < n ; j++) {
				if(i>=j) {
					System.out.print("* ");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	
	public void sandGlass(int n) {
		
		  for(int i = 0 ; i < n ; i++) {
			  for(int j = 0 ; j < n ; j++) {
				  if(i <= j) {
		  System.out.print("* "); 
		  }
	    else {
	    	System.out.print(" "); 
	    	} 
				  }
		  System.out.println(); }
		 
		
		for(int i = n-1 ; i >= 0 ; i--) {
			for(int j = 0 ; j < n ; j++) {
				if(i<=j) {
					System.out.print("* ");
				}else {
				    System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	

	
	
	public void triangle(int n) {
		int m = n-1;
		n = n*2 -1;
	
		for(int i = n ; i > 0 ;i-=2) {
			for(int j = 0 ; j < n; j++) {
				
				
				
				 if(i==n && j==m) {
					   System.out.print("*");
				   }
				   else {
					   System.out.print(" ");
				   }
			
			}
			System.out.println();
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.print("*");
		}
	
	
	}
	
	public void testing(int n) {
	int m = n-1;
		
		n= n*2-1;
		for(int i = n ; i > 0 ;i-=2) {
			if(i==1) {continue;}
			for(int j = 0 ; j < n; j++) {
				   if(j==m && i == n) {
					   System.out.print("*");
				   }else {
					   System.out.print(" ");
				   }
			}
			System.out.println();
		}
		
		for(int i = n ; i > 0 ; i-=2) {
			if(i==1) {continue;}
		for(int j = 0 ; j < n ; j++) {
				
			}
		}
		
		
		
		for(int i = 0 ; i < n ; i++) {
			System.out.print("*");
		}
	}
	


	
}

//       (0,3)   4   (5,8)
//       (0,2)   3   (6,8)
//       (0,1)   2   (7,8)
//       (0)     1   (8)
         

