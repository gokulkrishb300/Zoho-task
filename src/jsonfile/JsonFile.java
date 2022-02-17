package jsonfile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import manualexception.ManualException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFile {


	public void createJSON(String name, JSONObject jsonObj) throws ManualException{
		try(FileWriter writer = new FileWriter(name)){
			writer.write(jsonObj.toJSONString());
		}catch(IOException ioe) {
			throw new ManualException("Problem in JSON file writing");
		}
	}
	
	public JSONObject readJSON(String name)throws ManualException{
		JSONParser parser = new JSONParser();
		try(FileReader read = new FileReader(name)){
			JSONObject jsonObj = (JSONObject) parser.parse(read);
			return jsonObj;
		} catch(IOException ioe) {
			throw new ManualException(ioe);
		} catch(ParseException pe) {
			throw new ManualException(pe);
		}
		
	}
}