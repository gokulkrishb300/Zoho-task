package string;

public class BeginnerProgrammingString{

public void stringInputCheck(String inputString) throws Exception{

if(inputString == null||inputString.isEmpty())  {
throw new Exception("Input neither be null nor be empty");
}
}

public boolean numberRangeCheck(int primary,int secondary)throws Exception{
if(secondary >= primary || secondary < 0) {
throw new Exception("Input is out of range");
}
return true;
}

public boolean rangeValidator(int primary , int secondary) throws Exception {
if(primary > secondary || primary < 0 || secondary < 0) {
throw new Exception("Input isn't in range");
}
return true;
}

//1
public int getLength(String arguments)throws Exception{
stringInputCheck(arguments);
return arguments.length();
}

//2
public char[] conversionStringToChar(String inputString)throws Exception {
stringInputCheck(inputString);
char[] charInput = inputString.toCharArray();
return charInput;
}

//3
public char charDetector(String inputString, int stringPosition)throws Exception {

int len = getLength(inputString);
boolean result = numberRangeCheck(len,stringPosition);
return inputString.charAt(stringPosition);
}


//4
public int numberOfOccurences(String inputString,char targettedLetter)throws Exception{
int counter = 0;
stringInputCheck(inputString);
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
public int greatestPosition(String inputString,char inputChar)throws Exception{
stringInputCheck(inputString);
return inputString.lastIndexOf(inputChar);
}

//6
public String lastNCharacters(String inputString , int upto)throws Exception{
int len = getLength(inputString);
boolean result = numberRangeCheck(len,upto);
return inputString.substring(len-upto);
}

//7
public String firstNCharacters(String inputString , int upto)throws Exception{
int len = getLength(inputString);
boolean result = numberRangeCheck(len,upto);
return inputString.substring(0,upto);
}

//8
public String stringReplacer(String inputString,String replaceString)throws Exception{
stringInputCheck(inputString);
stringInputCheck(replaceString);
int lenInput2 = getLength(replaceString);
return replaceString+inputString.substring(lenInput2);
}

//9
public boolean checkingStart(String inputString,String checkingStartString)throws Exception{
stringInputCheck(inputString);
stringInputCheck(checkingStartString);
return inputString.startsWith(checkingStartString);
}

//10
public boolean checkingEnd(String inputString,String checkingEndString)throws Exception{
stringInputCheck(inputString);
stringInputCheck(checkingEndString);
return inputString.endsWith(checkingEndString);
}
//11
public String upperCaseChanger(String inputString)throws Exception{
stringInputCheck(inputString);
return inputString.toUpperCase();
}

//12
public String lowerCaseChanger(String inputString)throws Exception{
stringInputCheck(inputString);
return inputString.toLowerCase();
}

//13
public String stringReversing(String inputString)throws Exception{
stringInputCheck(inputString);
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
public String stringSpaceRemover(String inputString)throws Exception{
stringInputCheck(inputString);
return inputString.replaceAll("\\s","");
}

//16
public String[]  stringSpliting(String inputString)throws Exception{
stringInputCheck(inputString);
String[] words = inputString.split("\\s");
return words;
}
//17
public String stringMerge(String inputString[]) throws Exception{
for(String st : inputString){
stringInputCheck(st);
}
String inputString1 = "";
inputString1 = String.join("-", inputString);
return inputString1;
}

//18
public boolean stringCaseSensitive(String firstString,String secondString)throws Exception{
stringInputCheck(firstString);
stringInputCheck(secondString);
return firstString.equals(secondString);
}

//19
public boolean stringCaseInSensitive(String firstString,String secondString)throws Exception{
stringInputCheck(firstString);
stringInputCheck(secondString);
return firstString.equalsIgnoreCase(secondString);
}

//20
public String stringTrimming(String inputString)throws Exception{
stringInputCheck(inputString);
return inputString.trim();
}
}
