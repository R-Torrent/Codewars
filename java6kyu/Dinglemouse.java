package java6kyu;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** The Hunger Games - Foxes and Chickens
 *  6 kyu */
public class Dinglemouse {
	
	public static void main(String[] args) {
		System.out.println(hungryFoxes("CCC[CCC]FCC[CCCFC]CFFFF[CCC]FFFF"));
	}
	
	public static String hungryFoxes(final String farm) {
		Matcher m = Pattern.compile("\\[(C|\\.|F)*\\]").matcher(farm);
		String farmAfter = m.replaceAll("X");
		if(farmAfter.contains("F")) farmAfter = farmAfter.replaceAll("C", ".");
		List<String> pensAfter = m.reset()
			.results()
			.map(MatchResult::group)
			.map(str -> str.contains("F") ? str.replace('C', '.') : str)
			.collect(Collectors.toList());
		for(String str : pensAfter)
			farmAfter = farmAfter.replaceFirst("X", str);;
		
		return farmAfter;
	}
	
}