/**
 * Contains all of the security tools.
 *
 * @author Nick Roddy
 *
 */
public class Security
{
	//Constructor
	public Security()
	{
		 
	}
	//Generates the input password
	public static String generatePassword(String password)
	{
		//Sets first character to upper case and converts characters to symbols / numbers.
		password = password.substring(0,1).toUpperCase() + password.substring(1);;
		password = password.replace('s', '$'); password = password.replace('S', '$');
		password = password.replace('a', '@'); password = password.replace('A', '@');
		password = password.replace('o', '0'); password = password.replace('O', '0');
		password = password.replace('e', '3'); password = password.replace('E', '3');
		password = password.replaceAll(" ", "_");
		//Loop alternates password between upper and lower case 
		StringBuffer alternate = new StringBuffer();
		char[] code = password.toCharArray();
				for (int i = 0; i < code.length; i++) 
				{
					char c = code[i];
					if (i % 2 != 0) 
					{
						// convert it to upper case
						c = Character.toLowerCase(c);
					}
					else 
					{
						c = Character.toUpperCase(c);
					}
					
					alternate.append(c);
				}
		//Places "!" if no special characters are present
			if(password.contains("!"))
			{
				String output = (alternate.toString() + password.length());
				return output;
			}
			else if(password.contains("@"))
				{
					String output = (alternate.toString() + password.length());		
					return output;
				}
			else if(password.contains("#"))
				{
					String output = (alternate.toString() + password.length());
					return output;
				}
			else if(password.contains("$"))
				{
					String output = (alternate.toString() + password.length());
					return output;
				}
			else if(password.contains("%"))
				{
					String output = (alternate.toString() + password.length());
					return output;
				}
			else if(password.contains("^"))
				{
					String output = (alternate.toString() + password.length());
					return output;
				}
			else if(password.contains("*"))
				{
					String output = (alternate.toString() + password.length());
					return output;
				}
			else 
			{
					String output = (password + "!" + password.length());
					return output;
			}
	}
	//Encrypts phrase using Caesar Cipher
	public static String ceasarEncrypt(String phrase1, int shift1)
	{
		//Ensures that our shift encryption stays within the 26 letters of the alphabet.
		if (shift1 > 26)
		{
			shift1 = shift1 % 26;
		}
		else if(shift1 < 0) 
		{
			shift1 = (shift1%26) + 26;
		}
		//Initializes that phrase and creates a loop that does the encrypting.
		String caesarPhrase = "";
		int length = phrase1.length();
		for(int i = 0; i<length; i++)
		{
			char c = phrase1.charAt(i);
			if(Character.isLetter(c))
			{
				//ensures that it isn't out of bounds while shifting.
				if(Character.isLowerCase(c))
				{
					char encrypt = (char)(c+shift1);
					if(encrypt > 'z')
					{
						caesarPhrase += (char)(c - (26 - shift1));
					}
					else
					{
						caesarPhrase += encrypt; 
					}
				}
				else if(Character.isUpperCase(c)) 
				{
					char encrypt = (char)(c+shift1);
					if(encrypt > 'Z')
					{
						caesarPhrase += (char)(c - (26 - shift1));
					}
					else
					{
						caesarPhrase += encrypt; 
					}
				}
			}
			else
			{
				caesarPhrase += c;
			}
		}
		//Returns as uppercase value
		return caesarPhrase.toUpperCase();
	}
	//Decrypts phrase made by ceasarEncrypt
		public static String vigenereEncrypt(String inputPhrase, String key1)
		{
			//Initializes variables
			int c = inputPhrase.length(); 
			String vigenerePhrase = "";
			//Generates key1
			for (int i = 0; ; i++) 
				 { 
					if (c == i) 
					i = 0; 
					if (key1.length() == inputPhrase.length()) 
					   break; 
					   key1+=(key1.charAt(i)); 
				 }
			String newKey = key1;
			//Takes generated key1 and creates the encryption
			for (int i = 0; i < inputPhrase.length() && i < newKey.length(); i++) 
				{ 
					//Puts c in Alphabetic range 
					c = (inputPhrase.charAt(i) - newKey.charAt(i) + 26) %26;  
					c += 'a'; 
					vigenerePhrase+=(char)(c); 
				}  
			//Returns as uppercase value
			return vigenerePhrase.toUpperCase();
		}
	//Decrypts phrase made by ceasarEncrypt
	public static String caesarDecrypt(String phrase2, int shift2)
	{
		//Ensures that our shift decryption stays within the 26 letters of the alphabet.
		if (shift2 > 26)
		{
			shift2 = shift2 % 26;
		}
		else if(shift2 < 0) 
		{
			shift2 = (shift2%26) + 26;
		}
		//Initializes that phrase and creates a loop that does the decrypting.
		String caesarPhrase = "";
		int length = phrase2.length();
		for(int i = 0; i<length; i++)
		{
			char c = phrase2.charAt(i);
			if(Character.isLetter(c))
			{
				//ensures that it isn't out of bounds while shifting.
				if(Character.isLowerCase(c))
				{
					char encrypt = (char)(c-shift2);
					if(encrypt < 'a')
					{
						caesarPhrase += (char)(c + (26 - shift2));
					}
					else
					{
						caesarPhrase += encrypt; 
					}
				}
				else if(Character.isUpperCase(c)) 
				{
					char encrypt = (char)(c-shift2);
					if(encrypt < 'A')
					{
						caesarPhrase += (char)(c + (26 - shift2));
					}
					else
					{
						caesarPhrase += encrypt; 
					}
				}
			}
			else
			{
				caesarPhrase += c;
			}
		}
		//Returns as uppercase value
		return caesarPhrase.toUpperCase();
	}
	//Decrypts phrase made by vigenerEncrypt
	public static String vigenereDecrypt(String outputPhrase, String key2)
	{
		//Initializes variables
		int c = outputPhrase.length(); 
		String vigenerePhrase = "";
		//Generates key1
		for (int i = 0; ; i++) 
			 { 
				if (c == i) 
					i = 0; 
				if (key2.length() == outputPhrase.length()) 
				    break; 
				   	key2+=(key2.charAt(i)); 
			 }
		String newKey = key2;
		//Takes generated key1 and creates the encryption
		for (int i = 0; i < outputPhrase.length() && i < newKey.length(); i++) 
		{ 
			//Puts c in Alphabetic range 
			c = (outputPhrase.charAt(i) - newKey.charAt(i) + 26) %26;  
			c += 'a'; 
			vigenerePhrase+=(char)(c); 
		}  
		//Returns as uppercase value
		return vigenerePhrase.toUpperCase();
	}
}
