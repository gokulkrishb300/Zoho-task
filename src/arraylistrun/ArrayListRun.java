package arraylistrun;
import arraylist.ArrayMethod;
import input.InputCenter;
import java.util.*;

public class ArrayListRun {

public static void main(String[] args) {

ArrayMethod arrayLog = new ArrayMethod();
InputCenter input = new InputCenter();
int number = input.getNumber("enter the dial");

switch(number) {

case 1 :
	try {
	List lSize = arrayLog.createArrayList();
	System.out.println(arrayLog.sizeOfArrayList(lSize));
	System.out.println(lSize);
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 2 :
	try {
	List lAddString = arrayLog.createArrayList();
	int nStrings = input.getNumber("how many String input");
	String[] addString = new String[nStrings];
	
	for(int i = 0 ; i < nStrings ; i++) {
	addString[i] = input.getStringName("type "+(i)+" th string :)");	
	}
	
	System.out.println(arrayLog.addingList(lAddString,addString));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lAddString));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	
	break;
case 3 :
	try {
	List lAddInteger = arrayLog.createArrayList();
	int nIntegers = input.getNumber("how many Integer input");
	Integer[] addInteger = new Integer[nIntegers];
	
	for(int i = 0 ; i < nIntegers ; i++) {
	addInteger[i] = input.getNumber("type "+(i+1)+" th integer :)");
	}
	
	System.out.println(arrayLog.addingList(lAddInteger,addInteger));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lAddInteger));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 4 :
	try {
	List lAddObject = arrayLog.createArrayList();
	int nObject = input.getNumber("how many Object input");
	Object[] addObject = new Object[nObject];
	
	for(int i = 0 ; i < nObject ; i++) {
	ArrayMethod arrayLogObj = new ArrayMethod();
	addObject[i] = arrayLogObj;
	}
	
	System.out.println(arrayLog.addingList(lAddObject,addObject));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lAddObject));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
	
case 5 :
	try {
	List lAddAll = arrayLog.createArrayList();
	int nStringsAll = input.getNumber("how many String input");
	
	String[] addStringAll = new String[nStringsAll];
	for(int i = 0 ; i < nStringsAll ; i++) {
	addStringAll[i] = input.getStringName("type "+(i)+" th string :)");	
	}
	
	int nIntegerAll = input.getNumber("how many Integer input");
	
	Integer[] addIntegerAll = new Integer[nIntegerAll];
	for(int i = 0 ; i < nIntegerAll ; i++) {
	addIntegerAll[i] = input.getNumber("type "+(i+1)+" th integer :)");
	}
	
	int nObjectAll = input.getNumber("how many Object input");
	
	Object[] addObjectAll = new Object[nObjectAll];
	for(int i = 0 ; i < nObjectAll ; i++) {
	ArrayMethod arrayLogObj = new ArrayMethod();
	addObjectAll[i] = arrayLogObj;
	}
	
	arrayLog.addingList(lAddAll,addStringAll);
	arrayLog.addingList(lAddAll,addIntegerAll);
	System.out.println(arrayLog.addingList(lAddAll,addObjectAll));
	
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lAddAll));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
	
case 6 :
	try {
	List lIndex = arrayLog.createArrayList();
	int nStringsI = input.getNumber("how mahy String input");
	
	String[] addStringI = new String[nStringsI];
	for(int i = 0 ; i < nStringsI ; i++) {
	addStringI[i] = input.getStringName("type " + (i)+" th string :)");
	}
	
	arrayLog.addingList(lIndex,addStringI);
	
	String findString = input.getStringName("type to find string");
	
	System.out.println("resultant index : " +arrayLog.findIndex(lIndex,findString));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lIndex));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 7 :
	try {
	List lIterator = arrayLog.createArrayList();
	int nStringIterate = input.getNumber("how many String input");
	
	String[] addStringIterator = new String[nStringIterate];
	for(int i=0;i<nStringIterate ; i++) {
	addStringIterator[i] = input.getStringName("type " +(i)+" th string :)");
	}
	arrayLog.addingList(lIterator,addStringIterator);
	
	Iterator iteObj = lIterator.iterator();
	System.out.println("Iterator result : ");
	for(int i = 0 ;iteObj.hasNext(); i++) {
	System.out.println(iteObj.next());
	}
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lIterator));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 8 :
	try {
	List lGive = arrayLog.createArrayList();
	int nStringGive = input.getNumber("how many String input");
	
	String[] addStringGive = new String[nStringGive];
	for(int i = 0;i < nStringGive ; i++ ) {
	addStringGive[i] = input.getStringName("type " +(i)+" th string :)");
	}
	
	int nFind = input.getNumber("retrieve the index string");
	
	arrayLog.addingList(lGive,addStringGive);
	System.out.println(arrayLog.findElementAtIndex(lGive,nFind));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lGive));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 9 :
	try {
	List lDuplicate = arrayLog.createArrayList();
	int nStringDuplicate = input.getNumber("how many String input");
	
	String[] addStringDuplicate = new String[nStringDuplicate];
	for(int i = 0 ; i < nStringDuplicate; i++) {
	addStringDuplicate[i] = input.getStringName("type " +(i)+" th string :)");
	}
	
	String findDuplicate = input.getStringName("type to print duplicate index");
	arrayLog.addingList(lDuplicate, addStringDuplicate);
	System.out.println(arrayLog.findIndex(lDuplicate , findDuplicate));
	System.out.println(arrayLog.findLastIndex(lDuplicate , findDuplicate));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lDuplicate));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
	
