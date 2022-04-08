package patternmethod;

public class PatternMethod {

	public void pyramidpattern(int n) {
		
		for(int i = n-1 ; i >= 0 ; i-- ) {
			for(int j = 0 ; j < n ; j++) {
				if(j >= i) {
					System.out.print("*"+" ");
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
					System.out.print("*"+" ");
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
				if(j >= i) {
					System.out.print("*"+" ");
				} 
				}
			}
			System.out.println();
		}
	}
