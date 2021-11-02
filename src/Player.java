import java.util.*;

public class Player {
	private String playerName;
	private List<Card> playerHand = new ArrayList<Card>();
	
	Player(String name, DrawPile deck) {
		this.playerName = name;
		for(int i=0; i<7; i++) {
			this.playerHand.add(deck.cardsPile.pop());
		}
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void displayPlayerInfo() {
		System.out.println("Player name: " + this.playerName);
		System.out.println("Number of cards left: " + this.playerHand.size());
	}
	
	public boolean checkForValidCard(DiscardPile discardDeck) {
		Card topCard = discardDeck.returnTopCard();
		String topCardType = topCard.getCardType();
		String topCardColor = topCard.getCardColor();
		String topCardAttr = topCard.getCardDetails();
		
		return false;
	}
}