case 10 :
	try {
	List lPos = arrayLog. createArrayList();
	int nStringPos = input.getNumber ("how many String input");
	
	String[] addStringPos = new String[nStringPos];
	for(int i=0 ; i< nStringPos ; i++ ) {
	addStringPos[i] = input.getStringName("type " +(i)+ " th string :)");
	}
	arrayLog.addingList(lPos, addStringPos);
	
	int intPos = input.getNumber("type position");
	String insertString = input.getStringName("type inserting string");
	
	System.out.println(arrayLog.insertList(lPos, intPos , insertString));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lPos));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 11 :
	try {
	List lNew = arrayLog.createArrayList();
	int nStringNew = input.getNumber("how many String input");
	
	String[] addStringNew = new String[nStringNew];
	for(int i = 0 ; i < nStringNew ; i++) {
	addStringNew[i] = input.getStringName("type " + (i)+ " th string :)");
	}
	arrayLog.addingList(lNew, addStringNew);
	
	int intFirst = input.getNumber("type starting index");
	int intLast = input.getNumber("type ending index");
	List lNewar = arrayLog.takeSubList(lNew, intFirst , intLast);
	System.out.println(lNewar);
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lNewar));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 12 :
	try {
	List lFirst = arrayLog.createArrayList();
	int nFirst = input.getNumber("how many First List String input");
	
	String[] addFirst = new String[nFirst];
	for(int i = 0; i< nFirst ; i++) {
	addFirst[i] = input.getStringName("type " +(i)+ " th string :)");
	}
	arrayLog.addingList(lFirst , addFirst);
	
	List lSecond = arrayLog.createArrayList();
	int nSecond = input.getNumber("how many Second List String input");
	
	String[] addSecond = new String[nSecond];
	for(int i = 0 ; i< nSecond ; i++ ) {
	addSecond[i] = input.getStringName("type " +(i)+ " th string :)" );
	}
	arrayLog.addingList(lSecond , addSecond);
	List lThird = arrayLog.addAllList(lFirst , lSecond);
	System.out.println("New List : " + lThird);
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lThird));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 13 :
	try {
	
	List lFirstr = arrayLog.createArrayList();
	int nFirstr = input.getNumber("how many First List String input");
	
	String[] addFirstr = new String[nFirstr];
	for(int i = 0; i< nFirstr ; i++) {
	addFirstr[i] = input.getStringName("type " +(i)+ " th string :)");
	}
	arrayLog.addingList(lFirstr , addFirstr);
	
	List lSecondr = arrayLog.createArrayList();
	int nSecondr = input.getNumber("how many Second List String input");
	
	String[] addSecondr = new String[nSecondr];
	for(int i = 0 ; i< nSecondr ; i++ ) {
	addSecondr[i] = input.getStringName("type " +(i)+ " th string :)" );
	}
	arrayLog.addingList(lSecondr , addSecondr);
	List lThirdr = arrayLog.addAllList(lSecondr, lFirstr);
	System.out.println("New List : " + lThirdr);
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lThirdr));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 14 :
	try {
	List lRemove = arrayLog.createArrayList();
	int nRemove = input.getNumber("how many decimal input");
	
	Double[] addRemove = new Double[nRemove];
	for(int i = 0 ; i < nRemove ; i++) {
	addRemove[i] = input.getDoubleNum("type " +(i)+ " th decimal");
	}
	arrayLog.addingList(lRemove,addRemove);
	
	double dRemove = input.getDoubleNum("type removing decimal");
	System.out.println(arrayLog.removeList(lRemove,dRemove));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lRemove));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 15 :
	try {
	List lRemovePos = arrayLog.createArrayList();
	int nRemovePos = input.getNumber("how many decimal input");
	
	Double[] addRemovePos = new Double[nRemovePos];
	for(int i=0;i<nRemovePos;i++) {
	addRemovePos[i] = input.getDoubleNum("type " +(i)+ " th decimal");
	}
	arrayLog.addingList(lRemovePos, addRemovePos);
	int iRemove = input.getNumber("type removing position");
	System.out.println(arrayLog.removeListUsingIndex(lRemovePos , iRemove));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lRemovePos));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
