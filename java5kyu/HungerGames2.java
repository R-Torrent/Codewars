package java5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** The Hunger Games - Shut the gate
 *  5 kyu */
public class HungerGames2 {
	
	public static void main(String[] args) {
		System.out.println(shutTheGate("|..HH....\\AAAA\\CC..|AAA/VVV/RRRR|CCC"));
	}
	
	public static String shutTheGate(final String farm) {
		// Gates and animal pens
		String farm1 = farm.replace(".", Farm.EVERYTHINGELSE.legend); // Dots mean something else in regular expressions
		final Pattern p = Pattern.compile("[" + Farm.GATECLOSED.legend + Farm.GATEOPEN.legend + "]");
		final Matcher m = p.matcher(farm1);
		Gate[] gates = m
				.results()
				.map(matchResults -> new Gate(matchResults.group()))
				.toArray(Gate[]::new);
		Pen[] pens1 = p
				.splitAsStream(farm1) // NOTE: Trailing empty pens are discarded
				.map(Pen::new)
				.toArray(Pen[]::new);
		Pen[] pens = Arrays.copyOf(pens1, gates.length+1);
		final int N = pens.length, N1 = N-1;
		int i = N1, j;
		while(i >= 0 && pens[i] == null)
			pens[i--] = new Pen(""); // Trailing empty pens manually added
		
		// Connected animal domains
		Set<Pen> domain = new HashSet<>(); // Connected animal enclosures
		List<Set<Pen>> domains = new ArrayList<>();
		j = N1;
		do { // Enclosures '0' and 'N1' are always connected
			domain.add(pens[j--]);
		} while(j >= 0 && !gates[j].isClosed());
		i = 0;
		do {
			do {
				domain.add(pens[i++]);
			} while(i <= j && !gates[i-1].isClosed());
			
			domains.add(domain);
			domain = new HashSet<>();
		} while(i <= j);
		
		// Feeding frenzy
		domains.forEach(d -> {
			EnumSet<Farm>
				contentsDomain = EnumSet.noneOf(Farm.class),
				eatenInDomain = EnumSet.noneOf(Farm.class);
			d.stream()
				.map(pen -> pen.getContents())
				.forEach(c -> contentsDomain.addAll(c));
			contentsDomain.stream()
				.flatMap(c -> Arrays.stream(c.eats))
				.forEach(e -> eatenInDomain.add(e));
//				.forEach(e -> d.stream().forEach(pen -> pen.consume(e)));
		});
		
		return farm1.replace(Farm.EVERYTHINGELSE.legend, ".");
	}
	
	public enum Farm {
		
		GATECLOSED ("gate (closed)", new Farm[]{}, false, "|"),
		GATEOPEN ("gate (open)", new Farm[]{}, false, "(\\\\)/"),
		APPLETREE ("apple tree", new Farm[]{}, false, "A"),
		VEGETABLES ("vegetables", new Farm[]{}, false, "V"),
		CHICKEN ("chicken", new Farm[]{}, true, "C"),
		RABBIT ("rabbit", new Farm[]{VEGETABLES}, true, "R"),
		HORSE ("horse", new Farm[]{APPLETREE, VEGETABLES}, true, "H"),
		EVERYTHINGELSE ("everything else", new Farm[]{}, false, "x");
		
		public Farm[] eats;
		public String name;
		public boolean runsaway;
		public String legend;
		
		private Farm(String name, Farm[] eats, boolean runsaway, String legend) {
			this.name = name;
			this.eats = eats;
			this.runsaway = runsaway;
			this.legend = legend;
		}
		
		public boolean isName(String string) {
			return string.equals(name);
		}
		
	}
	
	public static class Pen {
		
		public String string;
		public EnumSet<Farm> contents;
		
		public Pen(String string) {
			this.string = string;
			contents = Arrays.stream(Farm.values())
					.filter(f -> string.contains(f.legend))
					.collect(Collectors.toCollection(() -> EnumSet.noneOf(Farm.class)));
		}
		
		public EnumSet<Farm> getContents() {
			return contents;
		}
		
		public void consume(Farm edible) {
			string.replace(edible.legend, Farm.EVERYTHINGELSE.legend);
			contents.remove(edible);
			contents.add(Farm.EVERYTHINGELSE);
		}
		
	}
	
	public static class Gate {
		
		public String string;
		public boolean closed;
		
		public Gate(String string) {
			this.string = string;
			closed = string.equals(Farm.GATECLOSED.legend);
		}
		
		public boolean isClosed() {
			return closed;
		}
		
	}
	
}