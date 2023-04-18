import java.util.*;

public class Exercise2203 {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two strings
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();

		int index = -1; // Stores index of s2 as a substring of s1
		int count = 0;  // Count matches

		// tests whether the second string is a substring of the first string
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0) && count == 0) {
				index = i;
				count++;
			}
			else if (s1.charAt(i) == s2.charAt(count)) {
				count++;
			}
			else {
				count = 0;
				index = -1;
			}

			if (count == s2.length())
				break;
		}

		// Display results
		if (index > 1)
			System.out.println("matched at index " + index);
		else
			System.out.println("string2 is not a substring of string1");
	}
}
