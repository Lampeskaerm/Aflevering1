package Aflevering1;

import java.util.Scanner;

public class Automaton {
	
	public static void main(String[] args) {
		char b = '\0';
		String a = null;
		String n = null;
		int sum = 0;
		
		Scanner console = new Scanner(System.in);
		
		int max_coins = 20;
		int max_orders = 10;
		
		outerloop: for(int i = 0; i < max_orders; i++) {
			sum = 0;
			a = null;

			a = console.next();
			
			boolean q = isChar(a);
			
			if(q == true) {
				b = a.charAt(0);
				if(b != 'W' && b != 'C' && b != 'J') {
					System.out.println("ERROR");
					break outerloop;
				}
			} else if (q == false && a.equals("TERMINATE")) {
				System.out.println("DONE");
				break outerloop;
			}
				
			n = console.next();
			
			boolean p = isInteger(n);

			for(int j = 0; j < max_coins; j++) {
				if(p == true) {
					int o = Integer.parseInt(n);
					if(o == 1 || o == 2 || o == 5 || o == 10 || o == 20){
						sum += o;
						n = console.next();
						p = isInteger(n);
					}
				} else if(p != true && n.equals("SELECT")) {
					vendingMachine(b, sum);
					break;
				} else if(p != true && n.equals("TERMINATE")){
					vendingMachine(b, sum);
					System.out.println("DONE");
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
	
	public static boolean isChar(String a) {
		int n = a.length();
		
		if(n == 1 /*&& (a.charAt(0) == 'C' || a.charAt(0) == 'J' || a.charAt(0) == 'W')*/) {
			return true; 
		} else {
			return false;
		}
	}

}
