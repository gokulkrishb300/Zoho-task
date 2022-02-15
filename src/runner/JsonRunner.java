package runner;
import manualexception.ManualException;



import java.io.FileReader;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class JsonRunner {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ManualException {
		
		JSONParser jsonParser = new JSONParser();
		
		try(FileReader readFile = new FileReader("customer.json")){
			
			JSONArray customerDetails = (JSONArray) jsonParser.parse(readFile);
			
			System.out.println(customerDetails);
			
			customerDetails.forEach(cus -> parseCustomerDetails((JSONObject)cus));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void parseCustomerDetails(JSONObject customer) {
		
		JSONObject customerKey = (JSONObject)customer.get("101");
		
		System.out.println(customerKey.get("name"));
		System.out.println(customerKey.get("age"));
		System.out.println(customerKey.get("gender"));
		System.out.println(customerKey.get("mobile"));
	}
	
}