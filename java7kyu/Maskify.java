package java7kyu;

/** Credit Card Mask
 *  7 kyu */
public class Maskify {
	
	public static void main(String[] args) {
		System.out.println(maskify("4556364607935616"));
	}
	
	public static String maskify(String str) {
		char[] chars = str.toCharArray();
		for(int i = chars.length - 5; i >= 0; i--)
			chars[i] = '#';
		return new String(chars);
	}
	
}