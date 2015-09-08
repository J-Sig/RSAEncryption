import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AppView {

	public static void main(String[] args) throws IOException {
		Scanner userInput = new Scanner(System.in);
		
		File original = new File("message.txt");
		File encryption = new File("encryption.txt");
		File decryption = new File("decryption.txt");
		
		System.out.println("Files successfully loaded");
		
		System.out.println("Hit 'Enter' to encrypt the message");
		userInput.nextLine();
		
		Encryption e = new Encryption(original, encryption, decryption);
		System.out.println(e);
		
		e.encrypt();
		
		System.out.println("Message has been encrypted\n\nHit 'Enter' to decrypt");
		userInput.nextLine();
		
		e.decrypt();
		
		System.out.println("\nDone!");
		
		
	}

}
