package java7kyu;

/** Switcheroo
 *  7 kyu */
public class Switcheroo {
	
	public static String switcheroo(String x) {
		return x.replace('a', 'x').replace('b', 'a').replace('x', 'b');
	}

}