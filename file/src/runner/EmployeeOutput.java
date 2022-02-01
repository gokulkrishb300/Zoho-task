package runner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import input.InputCenter;


public class EmployeeOutput {
public static void main(String[] args) throws Exception {
	
	InputCenter input = new InputCenter();
	try {
		String name = input.getString("Enter employee name: ");
		int id = input.getInt("Enter Employee ID: ");
		
		Class<?> objClass = Class.forName("pojo.Employee");
		Object stored = objClass.getDeclaredConstructor().newInstance();
		Constructor<?> constr = objClass.getDeclaredConstructor(String.class, int.class);
		
		Object stored1 = constr.newInstance(name,id);
		System.out.println(stored1);
		
		Method[] conCall = objClass.getDeclaredMethods();
		for(Method dummy: conCall) {
			System.out.println(dummy);
		}
		String name1 = input.getString("Enter Employee name: ");
		
		int id1 = input.getInt("Enter Employee ID: ");
		
		conCall[2].invoke(stored,name1);
		System.out.println(conCall[1].invoke(stored));
		
		conCall[4].invoke(stored, id1);
		System.out.println(conCall[3].invoke(stored));
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
