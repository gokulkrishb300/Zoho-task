
package helper;

import manualexception.ManualException;
import accountdeclare.AccountDetails;
import accountdeclare.CustomerDetails;

public class Helper {
public void customerNullCheck(CustomerDetails info) throws ManualException{
	if(info == null) {
		throw new ManualException("customer info has null details");
	}
}

public void accountNullCheck(AccountDetails info) throws ManualException{
	if(info==null) {
		throw new ManualException("account info has null detail");
	}
}
}