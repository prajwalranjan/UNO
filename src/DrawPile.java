import java.util.*;

public class DrawPile {
	private Stack<Card> cardsPile = new Stack<Card>();
	
	DrawPile(ArrayList<Card> cards) {
		for(Card c: cards) {
			this.cardsPile.add(c);
		}
	}
	
	public Card returnTopCard() {
		return this.cardsPile.pop();
	}
}
