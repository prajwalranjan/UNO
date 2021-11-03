import java.util.*;

public class DiscardPile {
	public Stack<Card> discardDeck = new Stack<Card>();
	public String topColor;
	
	DiscardPile(Card c) {
		this.discardDeck.add(c);
	}
	
	public Card returnTopCard() {
		return this.discardDeck.lastElement();
	}
	
	public void setNewTopColor(String newColor) {
		this.topColor = newColor;
	}
	
	public void displayTopCard() {
		System.out.println("Color of last card: " + this.topColor);
		System.out.println("Number/Attribute on last card: " + this.returnTopCard().getCardDetails());
	}
}
