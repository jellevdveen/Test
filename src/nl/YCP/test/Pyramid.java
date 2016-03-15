package nl.YCP.test;

public class Pyramid {
	public static void main(String[] args) {

		int[][] b = {{75},
		     		{95, 64},
		     		{17, 47, 82},
		     		{18, 35, 87, 10}};
		
		int[][] c = b.clone(); 
		
		for (int i = b.length - 1 ; i >= 0; i--) {
			for (int j = b[i].length - 2; j >= 0; j--){
				b[i-1][j] += Math.max(b[i][j], b[i][j+1]);
			}
		}
		System.out.println(b[0][0]);
		
		int xcounter = 0;
		
		System.out.println(c[0][0]);
		for (int i = 1; i < b.length; i++) {
			if (b[i][xcounter] > b[i][xcounter + 1]) {
				System.out.println(c[i][xcounter]);
			} else {
				System.out.println(c[i][xcounter + 1]);
				xcounter++;
			}
		}
	}
}
