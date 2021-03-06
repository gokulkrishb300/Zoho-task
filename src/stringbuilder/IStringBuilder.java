package stringbuilder;

import utility.Utility;

import customexception.CustomException;

public class IStringBuilder{

Utility util = new Utility();

// nullcheck for stringBuilder;




//String builder with one argument

public StringBuilder createStringBuilderArg(String inputString)throws CustomException
{

util.utilityStringNull(inputString);
StringBuilder build = new StringBuilder(inputString);
return build;
}

//String builder without  argument

public StringBuilder createStringBuilder(){
StringBuilder build = new StringBuilder();
return build;
}

//length method

public int getStringBuilderLength(StringBuilder build)throws CustomException
{
util.utilityStringBuilderNull(build);

return build.length();
}

// 1

public StringBuilder stringBuilderAppend(StringBuilder build,String inputString) throws CustomException
{
util.utilityStringBuilderNull(build);
util.utilityStringNull(inputString);
return build.append(inputString);
}

//2

public StringBuilder stringBuilderAppend(StringBuilder build,char inputString) throws CustomException
{
util.utilityStringBuilderNull(build);
return build.append(inputString);
}

//3

public StringBuilder iInsert(StringBuilder build,String toGetIndexNo,String insertString)throws CustomException
{
util.utilityStringBuilderNull(build);
util.utilityStringNull(toGetIndexNo);
util.utilityStringNull(insertString);
int indexNumber=iIndex(build,toGetIndexNo);
return build.insert(indexNumber,insertString);
}

//4

public StringBuilder iDelete(StringBuilder build,int initialNumber,String toGetIndexNo)throws CustomException
{
util.utilityStringBuilderNull(build);
util.utilityStringNull(toGetIndexNo);
int finalNumber=iIndex(build,toGetIndexNo);
util.utilityStartEndPos(initialNumber,finalNumber);
return build.delete(initialNumber,finalNumber);
}

//5

public StringBuilder iMultipleReplace(StringBuilder build,int length,char input,char replaceInput)throws CustomException
{
util.utilityStringBuilderNull(build);
for(int a=0;a<length;a++)
{
if(build.charAt(a)==input)
build.setCharAt(a,replaceInput);
}
return build;       
}

//6

public StringBuilder iReverseBuilder(StringBuilder build)throws CustomException
{
util.utilityStringBuilderNull(build);
return build.reverse();
}

//7

public StringBuilder iDelete(StringBuilder build, int initialNumber,int finalNumber)throws CustomException
{
util.utilityStringBuilderNull(build);
util.utilityStartEndPos(initialNumber,finalNumber);
return build.delete(initialNumber,finalNumber);
}

//8

public StringBuilder iReplace(StringBuilder build,int initialNumber,int finalNumber,String replaceWord)throws CustomException
{
util.utilityStringBuilderNull(build);
util.utilityStringNull(replaceWord);
util.utilityStartEndPos(initialNumber,finalNumber);
return build.replace(initialNumber,finalNumber,replaceWord);
}

//9

public int iIndex(StringBuilder build,String inputChar)throws CustomException
{
util.utilityStringBuilderNull(build);
util.utilityStringNull(inputChar);
return build.indexOf(inputChar);
}

//10

public int iLastIndex(StringBuilder build,String inputString)throws CustomException
{
util.utilityStringBuilderNull(build);
util.utilityStringNull(inputString);
return build.lastIndexOf(inputString);
}
}
