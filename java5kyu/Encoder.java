package java5kyu;

import java.util.StringJoiner;

/** A Simple Music Encoder
 *  5 kyu */
public class Encoder {
	
	public static void main(String[] args) {
		System.out.println(compress(new int[] {1,2,2,3}));
	}
	
    public static String compress(int[] raw) {
    	int l = raw.length, l1 = l-1;
    	int[] diff = new int[l1];
    	StringJoiner code = new StringJoiner(",");
    	
    	for(int i = 0; i < l1; i++)
    		diff[i] = raw[i+1] - raw[i];
    	
    	for(int i = 0; i < l; ) {
    		String entry = String.valueOf(raw[i]);
    		int j = i + 1;
    		while(j < l1 && diff[j] == diff[i])
    			j++;
    		if(i < l1 && diff[i] == 0)
    			entry += "*" + (j++ -i + 1);
    		else if((j-i) > 1)
    			entry += "-" + raw[j++] + (diff[i] == 1 || diff[i] == -1 ? "" : "/" + Math.abs(diff[i]));
    		i = j;
    		code.add(entry);
    	}
    	
    	return code.toString();
    }
    
}