package taskonerunner;

import input.InputCenter;
import taskone.TaskOne;

public class TaskOneRunner {
	
public static void main(String[] args) {
	InputCenter input = new InputCenter();
	TaskOne run = new TaskOne();
	
	int caseNum = input.getInt("task number: ");
	
	switch(caseNum) {
	
	case 1:
	{
		String inputString = input.getString("Type String: ");
	     run.middlePattern(inputString);
	}
	     break;
	     
	case 2:
	{
		String inputString = input.getString("String without space: ");
		char charInput = input.getChar("search char: ");
		int count = input.getInt("at count: ");
		System.out.println(run.remainingString(inputString, charInput, count));
		break;
	}
	
	case 3:
	{
		String inputString = input.getString("str: ");
		run.totalDecoding(inputString);
		break;
	}
	default:
		System.out.println("-Invalid task number-");
		break;
	}
	
}
}
