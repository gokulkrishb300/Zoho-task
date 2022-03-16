
public class Dummy { 
	public  static int sumOfDigits(int a) {
		int sum=0;
		int digit=0;
		while(a>0) {
		digit=a%10;
		sum+=digit;
		a/=10;
		}
	   if(sum>=10) {
		   int summ=0,digits=0;
			while(sum>0) {
			digits=sum%10;
			summ+=digits;
			sum/=10;
		}
			return summ;
	}
	   return sum;
	}
	
	
public static void main(String[] args) {
	int a=2,b=3,count=0;
	while(a<=8) {
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
