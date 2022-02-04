package runner;

import input.InputCenter;

import manualexception.ManualException;

import input.InputCenter;

import inheritmethod.*;

public class InheritanceRunner {

	InputCenter input = new InputCenter();
	
	public void swiftCase() throws ManualException{
		try {
			Swift swiftCall = new Swift();
			
			
			swiftCall.setSeats(input.getInt("Enter seats: "));
		
			swiftCall.setAirbags(input.getInt("Enter airbags: "));
			
			swiftCall.setModel(input.getString("Enter model: "));
			
			swiftCall.setColor(input.getString("Enter color: "));
			
			System.out.println("Seats: " + swiftCall.getSeats());
			
			System.out.println("Airbags: " + swiftCall.getAirbags());
			
			System.out.println("Model: " + swiftCall.getModel());
			
			System.out.println("Color: " + swiftCall.getColor());
		} catch(Exception e) {
			throw new ManualException(e);
		}
	}
	
	public void SCrossCase() throws ManualException {
		try {
			SCross scrossCall = new SCross();
			scrossCall.setSeats(input.getInt("Enter seats: "));
			scrossCall.setAirbags(input.getInt("Enter Airbags: "));
			scrossCall.setModel(input.getString("Enter model: "));
			scrossCall.setColor(input.getString("Enter color: "));
			scrossCall.setYearOfMake(input.getInt("Enter yearOfMake: "));
			scrossCall.setEngineNum(input.getString("Enter engineNum: "));
			scrossCall.setVehicleType(input.getString("Enter type: "));
			
			System.out.println("Seats: " + scrossCall.getSeats());
			System.out.println("Airbags: " + scrossCall.getAirbags());
			System.out.println("Model: " + scrossCall.getModel());
			System.out.println("Color: " + scrossCall.getColor());
			System.out.println("YearOfMake: " + scrossCall.getYearOfMake());
			System.out.println("EngineNumber: " + scrossCall.getEngineNum());
			System.out.println("Type: " + scrossCall.getVehicleType());
			
		} catch(Exception e) {
			throw new ManualException(e);
		}
	}
	public void invoke(Car carCall) {
		System.out.println("Welcome");
	}
	
	public void identify(Car carCall) {
		if(carCall instanceof Swift) {
			System.out.println("Hatch");
		}
		if(carCall instanceof XUV) {
			System.out.println("SUV");
		}
		if(carCall instanceof SCross) {
			System.out.println("Sedan");
		}
	}
	
	public void invokeSwift(Swift swiftCall) {
		System.out.println("Welcome Swift");
	}
	
	public static void main(String[] args) throws ManualException {
		
	
		InputCenter input = new InputCenter();
		
		InheritanceRunner run = new InheritanceRunner();
		
		int dial = input.getInt("Enter dial: ");
		
		switch(dial) {
		
case 1:
			try {
			run.swiftCase();
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
case 2:
	        try {
	        	run.SCrossCase();
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }
	        break;
case 3: 
{
	       Car carCall = new Car();
	       Car carCall1 = new Car();
	       Swift swiftCall = new Swift();
	       run.identify(swiftCall);
	       break;
}
case 4:
{
	      Swift swiftCall = new Swift();
	      Car carCall = new Car();
	      XUV xuvCall = new XUV();
	      SCross scrossCall = new SCross();
	      run.identify(scrossCall);
	      break;
}
case 5:
{
		Car carCall=new Swift();
		Car carCall1=new Car();
		XUV xuvCall=new XUV();
		SCross scrossCall=new SCross();
		Swift swiftCall=new Swift();
		run.invokeSwift(swiftCall);
		break;
}
case 6:
{
		SCross scrossCall=new SCross();
		scrossCall.maintainance();
		Car carCall=new SCross();
		carCall.maintainance();
		Car carCall1=new Car();
		carCall1.maintainance();
		Swift swiftCall=new Swift();
		swiftCall.maintainance();
		break;
}
case 7:
{
	XUV xuvCall = new XUV();
	//XUV xuvCall = new Car();
	break;
}

case 8:
{
	//BirdAbstract birdAbstract = new BirdAbstract();
	ParrotMod parrotCall = new ParrotMod();
	parrotCall.fly();
	parrotCall.speak();
	break;
}

case 9:
{
	Duck duckCall = new Duck();
	duckCall.fly();
	duckCall.speak();
	break;
}
}
		
}
}
