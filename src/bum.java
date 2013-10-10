import java.util.Scanner;

public class bum {

	public static void main(String[] args) {

		Scanner konsol = new Scanner(System.in);

		int n;

		System.out.print("Skriv et positivt tal: ");

		n = konsol.nextInt();
		crossSum(n);

		System.out.println("Tværsummen af tallet er: " + crossSum(n));

		int o = reducedCrossSum(crossSum(n));

		System.out.println("Den reducerede tværsum af " + crossSum(n) + " er: "
				+ reducedCrossSum1(n));


/*
Det er den her jeg brugte til at få det rigtige resultat
		System.out.println("Den reducerede tværsum af " + crossSum(n) + " er: "
				+ reducedCrossSum(o));
*/
		konsol.close();
	}

	public static int crossSum(int n) {
		int sum = 0;
		if (n <= 0)
			System.out.println("Tal du har indtastet er ikke positivt");
		else {
			while (n != 0) {
				sum += n % 10;
				n /= 10;
			}
		}
		return sum;
	}

	// Jeg tror det er sådan her det skal se ud. Bare at køre crosssum så længe at der er 2 eller mere cifre
	public static int reducedCrossSum1(int n) {
		int sum = 0;
		while (n > 9) {
			crossSum(n);
		}
		return n;
	}

	public static int reducedCrossSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}

}
