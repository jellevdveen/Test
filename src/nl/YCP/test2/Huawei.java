package nl.YCP.test2;

public class Huawei extends MobilePhone implements USBCharger {

	
	protected String getOS() {
		return "android";
	}
	
	public void charge() {
		System.out.println("Charging my Huawei");
	}
}
