package arraylist;
import java.util.*;
import string.BeginnerProgrammingString;

public class ArrayMethod {

BeginnerProgrammingString check = new BeginnerProgrammingString();


public List createArrayList(){

List<Object> arrObj = new ArrayList<Object>();

return arrObj;

}

public void listCheck(List input) throws Exception {

if(input == null) {

throw new Exception("List can't be null");

}
}



//1
public int sizeOfArrayList(List obj) throws Exception {

listCheck(obj);

return obj.size();

}

//addString2 //addInteger3 //addCustomObj4 //addStringIntegerCustomObj5

public List addingList(List inputList,Object[] objArray) throws Exception {

listCheck(inputList);

Collections.addAll(inputList,objArray);
return inputList;

}

//6
public int findIndex(List inputList,String findElement)throws Exception{

  listCheck(inputList);
  
int indexOfElement=inputList.indexOf(findElement);

return indexOfElement;
}



//8
public String findElementAtIndex(List inputList,int index)throws Exception{

  listCheck(inputList);
 
 int listLength = sizeOfArrayList(inputList);
 
check.numberRangeCheck(listLength,index);

String findElement=(String)inputList.get(index);

return findElement;
}

//9
public int findLastIndex(List inputList,String findStr)throws Exception{

  listCheck(inputList);

int lastIndex=inputList.lastIndexOf(findStr);

return lastIndex;
}


 
//10
public List insertList(List inputList,int position,String insertStr)throws Exception{

  listCheck(inputList);
  
  int listLength = sizeOfArrayList(inputList);
  
check.numberRangeCheck(listLength,position);

inputList.add(position,insertStr);

return inputList;

}

// 11   
public List takeSubList(List inputList,int startPosition,int endPosition)throws Exception{

  listCheck(inputList);
  
check.rangeValidator(startPosition,endPosition);

 int listLength = sizeOfArrayList(inputList);
  
check.numberRangeCheck(listLength, startPosition);

check.numberRangeCheck(listLength, endPosition);

List subList=inputList.subList(startPosition,endPosition);

return subList;

}

// 12   
public List addAllList(List firstList,List secondList)throws Exception{

  listCheck(firstList);
  
  listCheck(secondList);
  
firstList.addAll(secondList);

return firstList;
}
// 14   
public List removeList(List addList,double removeFloat)throws Exception{

  listCheck(addList);
  
addList.remove(removeFloat);

return addList;
}
// 15   
public List removeListUsingIndex(List addList,int index)throws Exception{

  listCheck(addList);
  
int listLength = sizeOfArrayList(addList);

check.numberRangeCheck(listLength,index);

addList.remove(index);

return addList;
}
// 17   
public List removeAllList(List list1,List list2)throws Exception{

  listCheck(list1);
  
  listCheck(list2);
  
list1.removeAll(list2);

return list1;
}
// 18    
public List retainAllList(List firstList,List secondList)throws Exception{

  listCheck(firstList);
  
  listCheck(secondList);
  
firstList.retainAll(secondList);

return firstList;
}
// 19   
public List getClear(List inputList)throws Exception{

  listCheck(inputList);
  
inputList.clear();

return inputList;
}
// 20   
public boolean containsInList(List inputList,String checkStr)throws Exception{

  listCheck(inputList);
  
boolean checker=inputList.contains(checkStr);

return checker;
}

}
