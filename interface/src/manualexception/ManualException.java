package manualexception;

public class ManualException extends Exception {

	public ManualException(String message) {
		super(message);
	}
	
	public ManualException(Exception exception) {
		super(exception);
	}
}
