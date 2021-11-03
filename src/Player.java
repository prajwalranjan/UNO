import java.util.*;

public class Player {
	private String playerName;
	private List<Card> playerHand = new ArrayList<Card>();
	@SuppressWarnings("unused")
	private int playerNumber;
	
	Player(String name, DrawPile deck, int playerNumber) {
		this.playerName = name;
		this.playerNumber = playerNumber;
		for(int i=0; i<7; i++) {
			this.playerHand.add(deck.returnTopCard());
		}
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void displayPlayerInfo() {
		System.out.println("Player name: " + this.playerName);
		System.out.println("Number of cards left: " + this.playerHand.size());
	}
	
	public void pickCard(DrawPile deck) {
		this.playerHand.add(deck.returnTopCard());
	}
	
	public void removeCard(DiscardPile discardDeck, int pos) {
		discardDeck.discardDeck.add(this.playerHand.remove(pos));
	}
	
	public int checkForValidCard(DiscardPile discardDeck) {
		Card topCard = discardDeck.returnTopCard();
		
		String topCardType = topCard.getCardType();
		String topCardColor = topCard.getCardColor();
		String topCardAttr = topCard.getCardDetails();
		
		for(int i=0; i<this.playerHand.size(); i++) {
			Card c = this.playerHand.get(i);
			
			String cType = c.getCardType();
			String cColor = c.getCardColor();
			String cAttr = c.getCardDetails();
			
			if(cType.equals(topCardType) || cColor.equals(topCardColor) || cAttr.equals(topCardAttr)) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	
}
