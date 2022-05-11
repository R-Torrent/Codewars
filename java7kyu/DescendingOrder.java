package java7kyu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

/** Descending Order
 *  7 kyu */
public class DescendingOrder {
	
	public static int sortDesc(final int num) {
		Iterator<Integer> it = Integer.toString(num)
				.chars()
				.map(i -> i-'0')
				.sorted()
				.mapToObj(i -> i)
				.collect(Collectors.toCollection(LinkedList::new))
				.descendingIterator();
		int reverse = 0;
		while(it.hasNext()) {
			reverse *= 10;
			reverse += it.next();
		}
		
		return reverse;
	}
	
}