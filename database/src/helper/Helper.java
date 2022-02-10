package helper;

import manualexception.ManualException;

public class Helper {
public void mapNullCheck(Object map) throws ManualException{
	if(map == null) {
		throw new ManualException("Map Contains null");
	}
}
}
