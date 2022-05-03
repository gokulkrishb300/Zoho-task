package manualexception;

public class ManualException extends Exception {


	private static final long serialVersionUID = 1L;
	public ManualException(String e) {
		super(e);
	}
	public ManualException(Exception e) {
		super(e);
	}
}
