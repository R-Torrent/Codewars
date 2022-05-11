package java7kyu;

/** Two to One
 *  7 kyu */
public class TwoToOne {
	
	public static String longest (String s1, String s2) {
		String distinct = "";
		for(char c = 'a'; c <= 'z'; c++) {
			String sc = Character.toString(c);
			if(s1.contains(sc) || s2.contains(sc))
				distinct += sc;
		}
		return distinct;
	}
	
}