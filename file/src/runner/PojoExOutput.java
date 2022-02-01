package runner;

import pojo.PojoEx;

import input.InputCenter;

import manualexception.ManualException;

public class PojoExOutput {

	public static void main(String[] args) throws ManualException{
		InputCenter input = new InputCenter();
		try {
		String name = input.getString("Student Name: ");
		int id = input.getInt("Student Id: ");
		PojoEx pojoCall = new PojoEx(name,id);
		System.out.println(pojoCall);
		pojoCall.setStudentId(id);
		pojoCall.setStudentName(name);
		System.out.println("Name: "+ pojoCall.getStudentName());
		System.out.println("Id: "+ pojoCall.getStudentId());
		}catch(Exception e) {
			throw new ManualException(e);
		}
	}
}
