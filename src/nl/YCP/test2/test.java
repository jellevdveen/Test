package nl.YCP.test2;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<MobilePhone> lijstje = new ArrayList<>(5);
		
		lijstje.add(new Apple());
		lijstje.add(new Samsung());
		lijstje.add(new Samsung());
		lijstje.add(new Apple());
		lijstje.add(new Huawei());

		
		for (MobilePhone telefoon: lijstje) {
			System.out.println(telefoon.getOS());
			
			if (telefoon instanceof USBCharger) {
				((USBCharger) telefoon).charge();
			}
		}
	}

}
