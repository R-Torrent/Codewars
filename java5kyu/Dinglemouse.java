package java5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** The Hunger Games - Zoo Disaster!
 *  5 kyu */
public class Dinglemouse {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(whoEatsWho("chicken,cow,bear,chicken")));
	}
	
	public static String[] whoEatsWho(String input) {
		ArrayList<String> zoo = new ArrayList<>();
		zoo.add(input);
		
		boolean eatingFrenzy;
		do {
			eatingFrenzy = false;
			List<String> survivors = Stream.of(input.split(",")).collect(Collectors.toList());
			int l = survivors.size();
			Zoo[] creatures = new Zoo[l];
			for(int i = 0; i < l; i++) {
				String name = survivors.get(i);
				creatures[i] = Arrays.stream(Zoo.values())
						.filter(z -> z.isName(name))
						.findAny()
						.orElse(Zoo.UNKNOWN);
			}
			for(int i = 0; i < l; i++) {
				if(i > 0 && Arrays.binarySearch(creatures[i].eats, creatures[i-1]) >= 0) {
					eatingFrenzy = true;
					survivors.remove(i-1);
					input = survivors.stream().collect(Collectors.joining(","));
					zoo.add(creatures[i].name + " eats " + creatures[i-1].name);
					break;
				}
				if(i < l-1 && Arrays.binarySearch(creatures[i].eats, creatures[i+1]) >= 0) {
					eatingFrenzy = true;
					survivors.remove(i+1);
					input = survivors.stream().collect(Collectors.joining(","));
					zoo.add(creatures[i].name + " eats " + creatures[i+1].name);
					break;
				}
			}
		} while(eatingFrenzy);
		zoo.add(input);
		
		return zoo.toArray(new String[]{});
	}
	
	public enum Zoo {
			
		GRASS ("grass", new Zoo[]{}),
		ANTELOPE ("antelope", new Zoo[]{GRASS}),
		LITTLEFISH ("little-fish", new Zoo[]{}),
		BIGFISH ("big-fish", new Zoo[]{LITTLEFISH}),
		LEAVES ("leaves", new Zoo[]{}),
		BUG ("bug", new Zoo[]{LEAVES}),
		CHICKEN ("chicken", new Zoo[]{BUG}),
		COW ("cow", new Zoo[]{GRASS}),
		SHEEP ("sheep", new Zoo[]{GRASS}),
		BEAR ("bear", new Zoo[]{BIGFISH, LEAVES, BUG, CHICKEN, COW, SHEEP}),
		FOX ("fox", new Zoo[]{CHICKEN, SHEEP}),
		GIRAFFE ("giraffe", new Zoo[]{LEAVES}),
		LION ("lion", new Zoo[]{ANTELOPE, COW}),
		PANDA ("panda", new Zoo[]{LEAVES}),
		UNKNOWN ("unknown", new Zoo[]{});
		
		public Zoo[] eats;
		public String name;
		
		private Zoo(String name, Zoo[] eats) {
			this.name = name;
			this.eats = eats;
		}
		
		public boolean isName(String string) {
			return string.equals(name);
		}
		
	}
	
}