package java6kyu;

/** Sum of Digits / Digital Root
 *  6 kyu */
public class DRoot {
	public static int digital_root(int n) {
		while(n > 9)
			n = String.valueOf(n).chars().map(c -> c - '0').sum();
		return n;
	}
}