package java8kyu;

import java.util.Scanner;

/** Parse nice int from char problem
 *  8 kyu */
public class CharProblem {
	
	public static int howOld(final String herOld) {
		Scanner sc = new Scanner(herOld).useDelimiter(" ");
		return sc.nextInt();
	}
	
}