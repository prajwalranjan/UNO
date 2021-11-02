import java.util.*;

public class DiscardPile {
	public Stack<Card> discardDeck = new Stack<Card>();
	
	DiscardPile(Card c) {
		this.discardDeck.add(c);
	}
	
	public Card returnTopCard() {
		return this.discardDeck.lastElement();
	}
}
