package nl.YCP.test2;



public class DatIsGeenWeekdag extends Exception {
	public DatIsGeenWeekdag(int getal) throws DatIsGeenWeekdag {
		if (getal < 10) {
			System.out.println((getal));
			throw new DatIsGeenWeekdag(getal + 1);
		}
	}
	

}
