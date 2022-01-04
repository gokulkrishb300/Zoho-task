package arraylist;

import java.util.*;

import string.BeginnerProgrammingString;

import utility.Utility;

import customexception.CustomException;

public class ArrayMethod {

Utility util = new Utility();

public List<Object> createArrayList(){

List<Object> arrObj = new ArrayList<Object>();

return arrObj;

}





//1
public int sizeOfArrayList( List<Object> obj) throws CustomException {

util.utilityListCheck(obj);

return obj.size();

}

//addString2 //addInteger3 //addCustomObj4 //addStringIntegerCustomObj5

public List<Object> addingList( List<Object> inputList,Object[] objArray) throws CustomException {

util.utilityListCheck(inputList);

Collections.addAll(inputList,objArray);

return inputList;

}

//6
public int findIndex( List<Object> inputList,String findElement)throws CustomException{

  util.utilityListCheck(inputList);
  
int indexOfElement=inputList.indexOf(findElement);

return indexOfElement;
}



//8
public String findElementAtIndex( List<Object> inputList,int index)throws CustomException{

  util.utilityListCheck(inputList);
 
 int listLength = sizeOfArrayList(inputList);
 
util.utilityNumberRangeCheck(listLength,index);

String findElement=(String)inputList.get(index);

return findElement;
}

//9
public int findLastIndex( List<Object> inputList,String findStr)throws CustomException{

  util.utilityListCheck(inputList);

int lastIndex=inputList.lastIndexOf(findStr);

return lastIndex;
}


 
//10
public List<Object> insertList( List<Object> inputList,int position,String insertStr)throws CustomException{

  util.utilityListCheck(inputList);
  
  int listLength = sizeOfArrayList(inputList);
  
util.utilityNumberRangeCheck(listLength,position);

inputList.add(position,insertStr);

return inputList;

}

// 11   
public List<Object>takeSubList( List<Object> inputList,int startPosition,int endPosition)throws CustomException{

  util.utilityListCheck(inputList);
  
util.utilityStartEndPos(startPosition,endPosition);

 int listLength = sizeOfArrayList(inputList);
  
util.utilityNumberRangeCheck(listLength, startPosition);

util.utilityNumberRangeCheck(listLength, endPosition);

 List<Object> subList=inputList.subList(startPosition,endPosition);

return subList;

}

// 12   
public List<Object> addAllList( List<Object> firstList, List<Object> secondList)throws CustomException{

  util.utilityListCheck(firstList);
  
  util.utilityListCheck(secondList);
  
firstList.addAll(secondList);

return firstList;
}
// 14   
public List<Object> removeList( List<Object> addList,double removeFloat)throws CustomException{

  util.utilityListCheck(addList);
  
addList.remove(removeFloat);

return addList;
}
// 15   
public List<Object> removeListUsingIndex( List<Object> addList,int index)throws CustomException{

  util.utilityListCheck(addList);
  
int listLength = sizeOfArrayList(addList);

util.utilityNumberRangeCheck(listLength,index);

addList.remove(index);

return addList;
}
// 17   
public List<Object> removeAllList( List<Object> list1, List<Object> list2)throws CustomException{

  util.utilityListCheck(list1);
  
  util.utilityListCheck(list2);
  
list1.removeAll(list2);

return list1;
}
// 18    
public List<Object> retainAllList( List<Object> firstList, List<Object> secondList)throws CustomException{

  util.utilityListCheck(firstList);
  
  util.utilityListCheck(secondList);
  
firstList.retainAll(secondList);

return firstList;
}
// 19   
public List<Object> getClear( List<Object> inputList)throws CustomException{

  util.utilityListCheck(inputList);
  
inputList.clear();

return inputList;
}
// 20   
public boolean containsInList( List<Object> inputList,String checkStr)throws CustomException{

  util.utilityListCheck(inputList);
  
boolean checker=inputList.contains(checkStr);

return checker;
}

}
