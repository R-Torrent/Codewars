package java8kyu;

/** Fake Binary
 *  8 kyu */
public class FakeBinary {
	
	public static void main(String args[]) {
		System.out.println(fakeBin("45385593107843568"));
		System.out.println(fakeBin("509321967506747"));
		System.out.println(fakeBin("366058562030849490134388085"));
	}
	
	public static String fakeBin(String numberString) {
		return numberString.chars()
				.map(c -> c < '5' ? '0' : '1')
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
	
}