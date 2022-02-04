package runner;

import pojo.PojoEx;

import input.InputCenter;

import manualexception.ManualException;

public class PojoExOutput {

	public static void main(String[] args) throws ManualException{
		InputCenter input = new InputCenter();
		int caseNum = input.getInt("case :");
		switch(caseNum) {
		case 6:
		try {
			String name = input.getString("Student Name: ");
		         int id = input.getInt("Student Id: ");
			PojoEx pojoCall = new PojoEx(name,id);
			System.out.println(pojoCall);
		}catch(Exception e) {
			throw new ManualException(e);
		}
		break;
		case 7:
		try {
			String name = input.getString("Student Name: ");
			int id = input.getInt("Student Id: ");
			PojoEx pojoCall = new PojoEx(name,id);
			pojoCall.setStudentId(id);
			pojoCall.setStudentName(name);
			System.out.println("Name: "+ pojoCall.getStudentName());
			System.out.println("Id: "+ pojoCall.getStudentId());
		}catch(Exception e) {
			throw new ManualException(e);
		}
		break;
		default:
			System.out.println("no more cases");
}
}
}