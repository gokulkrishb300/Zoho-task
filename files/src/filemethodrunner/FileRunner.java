package filemethodrunner;

import input.InputCenter;

import manualexception.ManualException;

import java.io.*;

import java.util.*;

import files.FileMethod;

public class FileRunner {
	
	      FileMethod file = new FileMethod();
	
        InputCenter input = new InputCenter();
    
    private void caseOne() throws ManualException {
    	
               String dir = input.getString("File directory");
    
          String fileName = input.getString("File name");
    
           File inputFile = file.fileCreation(dir, fileName);
    
           boolean choice = input.getBoolean("Overwrite: true or false");
    
     FileWriter fileWrite = file.fileWrite(inputFile,choice);
    
     int size = input.getInt("How many number of lines ?");
     
     String[] inputArray = new String[size];
     
     for(int i = 0 ; i < size ; i++) {
    	 inputArray[i] = input.getString("enter " + i + " th line");
     }
     
    file.writingFile(fileWrite,inputArray);
    System.out.println("File Writing Succeed");
    }
    
   /*private void caseTwo() {
    	Properties pro ;
    	try {
    		pro = new Properties();
    		int 
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }*/
	
	public static void main(String[] args) throws ManualException {

	    InputCenter input = new InputCenter();
	    
	    FileRunner run = new FileRunner();
	    
		int dial = input.getInt("Enter the dial");
		
		switch(dial) {
		
		case 1:
			try {
			
			run.caseOne();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			break;
		
		case 2:
			
			//run.caseTwo();
			break;

		default:
			
			System.out.println("You have hitten an unavailable task");
			break;
	}

}
}