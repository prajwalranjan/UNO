package pile;
import java.util.*;

import card.Card;

public class DrawPile {
	private Stack<Card> cardsPile = new Stack<Card>();
	
	public DrawPile(ArrayList<Card> cards) {
		for(Card c: cards) {
			this.cardsPile.add(c);
		}
	}
	
	public Card returnTopCard() {
		return this.cardsPile.pop();
	}
	
	public void addCard(Card c) {
		this.cardsPile.add(c);
	}
}
