import java.util.Scanner;

public class MainGame {
	
	static player.Player[] createPlayers(int numPlayers, Scanner sc, pile.DrawPile drawPile, pile.DiscardPile discardPile) {
		player.Player[] players = new player.Player[numPlayers];
		int playerNum;
		for(int i=0; i<4; i++) {
			playerNum = i+1;
			System.out.println("Player " + playerNum + " Name: ");
			String playerName = sc.nextLine();
			players[i] = new player.Player(playerName, playerNum, discardPile, drawPile);
		}
		return players;
	}

	public static void main(String[] args) {
		System.out.println("***** Welcome to UNO! *****");
		
		utilClasses.DeckInitializer deckInitializer = new utilClasses.DeckInitializer();
		final pile.DrawPile drawPile = deckInitializer.getDrawPile();
		final pile.DiscardPile discardPile = deckInitializer.getDiscardPile();
		
		Scanner sc = new Scanner(System.in);
		
		player.Player[] players = createPlayers(4, sc, drawPile, discardPile);
		player.Player currentPlayer;
		
		int startingPlayerNumber = 0, currentPlayerNumber = startingPlayerNumber;
		
		System.out.println("Let's begin!");
		
		while(true) {			
			card.Card topCard = discardPile.returnTopCard();
			currentPlayer = players[currentPlayerNumber];
			topCard.displayCard();
			
			if(topCard.getCardType().equals("Normal")) {
				currentPlayer.start();
			}
			
			if(currentPlayer.numCardsLeft()==0) {
				break;
			}
			currentPlayerNumber = (currentPlayerNumber+1)%4;
		}
		
		System.out.println("Winner: ");
//		player[currentPlayer-1]
		
	}

}
