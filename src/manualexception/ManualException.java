
package manualexception;



public class ManualException extends Exception {

	public ManualException(String e) {
		super(e);
	}
	
	public ManualException(Exception e) {
		super(e);
	}
}