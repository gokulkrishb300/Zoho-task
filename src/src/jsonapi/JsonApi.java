package jsonapi;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import input.InputCenter;
import manualexception.ManualException;

public class JsonApi{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ManualException {
	InputCenter input = new InputCenter();
	JSONObject jsonObj = new JSONObject();
	
	JSONObject jsonId = new JSONObject();
	jsonId.put("101",jsonObj);
	
	jsonObj.put("name", input.getString("Customer Name: "));
	jsonObj.put("age", input.getString("age: "));
	jsonObj.put("gender", input.getString("gender: "));
	jsonObj.put("mobile", input.getString("mobile number: "));
	
	JSONArray jsonArray = new JSONArray();
	jsonArray.add(jsonId);
	
	try(FileWriter file = new FileWriter("customer.json")){
		file.write(jsonArray.toJSONString());
		file.flush();
	}catch(IOException e) {
		e.printStackTrace();
	}
	System.out.println("File Created");
}

}