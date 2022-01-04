package hashmaprun;

import java.util.*;

import hashmap.HashMapLog;

import input.InputCenter;

import customexception.CustomException;

public class HashMapRun {


HashMapLog mapCall = new HashMapLog();

InputCenter input = new InputCenter();


private void forLoop(Map<Object,Object> map) throws CustomException {

System.out.println("1 = String key and String Value");
System.out.println("2 = Integer key and Integer Value");
System.out.println("3 = String key and Integer Value");
System.out.println("4 = Integer key and String Value");

int choice = input.getNumber("choose appropriate type of Keys & Values");

int iteration = input.getNumber("\nNumber of iterations for choosen type");

switch(choice) {

case 1 :
                for(int i = 0 ;i < iteration ; i++) {

         String stringKey = input.getStringName("enter "+i+"th key");
       
       String stringValue = input.getStringName("enter "+i+"th value");
   
        mapCall.addHashMap(map, stringKey , stringValue);
        
        }
        
        System.out.println("     map result : " + map);
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(map));
        
break;


case 2 :

                for(int i = 0 ; i < iteration ; i++) {

               int intKey = input.getNumber("enter "+i+"th key");
             
             int intValue = input.getNumber("enter "+i+"th value");
  
             mapCall.addHashMap(map, intKey , intValue);
             
             }
             
             System.out.println("     map result : " + map);
	
	     System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(map));

break;


case 3 :

                    for(int i = 0 ; i < iteration ; i++) {

             String stringKey = input.getStringName("enter "+i+"th key");
             
                 int intValue = input.getNumber("enter "+i+"th value");
  
             mapCall.addHashMap(map, stringKey , intValue);
             
             }
             
             System.out.println("     map result : " + map);
	
	     System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(map));
break;


case 4 : 

                      for(int i = 0 ; i < iteration ; i++) {

                     int intKey = input.getNumber("enter "+i+"th key");
             
             String stringValue = input.getStringName("enter "+i+"th value");
  
             mapCall.addHashMap(map, intKey , stringValue);
             
             }
             
             System.out.println("     map result : " + map);
	
	     System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(map));

break;


default :
                for(int i = 0 ;i < iteration ; i++) {

         String stringKey = input.getStringName("enter "+i+"th key");
       
       String stringValue = input.getStringName("enter "+i+"th value");
   
        mapCall.addHashMap(map, stringKey , stringValue);
              
              }
              
              System.out.println("     map result : " + map);
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(map));

break;

        }

}


private void caseOne() {

try{
	
	Map<Object,Object> mapSize = mapCall.createHashMap();
	
	System.out.println(mapCall.sizeOfHashMap(mapSize));
	
	} catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
	
}

private void caseTwo() {

try{
	Map<Object, Object> stringMap = mapCall.createHashMap();
	
	int nString = input.getNumber("\nNumber of iterations");
	
	for(int i = 0 ;i < nString ; i++) {

         String stringKey = input.getStringName("enter "+i+"th key");
       
       String stringValue = input.getStringName("enter "+i+"th value");
   
        mapCall.addHashMap(stringMap, stringKey , stringValue);
        
        }
        
        System.out.println("     map result : " + stringMap);
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(stringMap));
	
	} catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	} 
	
}

