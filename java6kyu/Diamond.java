package java6kyu;

/** Give me a Diamond
 *  6 kyu */
public class Diamond {
	
	public static void main(String[] args) {
		System.out.print(Diamond.print(5));
	}
	
	public static String print(int n) {
		if(n % 2 == 0 || n < 0) return null;
		
		int l = (n-1)>>1;
		StringBuilder diamond = new StringBuilder(((n+1)*(3*n+1))>>2);
		for(int r = -l; r <= l; r++) {
			int i = 0;
			for(; i < Math.abs(r); i++)
				diamond.append(" ");
			for(; i < n-Math.abs(r); i++)
				diamond.append("*");
			diamond.append("\n");
		}
		
		return diamond.toString();
	}
	
}