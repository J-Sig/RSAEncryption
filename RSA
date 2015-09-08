import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.math.BigInteger;


public class Encryption {
	
	private Scanner reader;
	private PrintWriter encryptedWriter;
	private PrintWriter decryptedWriter;
	private File original;
	private BigInteger encryptedMessage = new BigInteger("0");
	private File encryption;
	private File decryption;
	private String finalDecryption = "";

	//The public mod must be an extremely large number, greater than numerical size of message
	final private BigInteger p = new BigInteger("511704374946917490638851104912462284144240813125071454126151");
	final private BigInteger q =  new BigInteger("18532395500947174450709383384936679868383424444311405679463280782405796233163977");
	final private BigInteger public_mod = new BigInteger("9483107856081239752652671276827730208976481224634648990911654899501009028683736519565990642865085903122153749463100491684116224422426862527");//p*q
	final private BigInteger phi_public_mod = new BigInteger("9483107856081239752652671276827730208976481224634648990911636367105508081509285298478230759267726880846604525595136884162520693554739572400");//(p-1)*(q-1)
	final private BigInteger public_exponent = new BigInteger("23");//gcd(this, phi_public_mod) == 1
	final private BigInteger private_exponent = public_exponent.modInverse(phi_public_mod);
	
	public Encryption(File a, File b, File c) throws IOException {
		original = a;
		encryption = b;
		decryption = c;
		reader = new Scanner(original);
		encryptedWriter = new PrintWriter(encryption);
		decryptedWriter = new PrintWriter(decryption);
	}

	
	public void encrypt(){	
		System.out.println("Converting to ASCII...");
		getASCIIFormat();
		
		System.out.println("\nEncrypting...");
		encryptedMessage = encryptedMessage.modPow(public_exponent, public_mod);
		
		System.out.println("Encrpyted Numerical Value: " + encryptedMessage);
		//System.out.println("Encrypted Message: " + toLetters(encryptedMessage.toString()));
		
		encryptedWriter.println("Encrypted Numerical Value: " + encryptedMessage);
		encryptedWriter.println("Alphanumerical ASCII: " + toLetters(encryptedMessage.toString()));
		encryptedWriter.close();
	}
	
	public void decrypt() {
		System.out.println("Decrypting to ASCII...");
		encryptedMessage = encryptedMessage.modPow(private_exponent, public_mod);
		
		System.out.println("Decrypted Numerical Value: " + encryptedMessage);
		finalDecryption = encryptedMessage.toString();
		
		decryptedWriter.println("ASCII ID Format: " + finalDecryption);
		
		finalDecryption = toLetters(finalDecryption);
		System.out.println("Decrypted Message: " + finalDecryption);
		
		decryptedWriter.println("Message: " + finalDecryption);
		decryptedWriter.close();
	}
	
	public String toLetters(String ascii) {
		String s = "";
		int id;
		for (int i = ascii.length() - 3; i >= 0; i -= 3) {
			id = (Integer.parseInt(ascii.substring(i,i+3)));
			s = (char) id + s;
			if (i - 3 < 0) {
				id = (Integer.parseInt(ascii.substring(0,2)));
				s = (char) id + s;
			}
		}
		
		return s;
	}
	
	
	public void getASCIIFormat() {
		String message = "";
		
		while (reader.hasNext())
			message += reader.nextLine();
		
		System.out.println("Retrieved message: " + message);
		
		int[] letters = new int[message.length()];
		
		for (int i = 0; i < letters.length; i++) {
			letters[i] = (int) message.charAt(i);
			//System.out.print(letters[i] + " ");
		}
		System.out.print('\n');
		
		BigInteger multiple;
		
		if (letters.length == 1)
			multiple = new BigInteger("1");
		else {
			multiple = new BigInteger("1000");
			for (int i = letters.length - 1; i > 1; i--)
				multiple = multiple.multiply(new BigInteger("1000"));
		}
		
		//System.out.println(multiple);
		
		for (int i = 0; i < letters.length; i++) {
			encryptedMessage = encryptedMessage.add(multiple.multiply(new BigInteger("" + letters[i])));
			multiple = multiple.divide(new BigInteger("1000"));
			//System.out.println(encryptedMessage);
		}

		System.out.println("ASCII Format: " + encryptedMessage);
	}
	
	public String toString() {
		return "p = " + p + '\n' +
			   "q = " + q + '\n' +
			   "public mod = " + public_mod + '\n' + 
			   "phi(public mod) = " + phi_public_mod + '\n' +
			   "public exponent = " + public_exponent + '\n' + 
			   "private_exponent = " + private_exponent + '\n';
	}
}
