import java.io.BufferedReader;
import java.io.FileReader;

import javax.xml.bind.DatatypeConverter;

public class CBCXor {

	public static void main(String[] args) {
		String filename = "input.txt";
		byte[] first_block = null;
		byte[] encrypted = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			first_block = br.readLine().getBytes();
			encrypted = DatatypeConverter.parseHexBinary(br.readLine());
			br.close();
		} catch (Exception err) {
			System.err.println("Error handling file.");
			err.printStackTrace();
			System.exit(1);
		}
		String m = recoverMessage(first_block, encrypted);
		System.out.println("Recovered message: " + m);
	}

	/**
	 * Recover the encrypted message (CBC encrypted with XOR, block size = 12).
	 * 
	 * @param first_block
	 *            We know that this is the value of the first block of plain
	 *            text.
	 * @param encrypted
	 *            The encrypted text, of the form IV | C0 | C1 | ... where each
	 *            block is 12 bytes long.
	 * @return message
	 * 			  The original message.
	 */
	private static String recoverMessage(byte[] first_block, byte[] encrypted) {
		byte[] key = new byte[12];
		byte[] message = new byte[encrypted.length];
		for (int i = 0; i < 12 ; i++)
			key[i] = (byte) (encrypted[12+i] ^ first_block[i] ^ encrypted[i]);
		for (int j = 12; j < encrypted.length; j++)
			message[j - 12] = (byte) (key[j % 12] ^ encrypted[j - 12] ^ encrypted[j]); 
		return new String(message);
	}
}
