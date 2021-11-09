import java.util.Scanner;

public class MainGame {
	
	static player.Player[] createPlayers(int numPlayers, Scanner sc, pile.DrawPile drawPile) {
		player.Player[] players = new player.Player[numPlayers];
		int playerNum;
		for(int i=0; i<4; i++) {
			playerNum = i+1;
			System.out.println("Player " + playerNum + " Name: ");
			String playerName = sc.nextLine();
			players[i] = new player.Player(playerName, drawPile, playerNum);
		}
		return players;
	}

	public static void main(String[] args) {
		System.out.println("***** Welcome to UNO! *****");
		
		utilClasses.DeckInitializer deckInitializer = new utilClasses.DeckInitializer();
		pile.DrawPile drawPile = deckInitializer.getDrawPile();
		pile.DiscardPile discardPile = deckInitializer.getDiscardPile();
		
		Scanner sc = new Scanner(System.in);
		
		player.Player[] players = createPlayers(4, sc, drawPile);
		
		
	}

}
