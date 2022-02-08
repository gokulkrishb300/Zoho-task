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
	
	int custIdGenerator = 1000;
	
	int accIdGenerator = 2000;
    
	Map<Object,Object> map = new Map<>();
	
	static Map<Integer,Map<Integer,AccountDetails>> map = <>();
    
    static Map<Integer, Map<Integer,AccountDetails>>  
    
    {
    	
    	
    	
    	return map;
    }
    
    public Map<Object,Object> mapping(Map<Object,Object> map, int setId, Object classInstance) throws ManualException{
       
         helper.mapNullCheck(map);
         
         map.put(setId, classInstance);
         
         return map;
    }
	
    public Map<Object,Map<Object,Object>> multiMapping(Map<Object, Map<Object, Object>> map, int setId, Map<Object,Object> anotherMap) throws ManualException {
    	
    	helper.mapNullCheck(map);
    	
    	helper.mapNullCheck(anotherMap);
    	
    	map.put(setId, anotherMap);
    	
    	
    	return map;
    }
    
	public int autoCustId() {
		
		return custIdGenerator++;
		
	}
	
	public int autoAccId() {
		
		return accIdGenerator++;
		
	}
    
	public int detectCustId(Map<Object, Object> map,int detectId) throws ManualException {
		
		helper.mapNullCheck(map);
		
		if(map.containsKey(detectId)){
			
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
