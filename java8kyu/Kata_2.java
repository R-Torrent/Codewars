package java8kyu;

/** Rock Paper Scissors!
 *  8 kyu */
public class Kata_2 {
	
	public static String rps(String p1, String p2) {
		int winner = 0;
		switch(p1) {
		case "scissors":
			switch(p2) {
			case "paper": winner = 1; break;
			case "rock": winner = 2; break;
			}
		break;
		case "paper":
			switch(p2) {
			case "rock": winner = 1; break;
			case "scissors": winner = 2; break;
			}
		break;
		case "rock":
			switch(p2) {
			case "scissors": winner = 1; break;
			case "paper": winner = 2; break;
			}
		}
		return winner == 0 ? "Draw!" : "Player " + winner + " won!";
	}
	
}