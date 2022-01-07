package filemethodrunner;

import input.InputCenter;

import manualexception.ManualException;

import java.io.*;

import files.FileMethod;

public class FileRunner {
	
	      FileMethod file = new FileMethod();
	
        InputCenter input = new InputCenter();
    
    private void caseOne() throws ManualException {
    	
               String dir = input.getString("File directory");
    
          String fileName = input.getString("File name");
    
           File inputFile = file.createAFile(dir, fileName);
    
           boolean choice = input.getBoolean("true or false");
    
     FileWriter fileWrite = file.createWrite(inputFile,choice);
    
     int size = input.getInt("How many number of lines ?");
     
     String[] inputArray = new String[size];
     
     for(int i = 0 ; i < size ; i++) {
    	 inputArray[i] = input.getString("enter " + i + " th line");
     }
     
    file.writeFile(fileWrite,inputArray);
    
    }
    
   /* private void caseTwo() {
    	
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
