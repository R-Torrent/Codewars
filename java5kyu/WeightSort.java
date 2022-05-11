package java5kyu;

import java.util.Arrays;

/** Weight for weight
 *  5 kyu */
public class WeightSort {
	
	public static void main(String[] args) {
		System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
	}
	
	public static String orderWeight(String strng) {
		String[] weights = strng.split(" ");
		Arrays.sort(weights, (String s1, String s2) -> {
			int	i1 = s1.chars().map(i -> i-'0').sum(),
				i2 = s2.chars().map(i -> i-'0').sum(),
				i = i1 - i2;
			return i == 0 ? s1.compareTo(s2) : i;
		});
		return String.join(" ", weights);
	}
	
}