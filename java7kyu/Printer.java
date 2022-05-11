package java7kyu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Printer Errors
 *  7 kyu */
public class Printer {
	
	public static String printerError(String s) {
		Pattern pattern = Pattern.compile("[^a-m]");
		Matcher matcher = pattern.matcher(s);
		int errors = 0;
		while(matcher.find()) errors++;
		return Integer.toString(errors) + "/" + s.length();
	}
	
}