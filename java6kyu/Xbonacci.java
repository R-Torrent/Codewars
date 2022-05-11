package java6kyu;

import java.util.Arrays;

/** Tribonacci Sequence
 *  6 kyu */
public class Xbonacci {
	
	public double[] tribonacci(double[] s, int n) {
		double[] sequence = Arrays.copyOf(s, n);
		for(int i = 3; i < n; i++)
			sequence[i] = sequence[i-1] + sequence[i-2] + sequence[i-3];
		return sequence;
	}
	
}