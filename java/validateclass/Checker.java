package validateclass;
import java.io.File;

import manualexception.ManualException;

public class Checker 
{
	static public void nullCheck(String dummy)throws ManualException
	{
		if(dummy==null||dummy.isEmpty())
		{
			throw new ManualException("Object can't be Null");
		}
	}
	
	
	static public void nullCheck(Object dummy)throws ManualException
	{
		if(dummy==null)
		{
			throw new ManualException("Object can't be Null");
		}
	}
	
	
	static public void nullCheckFile(Object dummy)throws ManualException
	{
		if(dummy==null)
		{
			throw new ManualException("File can't be Null");
		}
	}
	
	
	public void nullCheckDirectory(File fileObj)throws ManualException
	{
		if(!(fileObj.isDirectory()))
		{
			throw new ManualException("Directory does not Exist");
		}
	}
}
