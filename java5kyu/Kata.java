package java5kyu;

/** Base -2
 *  5 kyu */
public class Kata {
	
	public static String intToNegabinary(int i) {
		StringBuilder strB = new StringBuilder("");
		do {
			int r = i % -2;
			i /= -2;
			if(r < 0) {
				i++;
				r += 2;
			}
			strB.append(r);
		} while(i != 0);
		
		return strB.reverse().toString();
	}
	
	public static int negabinaryToInt(String s) {
		int i = 0, b = 1;
		int[] array = s.chars().map(c -> c - '0').toArray();
		for(int j = array.length-1; j >= 0 ; j--) {
			i += array[j] == 1 ? b : 0;
			b *= -2;
		}
		
		return i;
	}
	
}