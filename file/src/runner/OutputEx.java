package runner;

import filecreation.FileCreation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import input.InputCenter;
import manualexception.ManualException;


public class OutputEx {
	FileCreation fileCall = new FileCreation("");
    InputCenter input = new InputCenter();
    
private void createFile() {
	try {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String filePath = read.readLine();
		System.out.println(filePath);
		
		String fileName = read.readLine();
		System.out.println(fileName);
		
		int length = Integer.parseInt(read.readLine());
		
		String[] fileStored = new String[length];
		
		String stored ="";
		
		for(int i=0;i<length;i++) {
			fileStored[i] = read.readLine();
		}
		for(String dummy:fileStored) {
			stored = stored +"\n"+dummy;
		}
		fileCall.createFile(filePath, fileName, stored);
	} catch(Exception e) {
		System.out.println("File exist");
	}
}

private void properties() {
	try {
		Properties pro = new Properties();
		String filePath = input.getString("Enter properties file path: ");
		int length = input.getInt("properties length: ");
		for(int i=0;i<length;i++) {
			String key = input.getString("Enter key: "+i+" ");
			String value = input.getString("Enter value: "+i+" ");
			pro = fileCall.properties(pro, filePath, key, value);
		}
	} catch(Exception ex) {
		System.out.println("File error");
		//ex.printStackTrace();
	}
}

private void load() {
	try {
		Properties pro = new Properties();
		String filePath = input.getString("FilePath: ");
		System.out.println(fileCall.load(pro, filePath));
	}catch(Exception ex) {
		System.out.println("File error");
		ex.printStackTrace();
	}
}


public static void main(String[] args) throws ManualException {
	InputCenter input = new InputCenter();
	FileCreation fileCall = new FileCreation("gokul");
	OutputEx outputCall = new OutputEx();
	int dial = input.getInt("dial: ");
	
	switch(dial) {
	case 1:
		outputCall.createFile();
		break;
	case 2:
		outputCall.properties();
		break;
	case 3:
		outputCall.load();
		break;
	case 4:
		try {
			String filePath = input.getString("FilePath: ");
			fileCall.directory(filePath);
			outputCall.createFile();
			outputCall.properties();
			outputCall.load();
		} catch(Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
		break;
	case 5:
		System.out.println(fileCall);
		break;
	default:
		System.out.println(dial +": task didn't invented");
	}
	
}
}
