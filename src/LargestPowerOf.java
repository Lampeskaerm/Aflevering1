import java.util.Scanner;


public class LargestPowerOf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		int b = console.nextInt();
		int n = console.nextInt();
		
		largestPowerOf(b,n);
		
		console.close();
	}
	
	public static int largestPowerOf(int b, int n) {
		int exponent = 0;
		for (int i = 0; i < n; i++){
			if(b > n) {
				exponent = 0;
				break;
			} else if(Math.pow(b, i) <= n) {
				continue;
			} else {
				exponent = i-1;
				break;
			}
		}
		return exponent;
	}

}
