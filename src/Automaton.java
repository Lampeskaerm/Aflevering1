import java.util.Scanner;


public class Automaton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		
		Scanner console = new Scanner(System.in);
		
		int[] Payment = new int[20];
		
		char[] a = new char[20];
		String[][] n = new String[20][20];
		
		
		for(int j = 0; j < a.length; j++) {
			a[j] = console.next().charAt(0);
			
			boolean p = isInteger(n[j][0]);
			
			outerloop:
			for(int i = 1; i < Payment.length; i++){

				n[j][i] = console.next();
				if(p == true) {
					int o = Integer.parseInt(n[j][i]);
					if(o == 1 || o == 2 || o == 5 || o == 10 || o == 20){
						Payment[i] = o;
					}
					n[j][i] = console.next();
					p = isInteger(n[j][i]);
				} else if (p != true && n[j][i] == "SELECT"){
					for(int k = 0; k < Payment.length; k++) {
						sum += Payment[k];
					}
					break;
				} else if (p != true && n[j][i] == "TERMINATE"){
					System.out.println(sum);
					System.out.println("Done");
					break outerloop;
				}
			}
		}	
		
//		vendingMachine(a, sum);
		
//		vendingMachine('W', 20);
//		vendingMachine('J', 10);
//		vendingMachine('C', 12);
		
		console.close();

	}
	
	public static void vendingMachine(char a, int n){
		int price = 0;
		
		if(a == 'w' || a == 'W') {
			price = 10;
			checkPayment(price, n, a);
			
		} else if (a == 'j' || a == 'J') {
			price = 15;
			checkPayment(price, n, a);
			
		} else if ( a == 'c' || a == 'C') {
			price = 12;
			checkPayment(price, n, a);
			
		} else {
			System.out.println("Wrong input");
		}
	}
	
	public static void checkPayment(int price, int n, char a) {
		if(n == price) {
			System.out.println(a + " Paid " + n + " thanks");
		} else if (n > price) {
			System.out.println(a + " Paid " + n + " change is " + (n - price));
		} else {
			System.out.println(a + " Not paid enough. Return " + n);
		}
	}
	
	public static boolean isInteger(String n) {
		try {
			Integer.parseInt(n);
		} catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}

}
