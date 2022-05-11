package java7kyu;

/** You're a square!
 *  7 kyu */
public class Square {
	
	public static boolean isSquare(int n) {
		int i = 0;
		while(i * i < n)
			i++;
		return n == i * i;
	}
	
}