
public class Dummy { 
	public  static int sumOfDigits(int a) {
		int sum=0;
		int digit=0;
		while(a>0) {
		digit=a%10;
		sum+=digit;
		a/=10;
		}
	
		return sum;
	}
	
	
public static void main(String[] args) {
	int a=3,b=5,count=0;
	while(a<14) {
		if(a==b) {
			System.out.println("1 trap "+a+" "+b);
			b+=2;
			
		}
		else if((a%b)==0 || (b%a)==0) {
			  
			  System.out.println("2 trap "+a+" "+b);
		       b+=2;  
		}
		 
		else if((sumOfDigits(a))%b==0 || (b%(sumOfDigits(a))==0)) {
			
			System.out.println("3 trap "+a+" "+b);
				b+=2;
				
	    }
		
		else {
			b--;
			if(b<3) {
				b=3;
			}
		
		}
		a++;
		count++;
		}
	System.out.println(count);
}
				
}
