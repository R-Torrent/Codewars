package java6kyu;

/** Bit Counting
 *  6 kyu */
public class BitCounting {
	
	public static void main(String args[]) {
		System.out.println(countBits(1234));
		System.out.println(countBits(4));
		System.out.println(countBits(7));
		System.out.println(countBits(9));
		System.out.println(countBits(10));
	}
	
	public static int countBits(int n) {
		int res = 0;
		do {
			res += n%2;
		} while((n /= 2) > 0);
		
		return res;
	}
	
}