package com.scp.Password;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

interface PasswordGenration{
	
 String SMALL_CHAR[]= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",};
 String CAPITAL_CHAR[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",};
 String DIGITS[]= {"0","1","2","3","4","5","6","7","8","9"};
 String SPECIAL_CHAR[]= {"@","#","","5","^","~"};
 
 String PWD_LOW_STRENGTH = "LOW";  
 String PWD_MEDIUM_STRENGTH = "MEDIUM"; 
 String PWD_HIGH_STRENGTH = "HIGH"; // 
	
}

public class TestPasswordGeneration implements PasswordGenration{
	
	public static void main(String[]args) {
	  	System.out.println("in password generation");
		String password = generatePassword(PWD_HIGH_STRENGTH,9);
		System.out.println("Your Password -- " +password);
			
	}
	
 private static String generatePassword(String pwdStrength, int pwdLen) {
     
	  String password="";
	 if(pwdLen<5||pwdLen>10)
	 return null;
	  
	 switch (pwdStrength) {
	 
	case PWD_LOW_STRENGTH:
		
			for(int i =0 ;i< (pwdLen/2)+1 ;i++){
			
				password+=getSmallChar();
				password+=getCaptiatlChar();
				return password;
		}
		
	case PWD_MEDIUM_STRENGTH:
		for(int i =0 ;i< (pwdLen/3)+1 ;i++) {
			password+=getCaptiatlChar();
			password+=getSmallChar();
			password+=getDigitChar();
		}
		
		return password;
		
		
	case PWD_HIGH_STRENGTH:
		for(int i =0 ;i< (pwdLen/4)+1 ;i++) {
			
			password+=getCaptiatlChar();
			password+=getSmallChar();
			password+=getDigitChar();
			password+=getSpecialChar();
		}
		
		return password;
	default:
		System.out.println("cannot generate password");
		break;
	}
	return password;
	}

private static String getCaptiatlChar(){
	 
	int index=ThreadLocalRandom.current().nextInt(0,CAPITAL_CHAR.length);
	 
	return CAPITAL_CHAR[index];
 }
  
private static String getSmallChar() {
int index=ThreadLocalRandom.current().nextInt(0,SMALL_CHAR.length);
	return SMALL_CHAR[index];
}
 
private static String getDigitChar() {
	return DIGITS[ThreadLocalRandom.current().nextInt(0,DIGITS.length)];
	
}
private static String getSpecialChar() {
	return SPECIAL_CHAR[ThreadLocalRandom.current().nextInt(0,SPECIAL_CHAR.length)];
}
  	
}

/**for(int i=65;i<91;i++) {
System.out.print("\""+(char)i+"\",");     //for printing alphabets for loop.
*/