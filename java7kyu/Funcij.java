package java7kyu;

import java.math.BigInteger;

/** Functions of Integers on Cartesian Plane
 *  7 kyu */
public class Funcij {
	
	public static BigInteger sumin(int n) {
		BigInteger sum = BigInteger.ZERO;
		for(int x = 1; x <= n; x++)
			for(int y = 1; y <= n; y++)
				sum = sum.add(BigInteger.valueOf(Math.min(x, y)));
		return sum;
	}
	
	public static BigInteger sumax(int n) {
		BigInteger sum = BigInteger.ZERO;
		for(int x = 1; x <= n; x++)
			for(int y = 1; y <= n; y++)
				sum = sum.add(BigInteger.valueOf(Math.max(x, y)));
		return sum;
	}
	
	public static BigInteger sumsum(int n) {
		BigInteger sum = BigInteger.ZERO;
		for(int x = 1; x <= n; x++)
			for(int y = 1; y <= n; y++)
				sum = sum.add(BigInteger.valueOf(x+y));
		return sum;
	}
	
}