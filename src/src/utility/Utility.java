package utility;


import java.util.*;

import manualexception.ManualException;

public class Utility {

	public void fileNullCheck(Object input) throws ManualException{
		if(input == null) {
			throw new ManualException(input + " File can't be null");
		}
	}
	
	public void stringNullCheck(String input) throws ManualException{
		if(input == null || input.isEmpty()) {
			throw new ManualException(input + " String can't be null");
		}
	}
	
	public void arrayNullCheck(String[] input) throws ManualException{
		for(String arrayCheck : input) {
			stringNullCheck(arrayCheck);
		}
	}
	
	public void mapNullCheck(Map<Object,Object> map) throws ManualException {
		if(map == null) {
			throw new ManualException(map + "map can't be null");
		}
	}
    
	public void propertyNullCheck(Object property) throws ManualException {
		if(property == null) {
			throw new ManualException(property + "property list can't be null");
		}
	}
	
}