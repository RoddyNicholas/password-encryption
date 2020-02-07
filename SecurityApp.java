import java.util.Scanner;
/**
 * used to control the user interactions.
 *
 * @author Nick Roddy
 *
 */
public class SecurityApp
{
	//Scanner object(s)
	static Scanner userInputOne = new Scanner(System.in);
	static Scanner userInputTwo = new Scanner(System.in);
	static int tool, encryptionSelect, encryptionOne;
	static String password, encryptOne, encryptTwo, encryptionTwo;
	//Class Object
	static Security output = new Security();
	//Displays welcome and a list of the available tools
	public static void mainMenu()
	{
		//Displays Welcome
		System.out.println("------------------------------------------------");
		System.out.println("Thank you for choosing the IT-168 Security tool!");
		System.out.println("------------------------------------------------");
		System.out.println("Please select a tool from the options below:");
		System.out.println("1. Password Generator"); 
		System.out.println("2. Encryption Tool");
		System.out.println("3. Decryption Tool");
		System.out.print("Your Selection(1,2,3)> ");
		tool = userInputOne.nextInt();
		//Directs the user's choice in tool
		if(tool == 1)
		{
			passwordSelected();
		}
		else if (tool == 2)
		{
			encryptionSelected();
		}
		else
		{
			decryptionSelected();
		}
	}
	//prompts the use to enter a 8 char long phrase.
	public static void passwordSelected()
	{
		//Asks user to input password
		System.out.print("Please Enter a phrase that is at least 8 characters long> ");
		password = userInputTwo.nextLine();
		
		if(password.length() >= 8)
		{
			System.out.print("Your Password is: " + Security.generatePassword(password));
		}
		else
		{
			System.out.print("Pasword must be at least 8 characters long!");
		}
	}
	//prompts the user to select the type of encryption and encrypts.
	public static void encryptionSelected()
	{
		System.out.println("Please Select the type of Encryption from the options below:");
		System.out.println("1. Caeser Encryption"); 
		System.out.println("2. Vigenere Encryption");
		System.out.print("Your Selection(1,2)> ");
		encryptionSelect = userInputOne.nextInt();
		if(encryptionSelect == 1)
		{
			System.out.print("Please Enter the phrase you want to encrypt> ");
			encryptOne = userInputTwo.nextLine();
			System.out.print("Please Enter the key you want to use for encryption> ");
			encryptionOne = userInputOne.nextInt();
			System.out.println("Here is your Encrypted phrase: " + Security.ceasarEncrypt(encryptOne, encryptionOne));
		}
		else
		{
			System.out.print("Please Enter the phrase you want to encrypt> ");
			encryptTwo = userInputTwo.nextLine();
			System.out.print("Please Enter the key you want to use for encryption> ");
			encryptionTwo = userInputTwo.nextLine();
			if(encryptTwo.length() > encryptionTwo.length())
			{
				System.out.println("Here is your Encrypted phrase: " + Security.vigenereEncrypt(encryptTwo,encryptionTwo));
			}
			else {
				System.out.println("Encryption Invalid.");
			}
		}
	}
	//prompts the user to select the type of decryption and decrypts.
	public static void decryptionSelected()
	{
		System.out.println("Please Select the type of Decryption from the options below:");
		System.out.println("1. Caeser Decryption"); 
		System.out.println("2. Vigenere Decryption");
		System.out.print("Your Selection(1,2)> ");
		encryptionSelect = userInputOne.nextInt();
		if(encryptionSelect == 1)
		{
		System.out.print("Please Enter the phrase you want to decrypt> ");
		encryptOne = userInputTwo.nextLine();
		System.out.print("Please Enter the key you want to use for decryption> ");
		encryptionOne = userInputOne.nextInt();
		System.out.println("Here is your Decrypted phrase: " + Security.caesarDecrypt(encryptOne, encryptionOne));
		}
		else
		{
		System.out.print("Please Enter the phrase you want to decrypt> ");
		encryptTwo = userInputTwo.nextLine();
		System.out.print("Please Enter the key you want to use for decryption> ");
		encryptionTwo = userInputTwo.nextLine();
		if(encryptTwo.length() > encryptionTwo.length())
		{
			System.out.println("Here is your Decrypted phrase: " + Security.vigenereDecrypt(encryptTwo,encryptionTwo));
		}
		else {
			System.out.println("Decryption Invalid.");
		}
		}
	}
	//Initiates the program and manages flow
		public static void main(String[] args)
		{
			//Initializes main menu
			mainMenu();
		}
}
