package pile;
import java.util.*;

import card.Card;

public class DiscardPile {
	public Stack<card.Card> discardDeck;
	public String topColor;
	
	public DiscardPile() {
		this.discardDeck = new Stack<card.Card>();
	}
	
	public DiscardPile(card.Card c) {
		this.discardDeck = new Stack<card.Card>();
		this.discardDeck.add(c);
	}
	
	public card.Card returnTopCard() {
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
