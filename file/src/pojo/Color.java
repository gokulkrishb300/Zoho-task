package pojo;

import input.InputCenter;
import manualexception.ManualException;

public enum Color {
//VIOLET(1) , INDIGO(2) , BLUE(3) , GREEN(4), YELLOW(5), ORANGE(6), RED(7)
	VIOLET, INDIGO, BLUE, GREEN, YELLOW, ORANGE, RED;
	public int getColorCode() {
		return ordinal()+1;
	}
}

class ColorName {
	public static void main(String[] args) throws ManualException{
		InputCenter input = new InputCenter();
		String color =input.getString("Enter color name: ").toUpperCase();
		try {
			Color colorCall = Color.valueOf(color);
		} catch(Exception e) {
			System.out.println("Invalid Color Code");
			System.exit(0);
		}
		Color colorCall = Color.valueOf(color);
		
		switch(colorCall) {
		case VIOLET :
			System.out.println("Color code of " + color + "is "+ colorCall.getColorCode());
			break;
		case INDIGO :
			System.out.println("Color code of " + color + "is "+ colorCall.getColorCode());
			break;
		case BLUE :
			System.out.println("Color code of " + color + "is "+ colorCall.getColorCode());
			break;
		case GREEN :
			System.out.println("Color code of " + color + "is "+ colorCall.getColorCode());
			break;
		case YELLOW :
			System.out.println("Color code of " + color + "is " + colorCall.getColorCode());
			break;
		case ORANGE :
			System.out.println("Color code of " + color + "is " + colorCall.getColorCode());
			break;
		case RED :
			System.out.println("Color code of " + color + "is " + colorCall.getColorCode());
			break;
		default:
			System.out.println("Invalid color code");
			break;
		}
	}
}
