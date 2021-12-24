package stringbuilder;
import string.BeginnerProgrammingString;


public class IStringBuilder{

BeginnerProgrammingString bps = new BeginnerProgrammingString();

// nullcheck for stringBuilder;


public void stringBuilderNullCheck(StringBuilder creator) throws Exception

{
    if(creator== null)
    {
       throw new Exception("StringBuilder null is not accepted ");
    }
}

//String builder with one argument

public StringBuilder createStringBuilderArg(String inputString)throws Exception
{
bps.stringInputCheck(inputString);
StringBuilder build = new StringBuilder(inputString);
return build;
}

//String builder without  argument

public StringBuilder createStringBuilder(){
StringBuilder build = new StringBuilder();
return build;
}

//length method

public int getStringBuilderLength(StringBuilder build)throws Exception
{
stringBuilderNullCheck(build);

return build.length();
}

// 1

public StringBuilder stringBuilderAppend(StringBuilder build,String inputString) throws Exception
{
stringBuilderNullCheck(build);
bps.stringInputCheck(inputString);
return build.append(inputString);
}

//2

public StringBuilder stringBuilderAppend(StringBuilder build,char inputString) throws Exception
{
stringBuilderNullCheck(build);
return build.append(inputString);
}

//3

public StringBuilder iInsert(StringBuilder build,String toGetIndexNo,String insertString)throws Exception
{
stringBuilderNullCheck(build);
bps.stringInputCheck(toGetIndexNo);
bps.stringInputCheck(insertString);
int indexNumber=iIndex(build,toGetIndexNo);
return build.insert(indexNumber,insertString);
}

//4

public StringBuilder iDelete(StringBuilder build,int initialNumber,String toGetIndexNo)throws Exception
{
stringBuilderNullCheck(build);
bps.stringInputCheck(toGetIndexNo);
int finalNumber=iIndex(build,toGetIndexNo);
bps.numberInputCheck(initialNumber,finalNumber);
return build.delete(initialNumber,finalNumber);
}

//5

public StringBuilder iMultipleReplace(StringBuilder build,int length,char input,char replaceInput)throws Exception
{
stringBuilderNullCheck(build);
for(int a=0;a<length;a++)
{
if(build.charAt(a)==input)
build.setCharAt(a,replaceInput);
}
return build;       
}

//6

public StringBuilder iReverseBuilder(StringBuilder build)throws Exception
{
stringBuilderNullCheck(build);
return build.reverse();
}

//7

public StringBuilder iDelete(StringBuilder build, int initialNumber,int finalNumber)throws Exception
{
stringBuilderNullCheck(build);
bps.numberInputCheck(initialNumber,finalNumber);
return build.delete(initialNumber,finalNumber);
}

//8

public StringBuilder iReplace(StringBuilder build,int initialNumber,int finalNumber,String replaceWord)throws Exception
{
stringBuilderNullCheck(build);
bps.stringInputCheck(replaceWord);
bps.numberInputCheck(initialNumber,finalNumber);
return build.replace(initialNumber,finalNumber,replaceWord);
}

//9

public int iIndex(StringBuilder build,String inputChar)throws Exception
{
stringBuilderNullCheck(build);
bps.stringInputCheck(inputChar);
return build.indexOf(inputChar);
}

//10

public int iLastIndex(StringBuilder build,String inputString)throws Exception
{
stringBuilderNullCheck(build);
bps.stringInputCheck(inputString);
return build.lastIndexOf(inputString);
}
}
