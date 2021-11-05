import java.util.Scanner;

public class MainGame {
	
	static player.Player[] createPlayers(int numPlayers, Scanner sc, pile.DrawPile drawPile) {
		player.Player[] players = new player.Player[numPlayers];
		for(int i=0; i<4; i++) {
			System.out.println("Player " + i+1 + " Name: ");
			String playerName = sc.nextLine();
			players[i] = new player.Player(playerName, drawPile, i+1);
		}
		return players;
	}

	public static void main(String[] args) {
		utilClasses.DeckInitializer deckInitializer = new utilClasses.DeckInitializer();
		pile.DrawPile drawPile = deckInitializer.getDrawPile();
		pile.DiscardPile discardPile = deckInitializer.getDiscardPile();
		
		Scanner sc = new Scanner(System.in);
		
		player.Player[] players = createPlayers(4, sc, drawPile);
		
		Thread[] playerThreads = new Thread[4];
		
	}

}
