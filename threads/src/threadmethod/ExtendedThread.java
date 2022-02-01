package threadmethod;

public class ExtendedThread extends Thread {
private boolean flag = false;
public ExtendedThread() { }
public void stopThread() {
	flag = true;
}

private long sleep;
public ExtendedThread(long sleep) {
	this.sleep = sleep;
}
public void run() {
	while(!flag) {
		System.out.println("Thread Name: " + this.getName());
		System.out.println("Thread Priority: " + this.getPriority());
		System.out.println("Thread state: " + this.getState());
		try {
			System.out.println("Before going to sleep " + this.getName());
			Thread.sleep(sleep);
			System.out.println("After going to sleep " + this.getName());
		} catch(InterruptedException e) {}
	}
	System.out.println("Thread stopped");
}
}
