package taskone;

public class TaskOne {

	public void middlePattern(String s) {
		int length = s.length();
		int subLength = s.length()/2;
		String sub = s.substring(subLength);
		String addString="";
		
		for(int i = 0 ; i < length; i++) {
			    if(i<=subLength) {
				char single = sub.charAt(i);
				addString = addString + single;
				System.out.print(addString+"$ ");
			    }
			    else if(i>subLength){
				char single1 = s.charAt(i-(subLength+1));
				addString = addString + single1;
				System.out.print(addString+"$ ");
			    }
		}
	}
	
	public String remainingString(String S, char ch, int count) {
		int length = S.length();
		int temp=0;
		int counter=0;
		if(count == 0) {
			return S;
		}
		for(int i=0;i<length;i++) {
			if(S.charAt(i)==ch) {
				counter++;
				if(counter==count) {
				temp=i+1;
				} 
			}
		}
		if(counter < count) {
			return "Empty string";
		}
		if((S.substring(temp).isEmpty())) {
			return "Empty string";
		}
		else {
			return S.substring(temp);
		}
	}
	
	public void totalDecoding(String str) {
		int length = str.length(),temp=0;
		char ch;
		for(int i = 0 ; i < length ; i++) {
			temp = str.charAt(i)-48;
			ch = (char) (temp+64);
			System.out.print(ch);
		}
	}
}
