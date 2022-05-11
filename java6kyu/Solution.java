package java6kyu;

/** Multiples of 3 or 5
 *  6 kyu */
public class Solution {
	
	public int solution(int number) {
		int sum = 0;
		for(int n = 0; n < number; n++)
			if(n%3 == 0 || n%5 == 0)
				sum += n;
		return sum;
	}
	
}