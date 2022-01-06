package files;

import java.io.*;

import manualexception.ManualException;

import java.util.*;

import utility.Utility;

public class FileMethod {

	Utility util = new Utility();
	
    public Object createAFile(String txtFile) throws ManualException{
    	
    	try {
    		File myFile = new File(txtFile);
    		if(myFile.createNewFile()) {
    			return myFile.getName();
    		}
    		else {
    			return "File already exists";
    		}
    	}
    	catch(IOException e) {
    		throw new ManualException("Problem in File Creation");
    	}
    }
    
    public void writeAFile(String txtFile, String wrtFile) throws ManualException {
    	FileWriter fileWrite = null;
    	try {
    	fileWrite = new FileWriter(txtFile);
    		fileWrite.write(wrtFile);
    		util.fileNullCheck(fileWrite);
    		fileWrite.close();
    	}
    	catch(IOException e) {
    	
    		throw new ManualException("File writing didn't worked");
    	
    	}
    	
    	finally {
    		try {
				fileWrite.close();
    		}catch(Exception e) {}
    	}
    }
    
    public Map<Object, Object> createHashTable() {
    	Map<Object,Object> hashTableMap = new HashMap<Object,Object>();
    	return hashTableMap;
    }
    
    public Map<Object,Object> addHashTable(Map<Object,Object> htmap,Object key, Object value) throws ManualException{
    	util.mapNullCheck(htmap);
    	htmap.put(key,value);
    	return htmap;
    }
    
    public void storeHashTxt(Object key , Object value) throws ManualException {
                
    }
    
    
    

	
}
