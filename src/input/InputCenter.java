package input;
import string.BeginnerProgrammingString;
import java.lang.String;
import java.util.*;


public class InputCenter {

Scanner scanObj = new Scanner(System.in);

public String getStringName(String input) {
System.out.println(input);
String stringInput = scanObj.nextLine();
try {
if(!stringInput.isEmpty()) {
return stringInput;
}
}
catch(Exception e) {
System.out.println("String input didn't satisfied");
}
return getStringName(input);
}


public char getCharacter(String input) {
System.out.println(input);
try{
char letter = scanObj.nextLine().charAt(0);
return letter;
} catch(Exception e) {
System.out.println("Char input didn't satisfied");
}
return getCharacter(input);
}


public int getNumber(String input) {
System.out.println(input);
try{
int number = scanObj.nextInt();
scanObj.nextLine();
return number;
}
catch(Exception e) {
System.out.println("Integer only accepted");
scanObj.nextLine();
}
return getNumber(input);
}

public double getDoubleNum(String input) {
System.out.println(input);
try{
double dNum = scanObj.nextDouble();
scanObj.nextLine();
return dNum;
} catch(Exception e) {
System.out.println("Double input didn't satisfied");
}
return getDoubleNum(input);
}

public long getLongNum(String input) {
System.out.println(input);
try{
long longN = scanObj.nextLong();
return longN;
} catch(Exception e) {
System.out.println("Long input didn't satisfied");
}
return getLongNum(input);
}


public void taskDetails() {
System.out.println("Dial 1  = Display the length of a String without Scanner");
System.out.println("Dial 2  = Display the conversion of string into character Array");
System.out.println("Dial 3  = Display the Penultimate");
System.out.println("Dial 4  = Display the Number of occurrences for a given letter/character");
System.out.println("Dial 5  = Display the greatest position of the given letter/character");
System.out.println("Dial 6  = Display the  last 5 characters of a given String ");
System.out.println("Dial 7  = Display the first 3 characters of a given String");
System.out.println("Dial 8  = Display the replacing of first 3 characters with a String \"XYZ\"");
System.out.println("Dial 9  = Display the String starts with \"ent\"");
System.out.println("Dial 10 = Display the String ends with \"le\"");
System.out.println("Dial 11 = Display the conversion of lowercase string to uppercase string");
System.out.println("Dial 12 = Display the conversion of uppercase string to lowercase string");
System.out.println("Dial 13 = Display the reversal String");
System.out.println("Dial 14 = Display the acceptance of line with multiple Strings");
System.out.println("Dial 15 = Display the concatenation each individual strings and output a single String without space");
System.out.println("Dial 16 = Display the acceptance of multiple Strings with enclosing each String into a String array");
System.out.println("Dial 17 = Display the acceptance of multiple Strings & merge each String with \"-\" in between them");
System.out.println("Dial 18 = Display the two given input String are equal case sensitive ");
System.out.println("Dial 19 = Display the two given input String are equal case insensitive");
System.out.println("Dial 20 = Display the acceptance of String with a space at the end & beginning or both and output the proper String with no space either at the beginning or end");
System.out.println("Dial here below to perform your tasks");
System.out.println("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
}
}


//17
/*public void stringMerge(int number) {
String[] outputString = new String[number];
System.out.println("Enter the string");
for(int iterate= 0;iterate<number;iterate++){
outputString[iterate] = inputString.next();
}
System.out.println(String.join("-", outputString));
}*/

