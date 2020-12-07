// Compilation (CryptoLibTest contains the main-method):
//   javac CryptoLibTest.java
// Running:
//   java CryptoLibTest

public class CryptoLib {

	/**
	 * Returns an array "result" with the values "result[0] = gcd",
	 * "result[1] = s" and "result[2] = t" such that "gcd" is the greatest
	 * common divisor of "a" and "b", and "gcd = a * s + b * t".
	 **/
	public static int[] EEA(int a, int b) {
		int s1 = 0, s2 = 1, r1 = b, r2 = a, q, r_tmp, s_tmp;
		if (a == b) return new int[]{a, 1, 0};
		while (r1 > 0) {
			q =  r2 / r1;
			r_tmp = r2; r2 = r1; r1 = r_tmp - q * r1;
			s_tmp = s2; s2 = s1; s1 = s_tmp - q * s1;
		}
		return new int[]{r2, s2, (r2 - a * s2) / b};
	}

	/**
	 * Returns Euler's Totient for value "n".
	 **/
	public static int EulerPhi(int n) {
		int total = 0;
		for (int i = 0; i < n; i ++) if (EEA(i, n)[0] == 1) total ++;
		return total;
	}

	/**
	 * Returns the value "v" such that "n*v = 1 (mod m)". Returns 0 if the
	 * modular inverse does not exist.
	 **/
	public static int ModInv(int n, int m) {
		while (n<0) n += m;
		int[] eea = EEA(n,m);
		if (eea[0] == 1) return eea[1] > 0 ? eea[1] : m + eea[1];
		return 0;
	}

	/**
	 * Returns the a^b (mod m) for big number
	 **/
	public static int ModularExponantiation(int a, int b, int m) {
		int res = 1;
		for (int i = 0; i < b; i++) {
			res *= a;
			res %= m;
		}
		return res;
	}

	/**
	 * Returns 0 if "n" is a Fermat Prime, otherwise it returns the lowest
	 * Fermat Witness. Tests values from 2 (inclusive) to "n/3" (exclusive).
	 **/
	public static int FermatPT(int n) {
		for (int i = 2; i < n / 3; i ++)
			if (ModularExponantiation(i, n-1, n) != 1) return i;
		return 0;
	}

	/**
	 * Returns the probability that calling a perfect hash function with
	 * "n_samples" (uniformly distributed) will give one collision (i.e. that
	 * two samples result in the same hash) -- where "size" is the number of
	 * different output values the hash function can produce.
	 **/
	public static double HashCP(double n_samples, double size) {
		double prob = 1;
		for (double i = size - (n_samples - 1); i <= (size - 1); i ++) prob *= (i / size);
		return 1 - prob;
	}

}
