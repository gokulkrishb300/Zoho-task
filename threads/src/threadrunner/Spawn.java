package threadrunner;

import java.util.*;
import threadmethod.*;
import input.*;
import manualexception.ManualException;

public class Spawn {
RunnableThread runCall = new RunnableThread();
ExtendedThread threadCall = new ExtendedThread();
InputCenter input = new InputCenter();
private void currentThread() {
	System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority()+" "+Thread.currentThread().getState());
}

synchronized public void threadName() {
	currentThread();
	threadCall.start();
	currentThread();
}

public void implementThread() {
	currentThread();
	Thread threadCall = new Thread(runCall);
	threadCall.start();
	currentThread();
}
public void setName(String inputString1, String inputString2) {
	currentThread();
	threadCall.setName(inputString1);
	threadCall.start();
	currentThread();
	Thread runThreadCall = new Thread(runCall);
	currentThread();
	runThreadCall.setName(inputString1);
	runThreadCall.start();
	currentThread();
}

public void sleepExtended() throws ManualException {
	int length = input.getInt("How many threads: ");
	for(int i = 0 ; i < length ; i++) {
		Thread objThread = new ExtendedThread();
		String name = input.getString("Enter Thread Name: ");
		objThread.setName(name);
		objThread.start();
	}
}

public void sleepRunnable() throws ManualException {
	int length = input.getInt("How many threads: ");
	for(int i = 0 ; i < length; i++) {
		Thread objThread = new Thread(runCall);
	String name = input.getString("Enter thread name: ");
	objThread.setName(name);
	objThread.start();
	}
}

public void argExtended() throws ManualException {
	int length = input.getInt("how many threads: ");
	for(int i = 0; i < length; i++) {
		long sleep = input.getLong("Enter sleep time: ");
		Thread objThread = new ExtendedThread(sleep);
		String name = input.getString("Enter thread name: ");
		objThread.setName(name);
		objThread.start();
	}	
}

public void argRunnable() throws ManualException {
	int length = input.getInt("How many threads: ");
	for(int i = 0 ; i < length ; i++) {
		RunnableThread runCall = new RunnableThread(8000);
		Thread objThread = new Thread(runCall);
		objThread.start();
	}
}

public void dumpExtended() throws ManualException {
	int length = input.getInt("How many thread: ");
	for(int i = 0 ; i < length; i++) {
		Thread objThread = new ExtendedThread(8000);
		objThread.start();
	}	
}

public void dumpRunnable() throws ManualException {
	int length = input.getInt("How many thread: ");
	for(int i = 0; i < length; i++) {
		long sleep = input.getLong("Enter sleep time: ");
		RunnableThread runCall = new RunnableThread(sleep);
		Thread objThread = new Thread(runCall);
		String name = input.getString("Enter Thread name: ");
		objThread.setName(name);
		objThread.start();
	}
}

public void dumpMulExtended() throws ManualException {
	int length = input.getInt("how many threads: ");
	List<ExtendedThread> threadCall = new ArrayList<ExtendedThread>(length);
	for(int i = 0; i < length; i++) {
		threadCall.add(i, new ExtendedThread(10000));
		threadCall.get(i).setName("ExtendedThread "+i);
		threadCall.get(i).start();
	}
	try {
		Thread.sleep(8000);
	} catch(InterruptedException e) { }
	
	for(int i = 0 ; i < length; i++) {
		threadCall.get(i).stopThread();
	}
	
}
public void dumpMulRunnable() throws ManualException {
	int length = input.getInt("How many thread: ");
	List<RunnableThread> arrayCall = new ArrayList<RunnableThread>(length);
	List<Thread> threadCall = new ArrayList<Thread>(length);
	for(int i = 0 ; i < length; i++) {
		arrayCall.add(i,new RunnableThread(10000));
		threadCall.add(i, new Thread(arrayCall.get(i),"RunnableThread "+i));
		threadCall.get(i).start();
	}
	try {
		Thread.sleep(8000);
	} catch(InterruptedException e) { }
	
	for(int i = 0 ; i < length; i++) {
		arrayCall.get(i).stopThread();
	}
}
public static void main(String[] args) throws ManualException {
	InputCenter input = new InputCenter();
	Spawn run = new Spawn();
	int dial = input.getInt("Enter Dial: ");
	switch(dial) {
	case 1:
		run.threadName();
		break;
	case 2:
		run.implementThread();
		break;
	case 3:
		String name = input.getString("Enter extendedThread setName: ");
		String name1 = input.getString("Enter runnableThread setName: ");
		run.setName(name, name1);
		break;
	case 4:
		run.sleepExtended();
		run.sleepRunnable();
		break;
	case 5:
		run.argExtended();
		run.argRunnable();
		break;
	case 6:
		run.dumpExtended();
		break;
	case 7:
		run.dumpRunnable();
		break;
	case 8:
		run.dumpMulExtended();
		break;
	case 9:
		run.dumpMulRunnable();
		break;
	}
}
}
