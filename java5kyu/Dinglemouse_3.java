package java5kyu;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** The Hunger Games - Foxes and Chickens (Poison)
 *  5 kyu */
public class Dinglemouse_3 {
	
	public static void main(String[] args) {
		System.out.println(hungryFoxes("...CC...X...[CCC]CCC[CCCXCCCF]CCCC[CFC]FCC"));
	}
	
	public static String hungryFoxes(final String farm) {
		Matcher m = Pattern.compile("\\[[C\\.FX]*\\]").matcher(farm);
		char[] charsFarm = m.replaceAll("P").toCharArray();
		for(int i = 0; i < charsFarm.length; i++)
			if(charsFarm[i] == 'F') {
				for(int j = --i; j >= 0 && charsFarm[j] != 'X'; j--)
					if(charsFarm[j] == 'C') charsFarm[j] = '.';
				for(int j = ++i; j < charsFarm.length && charsFarm[j] != 'X'; j++)
					if(charsFarm[j] == 'C') charsFarm[j] = '.';
			}
		String farmAfter = new String(charsFarm);
		if(farmAfter.contains("X")) farmAfter = farmAfter.replaceAll("F", ".");
		
		List<String> pens = m.reset()
			.results()
			.map(MatchResult::group)
			.collect(Collectors.toList());
		for(String pen : pens) {
			char[] charsPen = pen.toCharArray();
			for(int i = 0; i < charsPen.length; i++)
				if(charsPen[i] == 'F') {
					for(int j = --i; charsPen[j] != 'X' && charsPen[j] != '['; j--)
						if(charsPen[j] == 'C') charsPen[j] = '.';
					for(int j = ++i; charsPen[j] != 'X' && charsPen[j] != ']'; j++)
						if(charsPen[j] == 'C') charsPen[j] = '.';
				}
			String penAfter = new String(charsPen);
			if(penAfter.contains("X")) penAfter = penAfter.replaceAll("F", ".");
			farmAfter = farmAfter.replaceFirst("P", penAfter);
		}
		
		return farmAfter;
	}
	
}