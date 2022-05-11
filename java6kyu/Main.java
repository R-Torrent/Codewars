package java6kyu;

/** Give your kata a name
 *  6 kyu */
public class Main {
	
	public static void main(String[] args) {
		System.out.println(Main.name(new String[]{"co","de","w","ar","s"}));
	}
	
	public static int name(String[] s) {
		int n = s.length, l = 1<<n, max = 0;
		int[] sl = new int[n];
		
		for(int i= 0; i < n; i++)
			sl[i] = value(s[i]);
		for(int i = 1; i < l; i++) {
			int length = 0, tval = 0;
			for(int bit = 0; bit < n; bit++)
				if((i & 1<<bit) != 0) {
					length += s[bit].length();
					tval += sl[bit];
				}
			if(length > max && tval <= 10*length)
				max = length;
			}
		
		return max;
	}
	
	public static int value(String s) {
		return s.chars().map(c -> c-'a'+1).sum();
	}
	
}