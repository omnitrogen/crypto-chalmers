import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class FiatShamir {

	public static class ProtocolRun {
		public final BigInteger R;
		public final int c;
		public final BigInteger s;

		public ProtocolRun(BigInteger R, int c, BigInteger s) {
			this.R = R;
			this.c = c;
			this.s = s;
		}
	}

	public static void main(String[] args) {
		String filename = "input.txt";
		BigInteger N = BigInteger.ZERO;
		BigInteger X = BigInteger.ZERO;
		ProtocolRun[] runs = new ProtocolRun[10];
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			N = new BigInteger(br.readLine().split("=")[1]);
			X = new BigInteger(br.readLine().split("=")[1]);
			for (int i = 0; i < 10; i++) {
				String line = br.readLine();
				String[] elem = line.split(",");
				runs[i] = new ProtocolRun(
						new BigInteger(elem[0].split("=")[1]),
						Integer.parseInt(elem[1].split("=")[1]),
						new BigInteger(elem[2].split("=")[1]));
			}
			br.close();
		} catch (Exception err) {
			System.err.println("Error handling file.");
			err.printStackTrace();
			System.exit(1);
		}
		BigInteger m = recoverSecret(N, X, runs);
		System.out.println("Recovered message: " + m);
		System.out.println("Decoded text: " + decodeMessage(m));
	}

	public static String decodeMessage(BigInteger m) {
		return new String(m.toByteArray());
	}

	/**
	 * Recovers the secret used in this collection of Fiat-Shamir protocol runs.
	 * 
	 * @param N
	 *            The modulus
	 * @param X
	 *            The public component
	 * @param runs
	 *            Ten runs of the protocol.
	 * @return x
     *            The secret key
	 */
	private static BigInteger recoverSecret(BigInteger N, BigInteger X, ProtocolRun[] runs) {
        for (int i = 0; ++i < 10;) {
            for (int j = 0; ++j < 10;) {
                BigInteger x = runs[i].s.multiply(runs[j].s.modInverse(N));
                if (X.equals(x.modPow(new BigInteger("2"), N))) return x.mod(N);
            }
        }
        return BigInteger.ZERO;
	}
}