package nl.YCP.test2;

public class Samsung extends MobilePhone implements USBCharger {
	
	
	protected String getOS() {
		return "android";
	}
	
	
	public void charge() {
		System.out.println("Charging my Samsung");
	}

}
