package runner;
import input.InputCenter;
import threadmethod.ExtendedThread;
import threadmethod.RunnableThread;
import input.InputCenter;
public class Spawn{
	InputCenter input = new InputCenter();
	ExtendedThread extendedThread = new ExtendedThread();
	RunnableThread runnableThread = new RunnableThread();
	
	
	private void threadStatus(String when,Thread thread) {
		System.out.println(when+ thread.currentThread().getName()+" "+thread.currentThread().getPriority()+" "+thread.currentThread().getState());
	}
	
	private void caseOne() {
	Thread threadObj = new Thread(extendedThread);
		
        threadStatus("Before Calling      : ",threadObj);
        extendedThread.start();
       threadStatus("After Calling       : ",threadObj);
//		System.out.println(Thread.currentThread().getName());
//		extendedThread.start();
	}
	
	private void caseTwo() {
		Thread threadObj = new Thread(runnableThread);
		threadStatus("Before Calling      : ", threadObj);
		threadObj.start();
		threadStatus("After Calling       : ", threadObj);
	}
	
	private void caseThree() {
		{
		Thread exThread = new Thread(extendedThread);
		String setString = input.getString("Extended Thread Name: ");
		exThread.setName(setString);
		threadStatus("Before Calling      : ", exThread);
		exThread.start();
		threadStatus("After Calling       : ", exThread);
		}
		{
		Thread runThread = new Thread(runnableThread);
		String setString = input.getString("Runnable Thread Name: ");
		runThread.setName(setString);
		threadStatus("Before Calling      : ", runThread);
		runThread.start();
		threadStatus("After Calling       : ", runThread);
		}
	}
	
	private void caseFour() {
		int noOfExThreads = input.getInt("How many Extended Threads : ");
		
		for(int i = 0 ; i < noOfExThreads ; i++) {
		   Thread exThread = new Thread(extendedThread);
		   exThread.setName(i+"th  Extended Thread");
		   extendedThread.setSleep(input.getLong(i+"th sleep time: "));
		   exThread.start();
		   
		   System.out.println("---------"+i+"--------");
		}
		
		int noOfRunThreads = input.getInt("How many Runnable Threads : ");
		
		for(int i = 0 ; i < noOfRunThreads ; i++) {
			Thread runThread = new Thread(runnableThread);
			runThread.setName(i+"th  Runnable Thread");
			runnableThread.setSleep(input.getLong(i+"th sleep time: "));
			runThread.start();
			
			System.out.println("---------"+i+"--------");
		}
	}
	
public static void main(String[] args) {

Spawn spawn = new Spawn();

InputCenter input = new InputCenter();

int caseNum = input.getInt("case number: ");

switch(caseNum) {
      case 1:
           spawn.caseOne();
           break;
           
      case 2:
    	  spawn.caseTwo();
    	  break;
    	  
      case 3:
    	  spawn.caseThree();
    	  break;
      
      case 4:
    	  spawn.caseFour();
    	  break;
    	  
      default:
    	  System.out.println("No case there");
    	  break;
    	  
      
  }
 }
}