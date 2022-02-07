package api;

import java.util.Map;
import java.util.HashMap;
import dbadvanced.AccountDetails;
import dbadvanced.CustomerDetails;
import manualexception.ManualException;
import helper.Helper;

public class Api{
	
	AccountDetails accountDetails = new AccountDetails();
	
	CustomerDetails customerDetails = new CustomerDetails();
	
	Helper helper = new Helper();
	
	int generator = 1000;
	
//	public Map<Object,Object> createMap() {
//		Map<Object,Object> map = new HashMap<Object,Object>();
//		return map;
//	}
	
	public Map<Integer, CustomerDetails> customerMap() {
		
		Map<Integer,CustomerDetails> map = new HashMap<>();
		
		return map;
	}
	
    public Map<Integer, Map<Integer, AccountDetails>> accountMap() {
		
    	Map<Integer,Map<Integer,AccountDetails>> map = new HashMap<>();
		
		
		return map;
	}
	
	public int autoCustId() {
		
		return generator++;
		
	}
    
	public int detectCustId(Map<Integer,CustomerDetails> customerMap,int detectId) throws ManualException {
		
		helper.mapNullCheck(customerMap);
		if(customerMap.containsKey(detectId)){
			
			return detectId;
			
		}else {
			
		System.out.println("ID didn't matched");
		System.exit(0);
		
	}
		return detectId;
}
	
	public void insideMap() {
		
	}
	
	
}
