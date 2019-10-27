package AndroidDeveloperTest;

import java.util.Scanner;

public class Test1AnagramStrings {
	
	static boolean isAnagrams(String firstString, String secondString) {
		firstString = firstString.replaceAll("\\s","").toLowerCase();
		secondString = secondString.replaceAll("\\s","").toLowerCase();
		
		if(firstString.length() != secondString.length()) {
			return false;
		}
		
		int len1 = firstString.length();
		for(int i = 0; i < len1; i++) {
			int len2 = secondString.length();
			for(int j = 0; j < len2; j++) {
				if(firstString.charAt(i) == secondString.charAt(j)) {
					secondString = secondString.substring(0,j) + secondString.substring(j+1,len2);
					break;
				}
			}
		}
		
		if(secondString.length() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String firstString = scr.nextLine();
		String secondString = scr.nextLine();
		
		if(isAnagrams(firstString, secondString)) {
			System.out.println(firstString + " and " + secondString + " are anagrams.");
		}
		else {
			System.out.println(firstString + " and " + secondString + " are not anagrams.");
		}
		
		scr.close();
	}

}
