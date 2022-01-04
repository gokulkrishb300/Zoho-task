package utility;

import java.util.*;

import customexception.CustomException;

import stringbuilder.IStringBuilder;

import arraylist.ArrayMethod;


public class Utility {

public void utilityStringNull(String inputString) throws CustomException {

if(inputString == null||inputString.isEmpty())  {

throw new CustomException("Input neither be null nor be empty");

}

}



public boolean utilityNumberRangeCheck(int primary, int secondary) throws CustomException {

if(secondary >= primary || secondary < 0) {

throw new CustomException("Input is out of range");

} return true;

}

public boolean utilityStartEndPos(int primary , int secondary) throws CustomException {

if(primary > secondary || primary < 0 || secondary < 0) {

throw new CustomException("Input isn't in range");

} return true;

}

public void utilityStringBuilderNull(StringBuilder creator) throws CustomException {

if(creator== null){

throw new CustomException("StringBuilder null is not accepted ");
       
}
    
}

public void utilityListCheck(List<Object> input) throws CustomException {

if(input == null) {

throw new CustomException("List can't be null");

}

}

public void utilityNullHashMap(Map<Object,Object> map) throws CustomException {

if(map == null) {

throw new CustomException ("HashMap can't be null");

}

}



}
