package stringRun;
import input.InputCenter;
import java.util.*;
import string.BeginnerProgrammingString;

public class Engine {

public static void main(String[] args) {

BeginnerProgrammingString engine = new BeginnerProgrammingString();
Scanner scanObj = new Scanner(System.in);
InputCenter inputCall = new InputCenter();

inputCall.taskDetails();

int num = inputCall.getNumber("Dial a number");

switch(num) {
case 1 :
	try{
	if(args.length>0) {
	int result = engine.getLength(args[0]);
	System.out.println(result);
	System.out.println("Your task "+num+" has been Executed");
	}
	else{
	System.out.println("Runtime argument failed");
	}
	
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
break;

case 2 :
	try {
	String str2= inputCall.getStringName("Enter the String");
	char[] characterArray = engine.conversionStringToChar(str2);
	for(char string: characterArray) {
	System.out.println(string);
	}
	System.out.println("Your Task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
break;
	
case 3:try{
	String str3=inputCall.getStringName("Enter the String");
	int num3=inputCall.getNumber("Enter a number");
	System.out.println(engine.charDetector(str3,num3));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
break;

case 4:try{
	String str4=inputCall.getStringName("Enter the String");
	char ch4=inputCall.getCharacter("Enter a character");
System.out.println(engine.numberOfOccurences(str4,ch4));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
break;
case 5:try{
	String str5=inputCall.getStringName("Enter the String"); 
	char ch5=inputCall.getCharacter("Enter a character");
	System.out.println(engine.greatestPosition(str5,ch5));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 6:try{
	String str6= inputCall.getStringName("Enter the String");
	int num6=inputCall.getNumber("Enter a number");
	System.out.println(engine.lastNCharacters(str6,num6));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 7:try{
	String str7=inputCall.getStringName("Enter the String");
	int num7=inputCall.getNumber("Enter a number");
	System.out.println(engine.firstNCharacters(str7,num7));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 8:try{
	String firstStr8=inputCall.getStringName("Enter the First String"),
	secondStr8=inputCall.getStringName("Enter the Replacing String");
    System.out.println(engine.stringReplacer(firstStr8,secondStr8));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 9:try{
	String firstStr9=inputCall.getStringName("Enter the First String"),
	secondStr9=inputCall.getStringName("Enter the Second String");
 	System.out.println(engine.checkingStart(firstStr9,secondStr9));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 10:try{
	String firstStr10=inputCall.getStringName("Enter the First String");
	String secondStr10=inputCall.getStringName("Enter the Second String");
	System.out.println(engine.checkingEnd(firstStr10,secondStr10));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
	
case 11:try{
	String str11=inputCall.getStringName("Enter the String");
	System.out.println(engine.upperCaseChanger(str11));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 12:try{
	String str12=inputCall.getStringName("Enter the String");
	System.out.println(engine.lowerCaseChanger(str12));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 13:try{
	String str13=inputCall.getStringName("Enter the String");
	System.out.println(engine.stringReversing(str13));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 14:try{
	String str14=inputCall.getStringName("Enter the String");
	System.out.println(str14);
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 15:try{
	String str15=inputCall.getStringName("Enter the String");
	System.out.println(engine.stringSpaceRemover(str15));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 16:try{
	String str16=inputCall.getStringName("Enter the String");
	String[] stringArray = engine.stringSpliting(str16);
	for(String s : stringArray) {
	System.out.println(s); }
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 17:try{
	int number = inputCall.getNumber("Enter the length of string Array");
	
	String arr[] = new String[number];
	System.out.println("Enter the array of string input");
	for(int iterate = 0; iterate <number;iterate++){
	arr[iterate] = scanObj. nextLine();
	}
	System.out.println(engine.stringMerge(arr));
	}
	catch(Exception e){
	System.out.println(e.getMessage());
	}
	
	
	break;
	
case 18:try{	
	String firstStr18=inputCall.getStringName("Enter the First String");
	String secondStr18=inputCall.getStringName("Enter the Second String");
	System.out.println(engine.stringCaseSensitive((firstStr18),(secondStr18)));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}

	break;
case 19:try{
	String firstStr19=inputCall.getStringName("Enter the First String");
	String secondStr19=inputCall.getStringName("Enter the Second String");
	System.out.println(engine.stringCaseInSensitive((firstStr19), (secondStr19)));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;

case 20:try{
	String str20=inputCall.getStringName("Enter the String");
	System.out.println(engine.stringTrimming(str20));
	System.out.println("Your task "+num+" has been Executed");
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
default:
	System.out.println("You have hitten Unavailable task");
	break;
}
}
}
