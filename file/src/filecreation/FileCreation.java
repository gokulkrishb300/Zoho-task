package filecreation;

import java.io.*;

import java.util.*;

import manualexception.ManualException;

public class FileCreation {

	
public void nullCheck(Object objFile)throws ManualException {
	
	if(objFile == null) {
		throw new ManualException("File can't be null");
	}
}

public void createFile(String filePath, String fileName, String fileStored) throws ManualException {
	try(FileWriter myWrite = new FileWriter(filePath+" "+fileName, true)) {
		nullCheck(myWrite);
		myWrite.append(fileStored);
	} catch(IOException ex) {
		throw new ManualException(ex);
	}
}

public Properties properties(Properties objPro, String filePath, String key, String value) throws ManualException {
	try(FileOutputStream file = new FileOutputStream(filePath)) {
		nullCheck(file);
		objPro.setProperty(key, value);
		objPro.store(file,"File Storing Success");
	} catch(IOException e) {
		throw new ManualException(e);
	}
	return objPro;
}

public Properties load(Properties objPro, String filePath) throws ManualException {
	try(FileInputStream file = new FileInputStream(filePath)){
		nullCheck(file);
		objPro.load(file);
	} catch(IOException e) {
		throw new ManualException(e);
	}
	return objPro;
}

public void directory(String filePath) throws ManualException {
	File objFile = new File(filePath);
	nullCheck(objFile);
	objFile.mkdirs();
}

private String name;
public FileCreation(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "FileCreation [name=" + name+ "]";
}
}
