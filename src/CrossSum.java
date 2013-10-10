import java.util.Scanner;


public class CrossSum {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		String n = console.nextLine();
		
		System.out.println(crossSum(n));
		
		/*System.out.println(reducedCrossSum(crossSum(n)));*/
		
		console.close();
	}

	public static int crossSum(int n) {
		int sum = 0;
		
			while(n > 0) {
				sum += n%10;
				
				n/=10;
			}
		
		return sum;
	}
		
	public static int reducedCrossSum(int n) {
		int sum = n;
		
		while(sum > 9) {
			sum = crossSum(sum);
		}
		
		return sum;
	}
		
	public static int crossSum(String number) {
		int sum = 0;
		int numberInt = Integer.parseInt(number);

		sum = crossSum(numberInt);
		
		return sum;
	}
}
