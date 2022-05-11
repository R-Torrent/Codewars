package java6kyu;

import java.util.Arrays;

/** Which are in?
 *  6 kyu */
public class WhichAreIn {
	
	public static void main(String[] args) {
		String a[] = new String[]{ "arp", "live", "strong" };
    	String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
    	inArray(a, b);
	}
	
	public static String[] inArray(String[] array1, String[] array2) {
		 return Arrays.stream(array1)
				 .filter(s1 -> Arrays.stream(array2).anyMatch(s2 -> s2.contains(s1)))
				 .distinct()
				 .sorted()
				 .toArray(String[]::new);
	}
	
}