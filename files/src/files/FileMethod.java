package files;

import java.io.*;

import manualexception.ManualException;

import java.util.*;

import utility.Utility;

public class FileMethod {

	Utility util = new Utility();
	
	//1
	
    public File fileCreation(String dir,String fileName) throws ManualException{
    	
    	
    	util.stringNullCheck(dir);
    	util.stringNullCheck(fileName);

		File myFile;
		                    
    	try {
    		
    		myFile = new File(dir,fileName);
    		
    		if(myFile.createNewFile()) {
    			
    			System.out.println("File creation succeed");
    			
    		}
    		
        else {		
    			System.out.println("File already exists");
    			
    		}
    	}
    	catch(IOException e) {
    		
    		throw new ManualException(e + "\nProblem in File Creation");
    		
    	}
    	
		return myFile;
		
    }
    
    public FileWriter fileWrite(File inputFile, boolean choose) throws ManualException {
    	
    	util.fileNullCheck(inputFile);
    	
    	try {
    		
    		FileWriter fileWrite = new FileWriter(inputFile,choose);
    	
    		return fileWrite;
    	}
    	
    	catch(IOException e) {
    	
    		throw new ManualException(e + "\nFile writing didn't worked");
    	
    	}
    }
    
    public void writingFile(FileWriter inputFile, String[] input) throws ManualException {
    	
    	util.fileNullCheck(inputFile);
    	util.arrayNullCheck(input);
    	
    	try {
    	for(String temp: input) {
    	    inputFile.append(temp+"\n");
    	}
    	}
    	catch(IOException e) {
    		System.out.println(e + "\nFile appending error");
    	}
    	finally {
    		try {
    		inputFile.close();
    		}
    		catch(IOException e) {}
    	}
    }
        
    public Object createProperties() {
  	  Properties property = new Properties();
  	  return property;
    } 
   
  
    //2
  
    public void storeHashTxt(Properties property,File txtFile,boolean choose,String key , String value) throws ManualException {
    	
                util.propertyNullCheck(property);
				util.fileNullCheck(txtFile);
                util.stringNullCheck(key);
                util.stringNullCheck(value);
                
                property.setProperty(key,value);
                
                FileWriter fileWrite = null;
            
                try {
                	
                fileWrite = new FileWriter(txtFile,choose);
               
                property.store(fileWrite,"Ali means Energy");
                
                fileWrite.close();
                }
                catch(IOException e) {
                	throw new ManualException(e + "\nProblem in file storing");
                }
                finally {
                	try {
                	fileWrite.close();
                	}
                	catch(Exception e) {}
                }
      }
    
    

	
		
	}