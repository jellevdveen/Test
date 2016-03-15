package nl.YCP.test;

public class Pyramid {
	private static int[] higherLayer(int[] bottomlayer, int[] toplayer) {
		int[] returnLayer = new int[toplayer.length];
		for (int i = bottomlayer.length - 2; i >= 0; i--) {
			returnLayer[i] = toplayer[i] + Math.max(bottomlayer[i], bottomlayer[i+1]);
		}
		return returnLayer;
	}
	
	
	public static void main(String[] args) {

		int[][] b = {{75},
		     		{95, 64},
		     		{17, 47, 82},
		     		{18, 35, 87, 10}};
		
		boolean[][] path = new boolean[b.length - 1][];
		int[][] testArray = new int[b.length][];
		
		testArray[b.length - 1] = b[b.length -1].clone();
		
		for (int i = 0; i < path.length; i++) {
			path[i] = new boolean[i+1];
		}
			
		
		for (int i = b.length - 1 ; i >= 0; i--) {
			for (int j = b[i].length - 2; j >= 0; j--){
				path[i - 1][j] = (testArray[i][j + 1] > testArray[i][j]);
				testArray[i-1] = higherLayer(testArray[i], b[i-1]);
			}
		}
		
		System.out.println(testArray[0][0]);
		
		int xcounter = 0;
		for (int i = 0; i < b.length; i++){
			System.out.println(b[i][xcounter]);
			if ((i < path.length) && (path[i][xcounter])) {
				xcounter++;				
			}
		}
		
		
	}
}