/*case 16 :
	try {
	List lLong = arrayLog.createArrayList();
	int nLong = input.getNumber("how many long input");
	Long[] addLong = new Long[nLong];
	
	for(int i = 0 ; i < nLong ; i++) {
	addLong[i] = input.getLongNum("type "+(i)+ " th long");
	}
	arrayLog.addingList(lLong , addLong);
	
	int firstPos = input.getNumber("Enter initial position");
	int endPos = input.getNumber("Enter last Position");
	
	System.out.println(arrayLog.takeSubList(lLong,firstPos,endPos));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;*/
case 17 :
	try {
	List lFirstRe = arrayLog.createArrayList();
	int nFirstRe = input.getNumber("how many firstLi String input");
	String[] addFirstRe = new String[nFirstRe];
	
	for(int i = 0 ; i < nFirstRe ; i++ ) { 
	addFirstRe[i] = input.getStringName("type " +i+ " th string");
	}
	arrayLog.addingList(lFirstRe , addFirstRe);
	
	List lSecondRe = arrayLog.createArrayList();
	int nSecondRe = input.getNumber("how many secondLi String input");
	String[] addSecondRe = new String[nSecondRe];
	
	for(int i = 0 ; i < nSecondRe ; i++ ) {
	addSecondRe[i] = input.getStringName("type " +i+ " th string");
	}
	arrayLog.addingList(lSecondRe, addSecondRe);
	
	System.out.println(arrayLog.removeAllList(lFirstRe, lSecondRe));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lFirstRe));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 18 :
	try {
	List lFirstRet = arrayLog.createArrayList();
	int nFirstRet = input.getNumber("how many firstLi String input");
	String[] addFirstRet = new String[nFirstRet];
	
	for(int i = 0 ; i < nFirstRet ; i++ ) { 
	addFirstRet[i] = input.getStringName("type " +i+ " th string");
	}
	arrayLog.addingList(lFirstRet , addFirstRet);
	
	List lSecondRet = arrayLog.createArrayList();
	int nSecondRet = input.getNumber("how many secondLi String input");
	String[] addSecondRet = new String[nSecondRet];
	
	
	for(int i = 0 ; i < nSecondRet ; i++ ) {
	addSecondRet[i] = input.getStringName("type " +i+ " th string");
	}
	arrayLog.addingList(lSecondRet, addSecondRet);
	
	System.out.println(arrayLog.retainAllList(lFirstRet, lSecondRet));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lFirstRet));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 19 :
	try {
	List lLong = arrayLog.createArrayList();
	int nLong = input.getNumber("how many long input");
	Long[] addLong = new Long[nLong];
	
	for(int i = 0 ; i < nLong ; i++) {
	addLong[i] = input.getLongNum("type "+(i)+ " th long");
	}
	arrayLog.addingList(lLong , addLong);
	
	System.out.println(arrayLog.getClear(lLong));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lLong));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
case 20 :
	try {
	List lPresent = arrayLog.createArrayList();
	int nPresent = input.getNumber("how much String input");
	String[] addPresent = new String[nPresent];
	
	forLoop(nPresent,addPresent);
	
	String preString = input.getStringName("type String check present or not");
	arrayLog.addingList(lPresent,addPresent);
	System.out.println(arrayLog.containsInList(lPresent, preString));
	System.out.println("list size :  "+arrayLog.sizeOfArrayList(lPresent));
	} catch(Exception e) {
	System.out.println(e.getMessage());
	}
	break;
default :
	System.out.println("You have hitten an unavailable task");
	break;
	} 
	}
static String[] forLoop(int limit,String[] stringArray) {
InputCenter input = new InputCenter();
for(int i = 0 ; i < limit ; i++) {
stringArray[i] = input.getStringName("type " +i+ " th string");
}
return stringArray; 
}
}

	
