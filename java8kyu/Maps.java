package java8kyu;

/** Beginner - Lost Without a Map
 *  8 kyu */
public class Maps {
	
	public static int[] map(int[] arr) {
		int l = arr.length;
		int[] arr2 = new int[l];
		for(int i = 0; i < l; i++)
			arr2[i] = arr[i] << 1;
		return arr2;
	}
	
}