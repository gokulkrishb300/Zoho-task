package string;

import utility.Utility;

import customexception.CustomException;

public class BeginnerProgrammingString{

Utility util = new Utility();
//1
public int getLength(String arguments)throws CustomException{

util.utilityStringNull(arguments);

return arguments.length();
}

//2
public char[] conversionStringToChar(String inputString)throws CustomException {
util.utilityStringNull(inputString);
char[] charInput = inputString.toCharArray();
return charInput;
}

//3
public char charDetector(String inputString, int stringPosition)throws CustomException {

int len = getLength(inputString);
boolean result = util.utilityNumberRangeCheck(len,stringPosition);
return inputString.charAt(stringPosition);
}


//4
public int numberOfOccurences(String inputString,char targettedLetter)throws CustomException{
int counter = 0;
util.utilityStringNull(inputString);
int size = inputString.length();
for(int i=0;i<size;i++){
if(inputString.charAt(i)==targettedLetter)
{
counter++;
}
}
return counter;
}

//5
public int greatestPosition(String inputString,char inputChar)throws CustomException{
util.utilityStringNull(inputString);
return inputString.lastIndexOf(inputChar);
}

//6
public String lastNCharacters(String inputString , int upto)throws CustomException{
int len = getLength(inputString);
boolean result = util.utilityNumberRangeCheck(len,upto);
return inputString.substring(len-upto);
}

//7
public String firstNCharacters(String inputString , int upto)throws CustomException{
int len = getLength(inputString);
boolean result = util.utilityNumberRangeCheck(len,upto);
return inputString.substring(0,upto);
}

//8
public String stringReplacer(String inputString,String replaceString)throws CustomException{
util.utilityStringNull(inputString);
util.utilityStringNull(replaceString);
int lenInput2 = getLength(replaceString);
return replaceString+inputString.substring(lenInput2);
}

//9
public boolean checkingStart(String inputString,String checkingStartString)throws CustomException{
util.utilityStringNull(inputString);
util.utilityStringNull(checkingStartString);
return inputString.startsWith(checkingStartString);
}

//10
public boolean checkingEnd(String inputString,String checkingEndString)throws CustomException{
util.utilityStringNull(inputString);
util.utilityStringNull(checkingEndString);
return inputString.endsWith(checkingEndString);
}
//11
public String upperCaseChanger(String inputString)throws CustomException{
util.utilityStringNull(inputString);
return inputString.toUpperCase();
}

//12
public String lowerCaseChanger(String inputString)throws CustomException{
util.utilityStringNull(inputString);
return inputString.toLowerCase();
}

//13
public String stringReversing(String inputString)throws CustomException{
util.utilityStringNull(inputString);
String appending="";
char wideToNarrow;
int stringLen= getLength(inputString);
for (int iterator=0; iterator<stringLen ; iterator++)
      {
        wideToNarrow = inputString.charAt(iterator); 
        appending = wideToNarrow+appending; 
      }
 String appendedResult= appending;
 return appendedResult;
}


//15
public String stringSpaceRemover(String inputString)throws CustomException{
util.utilityStringNull(inputString);
return inputString.replaceAll("\\s","");
}

//16
public String[]  stringSpliting(String inputString)throws CustomException{
util.utilityStringNull(inputString);
String[] words = inputString.split("\\s");
return words;
}
//17
public String stringMerge(String inputString[]) throws CustomException{
for(String st : inputString){
util.utilityStringNull(st);
}
String inputString1 = "";
inputString1 = String.join("-", inputString);
return inputString1;
}

//18
public boolean stringCaseSensitive(String firstString,String secondString)throws CustomException{
util.utilityStringNull(firstString);
util.utilityStringNull(secondString);
return firstString.equals(secondString);
}

//19
public boolean stringCaseInSensitive(String firstString,String secondString)throws CustomException{
util.utilityStringNull(firstString);
util.utilityStringNull(secondString);
return firstString.equalsIgnoreCase(secondString);
}

//20
public String stringTrimming(String inputString)throws CustomException{
util.utilityStringNull(inputString);
return inputString.trim();
}
}
