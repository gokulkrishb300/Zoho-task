import accountdeclare.User;
import cache.CacheLayer;
import logic.BussinessLayer;
import logic.DBLogic;
import manualexception.ManualException;
public class Dummy 
{
	public static void main(String[] args) 
	{
		DBLogic db=new DBLogic();
		
		CacheLayer cache = new CacheLayer();
		
		BussinessLayer bus = new BussinessLayer(true);
		
		try {
			
			bus.setAccountState(1,1, true);
		
			
		} catch (ManualException e) {
		
			e.printStackTrace();
		}
		
	}
}
