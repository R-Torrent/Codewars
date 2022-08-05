package java7kyu;

import java.util.Arrays;

/** Flatten and sort an array
 *  7 kyu */
public class Kata {
	
	public static int[] flattenAndSort(int[][] array) {
		return Arrays.stream(array).flatMapToInt(Arrays::stream).sorted().toArray();
	}
	
}