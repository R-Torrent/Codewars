package java5kyu;

import java.util.Arrays;

/** Pascal's Diagonals
 *  5 kyu */
public class PascalDiagonals {
	
	public static long[] generateDiagonal(int n, int l) {
		if(l == 0) return new long[]{};
		long[] diagonal = new long[l];
		if(n == 0) {
			Arrays.fill(diagonal, 1L);
			return diagonal;
		}
		long[] prevDiagonal = generateDiagonal(n-1, l);
		Arrays.setAll(diagonal, i -> i == 0 ? 1 : diagonal[i-1] + prevDiagonal[i]);
		return diagonal;
	}
	
}