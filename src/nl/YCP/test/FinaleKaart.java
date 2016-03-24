package nl.YCP.test;

public class FinaleKaart extends Kaart {
	public FinaleKaart (boolean even) {
		super(even);
	}
	
	@Override
	public Kaart streepBeginWeg () {
		System.out.println("En er worden er 16 weggestreept!");
		actieveKaart[0][0] = actieveKaart[0][2] = actieveKaart[0][4] = actieveKaart[1][1] =
		actieveKaart[1][2] = actieveKaart[1][3] = actieveKaart[2][0] = actieveKaart[2][1] = 
		actieveKaart[2][3] = actieveKaart[2][4] = actieveKaart[3][1] = actieveKaart[3][2] =
		actieveKaart[3][3] = actieveKaart[4][0] = actieveKaart[4][2] = actieveKaart[4][4] = 0;
		return this;
	}
}