private void caseThree() {

try{
	Map<Object,Object> integerMap = mapCall.createHashMap();
	
	int nInteger = input.getNumber("\nNumber of iterations");
	
	for(int i = 0 ; i < nInteger ; i++) {

               int intKey = input.getNumber("enter "+i+"th key");
             
             int intValue = input.getNumber("enter "+i+"th value");
  
             mapCall.addHashMap(integerMap, intKey , intValue);
             
             }
             
             System.out.println("     map result : " + integerMap);
	
	     System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(integerMap));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseFour() {

try{
	Map<Object,Object> stringIntMap = mapCall.createHashMap();
	
	int nStringInt = input.getNumber("\nNumber of iterations");
	
	 for(int i = 0 ; i < nStringInt ; i++) {

             String stringKey = input.getStringName("enter "+i+"th key");
             
                 int intValue = input.getNumber("enter "+i+"th value");
  
             mapCall.addHashMap(stringIntMap, stringKey , intValue);
             
             }
             
             System.out.println("     map result : " + stringIntMap);
	
	     System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(stringIntMap));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseFive() {

try{
	Map<Object,Object> stringObj = mapCall.createHashMap();
	
	int nObj = input.getNumber("\nNumber of iterations");
	
	 for(int i = 0 ; i < nObj ; i++ ) {
	
	              String stringKey  = input.getStringName("enter " +i+ "th string key");
	
	                 HashMapRun ran = new HashMapRun();
	
	mapCall.addHashMap(stringObj, stringKey , ran);
	
	}
	
	System.out.println("     map result : " + stringObj);
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(stringObj));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseSix() {

try{
	Map<Object,Object> nullMap = mapCall.createHashMap();
	
	                int nNull = input.getNumber("enter how many keys");
	
	for(int i = 0 ; i < nNull ; i++ ) {

	if(i == 0) {
	
	String stringKey = input.getStringName("enter "+i+"th string key");
	
	String stringValue = null;
	
	mapCall.addHashMap(nullMap, stringKey , stringValue);
	
	}
	else {
	String stringKey = input.getStringName("enter "+i+"th string key");
	
	String stringValue = input.getStringName("enter "+i+"th string value");
	
	mapCall.addHashMap(nullMap, stringKey , stringValue);
	}
	
	}
	
	System.out.println("     map result : " + nullMap);
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(nullMap));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	} 
}

private void caseSeven() {

try{
	Map<Object,Object> nullMap = mapCall.createHashMap();
	
	                int nNull = input.getNumber("enter how many keys");
	
	for(int i = 0 ; i < nNull ; i++ ) {

	if(i == 0) {
	String stringKey = null;
	
	String stringValue = input.getStringName("enter "+i+"th string value");
	
	mapCall.addHashMap(nullMap, stringKey , stringValue);
	}
	else {
	String stringKey = input.getStringName("enter "+i+"th string key");
	
	String stringValue = input.getStringName("enter "+i+"th string value");
	
	mapCall.addHashMap(nullMap, stringKey , stringValue);
	}
	
	}
	
	System.out.println("     map result : " + nullMap);
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(nullMap));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseEight() {

try{
   
        Map<Object,Object> checkKeyMap = mapCall.createHashMap();
	
	forLoop(checkKeyMap);
	
	String checkIKey = input.getStringName("enter a key to check");
	
	System.out.println("      key exist : " + mapCall.checkKeyMap(checkKeyMap, checkIKey));
    
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseNine() {

try{
        Map<Object,Object> checkValueMap = mapCall.createHashMap();
	
	forLoop(checkValueMap);
	
	String checkIValue = input.getStringName("enter a value to check");
	
	System.out.println("      key exist : " + mapCall.checkValueMap(checkValueMap,      checkIValue));
		
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseTen() {
try{
             Map<Object,Object> map1 = mapCall.createHashMap();
	
	     forLoop(map1);
	
	 Map<Object,Object> map2 = mapCall.createHashMap();
	
	     forLoop(map2);
	
	System.out.println("Suppressing Map2 on Map1");
	
	System.out.println("after map result   : " + mapCall.putAllHashMap(map1,map2));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(map1));
	
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}

}
 
private void caseEleven() {
try{    
	      Map<Object,Object> getMap = mapCall.createHashMap();
	
	forLoop(getMap);
	
	String getKey = input.getStringName("enter a key to get");
	
	System.out.println("Targeted Key Value: " + mapCall.getValueOfKeyMap(getMap,getKey));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	} 

}

private void caseTwelve() {

try{    
	     Map<Object,Object> getValue = mapCall.createHashMap();
	
	     forLoop(getValue);
	     
	String newKey   = input.getStringName("enter a non-existing key");
	
	String setValue = input.getStringName("enter a value to replace null");
	
	System.out.println("Targeted Key Value: " + mapCall.getValueOfNonKeyMap(getValue,newKey,setValue));
	
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseThirteen() {
try{
        Map<Object,Object> getValueKey = mapCall.createHashMap();
	
	                  forLoop(getValueKey);
	
	String newKeyValue   = input.getStringName("add a non-existing key");
	
	String setValueKey = input.getStringName("value for lateral entry key");
	
	System.out.println("After map result : " + mapCall.getNonKeyValueMap(getValueKey,newKeyValue,setValueKey));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(getValueKey));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseFourteen() {
try{
	Map<Object,Object> removeMap = mapCall.createHashMap();
	
	       forLoop(removeMap);
	
	String removeKey   = input.getStringName("enter a key to remove");
	
	System.out.println("After map result : " + mapCall.doRemoveMap(removeMap,removeKey));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(removeMap));
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	} 

}

private void caseFifteen() {
try{
	Map<Object,Object> removeIMap = mapCall.createHashMap();
	
	             forLoop(removeIMap);
	
	String removeIKey   = input.getStringName("enter a key to remove");
	
	String removeIValue = input.getStringName("enter corresponding key value to remove");
	
	System.out.println("After map result : " + mapCall.doRemoveMatchMap(removeIMap,removeIKey,removeIValue));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(removeIMap));

	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseSixteen() {

try{
	Map<Object,Object> replaceMap = mapCall.createHashMap();
	
	               forLoop(replaceMap);
	
	String replaceKey   = input.getStringName("enter a key to replace");
	
	String replaceValue = input.getStringName("enter replacing value");
	
	System.out.println("After map result : " + mapCall.doReplaceMap(replaceMap,replaceKey,replaceValue));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(replaceMap));

	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseSeventeen() {
try{
	Map<Object,Object> replaceIMap = mapCall.createHashMap();
	
	                  forLoop(replaceIMap);
	
	String replaceIKey   = input.getStringName("enter a key to replace");
	
	String replaceOValue = input.getStringName("enter old matching value");
	
	String replaceNValue = input.getStringName("enter new value");
	
	System.out.println("After map result : " + mapCall.doSameReplaceMap(replaceIMap,replaceIKey,replaceOValue,replaceNValue));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(replaceIMap));

	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseEighteen() {
try{
             Map<Object,Object> mapOne = mapCall.createHashMap();
	
	                  forLoop(mapOne);
	
	
	 Map<Object,Object> mapTwo = mapCall.createHashMap();
	
	                   forLoop(mapTwo);
	
	System.out.println("Suppressing Map2 on Map1");
	
	System.out.println("after map result   : " + mapCall.putAllHashMap(mapOne,mapTwo));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(mapOne));
	
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}

private void caseNineteen() {

try{
             Map<Object,Object> mapIterate = mapCall.createHashMap();
	
	                  forLoop(mapIterate);
	
	Iterator iter = mapIterate.entrySet().iterator();
	
	for(int i = 0 ;iter.hasNext(); i++){
	
	System.out.println(iter.next());
	
	}
	
	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
       }
}

private void caseTwenty() {
try{
	Map<Object,Object> eraseMap = mapCall.createHashMap();
	
	     forLoop(eraseMap);
	
	System.out.println("After map result : " + mapCall.clearMap(eraseMap));
	
	System.out.println("size of hashmap : " + mapCall.sizeOfHashMap(eraseMap));

	}catch(CustomException e) {
	
	System.out.println(e.getMessage());
	
	}
}
public static void main(String[] args) {

                         HashMapRun run = new HashMapRun();

                      InputCenter input = new InputCenter();

                               int dial = input.getNumber("Enter the dial");

switch(dial) {


case 1:  
       run.caseOne();
       break;
	

case 2:
	run.caseTwo();
	break;

case 3:
	run.caseThree();
	break;

case 4:
       run.caseFour();
	break;

case 5:
       run.caseFive();
       break;

case 6:
	run.caseSix();
	break;

case 7: 
         run.caseSeven();
	 break;
case 8:
         run.caseEight();
	 break;

case 9:
	run.caseNine();
	 break;

case 10:
         run.caseTen();
	 break;

case 11:
        run.caseEleven();
	break;

case 12:
	run.caseTwelve();
	 break;

case 13:
        run.caseThirteen();
	 break;

case 14:
	run.caseFourteen();
	break;

case 15:
	run.caseFifteen();
	 break;

case 16:
	run.caseSixteen();
	 break;

case 17:
	run.caseSeventeen();
	break;

case 18:
	run.caseEighteen();
	 break;

case 19:
	run.caseNineteen();
	break;

case 20:
	run.caseTwenty();
	break;

default:
	System.out.println("You have hitten a Unavailable task");
	break;
	}  }  }
