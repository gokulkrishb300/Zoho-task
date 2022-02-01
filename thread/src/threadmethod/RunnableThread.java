package threadmethod;
import input.InputCenter;
public class RunnableThread implements Runnable{
	InputCenter input = new InputCenter();
	
	private long sleep;
	
	public long getSleep() {
		return sleep;
	}

	public void setSleep(long sleep) {
		this.sleep = sleep;
	}
    
	public void run() {
	System.out.println("Current thread name : " + Thread.currentThread().getName());
	System.out.println("Current Priority    : " + Thread.currentThread().getPriority());
	System.out.println("Current State       : "+ Thread.currentThread().getState());
	System.out.println("Going to Sleep      : " + Thread.currentThread().getName());
    try {
    	Thread.sleep(sleep);
    } catch(InterruptedException e) {
    	System.out.println("Interruption Occured");
    }
    System.out.println("After Sleeping      : " + Thread.currentThread().getName());

}
}
