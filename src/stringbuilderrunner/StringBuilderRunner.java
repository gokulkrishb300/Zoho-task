package stringbuilderrunner;
import stringbuilder.IStringBuilder;
import string.BeginnerProgrammingString;
import input.InputCenter;
import utility.Utility;
import customexception.CustomException;

public class StringBuilderRunner {
public static void main(String[] args){
Utility util = new Utility();
BeginnerProgrammingString bps = new BeginnerProgrammingString();
IStringBuilder isb = new IStringBuilder();
InputCenter input = new InputCenter();

int dial=input.getNumber("Enter the dial number");
switch(dial){

case 1:
       try{ 
       
            StringBuilder setBuilder =isb.createStringBuilder();
            int beforeInitialize =isb.getStringBuilderLength(setBuilder);
            System.out.println("Length="+ beforeInitialize);
            String stringAppend=input.getStringName("Enter the String to append");
            
            //method 1
            setBuilder= isb.stringBuilderAppend(setBuilder,stringAppend);
            int afterInitialize =isb.getStringBuilderLength(setBuilder);
            System.out.println("Length of Stringbuilder after append ="+afterInitialize+" "+setBuilder);
         }
       catch(Exception e)
       {
            System.out.println(e.getMessage());
       } 
break;

case 2:
       try{     
            String getString=input.getStringName("Enter the String");      
            
            StringBuilder setBuild = isb.createStringBuilderArg(getString); 
            
            int setLength =isb.getStringBuilderLength(setBuild); 
            
            char specialChar = input.getCharacter("Enter a small separator");
            
            System.out.println("Length="+ setLength);
            System.out.println(setBuild);      
            
            
            int getNStrings=input.getNumber("Enter the number of String you want to append");
                
            for(int i=0;i<getNStrings;i++)
            {
            String setNStrings=input.getStringName("Enter the String to append");
            //method 2
            setBuild= isb.stringBuilderAppend(setBuild,specialChar+""+setNStrings);			
            }  
            
            
            int finalLength =isb.getStringBuilderLength(setBuild); 
            
            System.out.println("Length of Stringbuilder after append ="+finalLength);
            System.out.println(setBuild);
         } 
       catch(CustomException e) 
       {
            System.out.println(e.getMessage());
       }    
break;

case 3:
       try{ 
           String firstString=input.getStringName("Enter the first String");        
           String secondString=input.getStringName("Enter the second String");         
           String appendingString=input.getStringName("Enter something to separate the above two string");    
                  
           StringBuilder setBuilderToInsertStr =isb.createStringBuilderArg(firstString);      
           
           setBuilderToInsertStr=isb.stringBuilderAppend(setBuilderToInsertStr,appendingString);     
           
           setBuilderToInsertStr=isb.stringBuilderAppend(setBuilderToInsertStr,secondString);           
            
           int StringBuilderlengthBeforeAppend3 =isb.getStringBuilderLength(setBuilderToInsertStr);     
           System.out.println("Length="+ StringBuilderlengthBeforeAppend3);
           System.out.println(setBuilderToInsertStr); 
           
                               
           String stringName33=input.getStringName("Enter string ");  
                       
           //method 3
           setBuilderToInsertStr=isb.iInsert(setBuilderToInsertStr,appendingString,appendingString+stringName33);          
           
           int StringBuilderlengthAfterAppend3 =isb.getStringBuilderLength(setBuilderToInsertStr);     
           System.out.println("Length of Stringbuilder after insert ="+StringBuilderlengthAfterAppend3);
           System.out.println("Final String : " + setBuilderToInsertStr);  
         }   
       catch(CustomException e)
       {
            System.out.println(e.getMessage());
       } 
break;

case 4:
       try{    
           String initializeFirstStr=input.getStringName("Enter the first String");  
           String initializeSecondStr=input.getStringName("Enter the second String");   
           String randomString=input.getStringName("Enter somechar to separate the above two string");       
                
           StringBuilder setBuilderToDelete =isb.createStringBuilderArg(initializeFirstStr);   
           
           setBuilderToDelete=isb.stringBuilderAppend(setBuilderToDelete,randomString);
           
           setBuilderToDelete=isb.stringBuilderAppend(setBuilderToDelete,initializeSecondStr);
           
	   int sbLengthBeforeDeletion =isb.getStringBuilderLength(setBuilderToDelete);
	   					
           System.out.println("Length="+ sbLengthBeforeDeletion+" "+setBuilderToDelete);
           
           
           //method 4
           setBuilderToDelete=isb.iDelete(setBuilderToDelete,0,randomString); 					
           					
           int sbLengthAfterDeletion =isb.getStringBuilderLength(setBuilderToDelete);
           
           System.out.println("Length of Stringbuilder after delete ="+sbLengthAfterDeletion);
           System.out.println("Final String : "+setBuilderToDelete);
           
           
         }
       catch(CustomException e)
       {
            System.out.println(e.getMessage());
       }     
break;

case 5:
       try{ 
           String launchFirstStr = input.getStringName("Enter the First String");   
           String launchSecondStr = input.getStringName("Enter the Second String"); 
           String launchThirdStr = input.getStringName("Enter the Third String");    
               
           char charToInsert = input.getCharacter("Enter somechar that separates inbetween the above string"); 
           
           StringBuilder sbToMultiReplace = isb.createStringBuilderArg(launchFirstStr);
              
           sbToMultiReplace = isb.stringBuilderAppend(sbToMultiReplace,charToInsert);             
           
           sbToMultiReplace = isb.stringBuilderAppend(sbToMultiReplace,launchSecondStr);        
               
           sbToMultiReplace = isb.stringBuilderAppend(sbToMultiReplace,charToInsert);          
              
           sbToMultiReplace = isb.stringBuilderAppend(sbToMultiReplace,launchThirdStr);
           
           int sbLengthB4MultiReplace =isb.getStringBuilderLength(sbToMultiReplace);    
             					
           System.out.println("Length="+ sbLengthB4MultiReplace+" "+sbToMultiReplace);    
           
                   
           char charToReplacePre = input.getCharacter("Enter another char to replace previous char");
           
           //method 5         
           sbToMultiReplace=isb.iMultipleReplace(sbToMultiReplace,sbLengthB4MultiReplace,charToInsert,charToReplacePre);	
           			
           int sbLengthAfterReplace =isb.getStringBuilderLength(sbToMultiReplace);      
           
           System.out.println("Length of Stringbuilder after replace : "+sbLengthAfterReplace);
           System.out.println(sbToMultiReplace);    
           
                 
         }       
       catch(CustomException e)       
       {
            System.out.println(e.getMessage());
       }       
break;

case 6:
       try{           
          String igniteFirstStr=input.getStringName("Enter the First String"); 
          String igniteSecondStr=input.getStringName("Enter the Second String");              
          String igniteThirdStr=input.getStringName("Enter the Third String");           
          String insertRandom=input.getStringName("Enter something that separates inbetween the above string"); 
                       
          StringBuilder sbReverse =isb.createStringBuilderArg(igniteFirstStr);
          
          sbReverse=isb.stringBuilderAppend(sbReverse,insertRandom);   
                 
          sbReverse=isb.stringBuilderAppend(sbReverse,igniteSecondStr);  
                    
          sbReverse=isb.stringBuilderAppend(sbReverse,insertRandom);  
                  
          sbReverse=isb.stringBuilderAppend(sbReverse,igniteThirdStr); 
             
          int sbLengthB4Reverse =isb.getStringBuilderLength(sbReverse);  
           
          System.out.println("Length="+ sbLengthB4Reverse+" "+sbReverse);
          
          
          //method 6
          sbReverse=isb.iReverseBuilder(sbReverse); 
          
          int sbLengthAfterReverse =isb.getStringBuilderLength(sbReverse);       
          
          System.out.println("Length of Stringbuilder after delete ="+sbLengthAfterReverse+" "+sbReverse);  
          
                  
         }      
       catch(CustomException e)      
       {
            System.out.println(e.getMessage());
       }       
break;

case 7:
       try{ 
               
          int specifyLengthOfInput=input.getNumber("Enter the minimum range for the string"); 
          
          String primeString=input.getStringName("Enter the String");  
          
         
                  
          StringBuilder sbDelete =isb.createStringBuilderArg(primeString);   
             
          int sbLengthB4Kill =isb.getStringBuilderLength(sbDelete); 
                      
          util.utilityNumberRangeCheck(sbLengthB4Kill, specifyLengthOfInput); 
               
          System.out.println("Length : "+ sbLengthB4Kill);
          
          
          System.out.println(sbDelete);   
          
                     
          int startIn=input.getNumber("Enter the startIndex number");     
                   
          int endIn=input.getNumber("Enter the endIndex number"); 
            
          //method 7
          sbDelete=isb.iDelete(sbDelete,endIn,startIn); 
                   
          int sbLengthAfterKill =isb.getStringBuilderLength(sbDelete);      
          
          System.out.println("Length of Stringbuilder after delete ="+sbLengthAfterKill+" "+sbDelete);    
          
                  
         }       
       catch(CustomException e)       
       {
            System.out.println(e.getMessage());
       }
       
break;

case 8:
       try{            
           int specifyLength=input.getNumber("Enter the minimum range for the string");
                        
           String primaryString=input.getStringName("Enter the String");          
           
           StringBuilder sbDeleteRepl =isb.createStringBuilderArg(primaryString);
           
           int sbLenB4 =isb.getStringBuilderLength(sbDeleteRepl);     
                   
           util.utilityNumberRangeCheck(sbLenB4,specifyLength);
                         
           System.out.println("Length : "+ sbLenB4);
           System.out.println(sbDeleteRepl);        
           
              
           String replaceString=input.getStringName("Enter the replace String");    
                  
           int startIndex=input.getNumber("Enter the startIndex number");          
               
           int endIndex=input.getNumber("Enter the endIndex number");
              
           //method 8
           sbDeleteRepl=isb.iReplace(sbDeleteRepl,startIndex,endIndex,replaceString);     
                    
           int sbLenAfterAppend =isb.getStringBuilderLength(sbDeleteRepl);      
           
           System.out.println("Length of Stringbuilder after delete ="+sbLenAfterAppend+" "+sbDeleteRepl); 
           
               
         }      
       catch(CustomException e)      
       {
            System.out.println(e.getMessage());
       }       
break;

case 9:
       try{           
          String initialiseFirstStr=input.getStringName("Enter the first String");              
          String initialiseSecondStr=input.getStringName("Enter the second String");              
          String initialiseThirdStr=input.getStringName("Enter the third String");              
          String median=input.getStringName("Enter the char that needed to be present in between the above string"); 
                       
          StringBuilder sbMedianFirst =isb.createStringBuilderArg(initialiseFirstStr);              
          
          sbMedianFirst=isb.stringBuilderAppend(sbMedianFirst,median);             
          
          sbMedianFirst=isb.stringBuilderAppend(sbMedianFirst,initialiseSecondStr);             
          
          sbMedianFirst=isb.stringBuilderAppend(sbMedianFirst,median);             
          
          sbMedianFirst=isb.stringBuilderAppend(sbMedianFirst,initialiseThirdStr);       
          
          int sbLengthB4 =isb.getStringBuilderLength(sbMedianFirst);       
          
          System.out.println("Length : "+ sbLengthB4+" "+sbMedianFirst);


          //method 9
          int finalIndex=isb.iIndex(sbMedianFirst,median);           
          
          System.out.println("index of first occurence of"+" "+median+"="+finalIndex);  
          
             
         }      
       catch(CustomException e)      
       {
            System.out.println(e.getMessage());
       }      
break;

case 10:
       try{       
          String receiveFirstStr=input.getStringName("Enter the first String");          
          String receiveSecondStr=input.getStringName("Enter the second String");             
          String receiveThirdStr=input.getStringName("Enter the third String");            
          String inserter=input.getStringName("Enter the Char that needed to be present in between the above string");   
                   
          StringBuilder sbInserterLast =isb.createStringBuilderArg(receiveFirstStr); 
                     
          sbInserterLast=isb.stringBuilderAppend(sbInserterLast,inserter);             
          
          sbInserterLast=isb.stringBuilderAppend(sbInserterLast,receiveSecondStr);           
            
          sbInserterLast=isb.stringBuilderAppend(sbInserterLast,inserter);             
          
          sbInserterLast=isb.stringBuilderAppend(sbInserterLast,receiveThirdStr);         
              
          int StringBuilderlengthBefore10 =isb.getStringBuilderLength(sbInserterLast);   
           
          System.out.println("Length : "+ StringBuilderlengthBefore10);
          System.out.println(sbInserterLast);  
            
                    
          //method 10
          int findFinalIndex=isb.iLastIndex(sbInserterLast,inserter);            
          
          System.out.println("index of last occurance of "+" "+inserter+" : "+findFinalIndex);
          
          
        }     
       catch(CustomException e)       
       {
            System.out.println(e.getMessage());
       }
       
break;
default:
System.out.println("You have not entered a proper cae number,see the description once and enter a valid case number");  
break;
}
}
}
