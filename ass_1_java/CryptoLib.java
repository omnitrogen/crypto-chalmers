// Compilation (CryptoLibTest contains the main-method):
//   javac CryptoLibTest.java
// Running:
//   java CryptoLibTest

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CryptoLib {

	public static void main(String[] args) {
		int[] eea_res = EEA(1, 2);

		List<Integer> res = Arrays.stream(eea_res).boxed().collect(Collectors.toList());		
		System.out.println(res);

		System.out.println(Gcd(9, 2));

		System.out.println(EulerPhi(9));
	}

	/**
	 * Returns an array "result" with the values "result[0] = gcd",
	 * "result[1] = s" and "result[2] = t" such that "gcd" is the greatest
	 * common divisor of "a" and "b", and "gcd = a * s + b * t".
	 **/
	public static int[] EEA(int a, int b) {
		// Note: as you can see in the test suite,
		// your function should work for any (positive) value of a and b.
		int gcd = -1;
		int s = -1;
		int t = -1;
		int[] result = new int[3];
		result[0] = gcd;
		result[1] = s;
		result[2] = t;
		return result;
	}

	/**
	 * Returns the Greatest Common Divisor between given a and b.
	 **/
	public static int Gcd(int a, int b) {
		if (b == 0) return a;
		else return Gcd(b, a % b);
	}

	/**
	 * Returns Euler's Totient for value "n".
	 **/
	public static int EulerPhi(int n) {
		int total = 0;
		for (int i = 0; i < n; i ++) if (Gcd(i, n) == 1) total ++;
		return total;
	}

	/**
	 * Returns the value "v" such that "n*v = 1 (mod m)". Returns 0 if the
	 * modular inverse does not exist.
	 **/
	public static int ModInv(int n, int m) {
		return -1;
	}

	/**
	 * Returns 0 if "n" is a Fermat Prime, otherwise it returns the lowest
	 * Fermat Witness. Tests values from 2 (inclusive) to "n/3" (exclusive).
	 **/
	public static int FermatPT(int n) {
		return -1;
	}

	/**
	 * Returns the probability that calling a perfect hash function with
	 * "n_samples" (uniformly distributed) will give one collision (i.e. that
	 * two samples result in the same hash) -- where "size" is the number of
	 * different output values the hash function can produce.
	 **/
	public static double HashCP(double n_samples, double size) {
		return -1;
	}

}
