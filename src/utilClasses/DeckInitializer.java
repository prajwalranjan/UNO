package utilClasses;

import java.util.ArrayList;
import java.util.Collections;

public class DeckInitializer {
	
	static public pile.DiscardPile discardPile;
	static private pile.DrawPile drawPile;
	
	public ArrayList<card.NormalCard> createNormalCards() {
		ArrayList<card.NormalCard> normalCards = new ArrayList<card.NormalCard>();
		
		String[] colors = {"Yellow", "Red", "Blue", "Green"};
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(String color: colors) {
			for(String number: numbers) {
				card.NormalCard normalCard = new card.NormalCard(color, number);
				normalCards.add(normalCard);
			}
		}
		
		return normalCards;
	}
	
	public ArrayList<card.SpecialCard> createSpecialCards() {
		ArrayList<card.SpecialCard> specialCards = new ArrayList<card.SpecialCard>();
		
		for(int i=0; i<4; i++) {
			card.SpecialCard draw4 = new card.SpecialCard("Black", "Draw4");
			specialCards.add(draw4);
		}
		
		for(int i=0; i<4; i++) {
			card.SpecialCard wild = new card.SpecialCard("Black", "Wild");
			specialCards.add(wild);
		}
		
		String[] colors = {"Yellow", "Red", "Blue", "Green"};
		String[] attributes = {"Reverse", "Skip", "Draw2"};
		
		for(String color: colors) {
			for(String attr: attributes) {
				card.SpecialCard specialCard = new card.SpecialCard(color, attr);
				specialCards.add(specialCard);
			}
		}
		
		return specialCards;
	}
	
	public pile.DrawPile createDrawPile(ArrayList<card.SpecialCard> specialCards, ArrayList<card.NormalCard> normalCards) {
		ArrayList<card.Card> cardsDeck = new ArrayList<card.Card>();
		
		for(card.NormalCard nc: normalCards) {
			cardsDeck.add(nc);
		}
		
		for(card.SpecialCard sc: specialCards) {
			cardsDeck.add(sc);
		}
		
		Collections.shuffle(cardsDeck);
		
		pile.DrawPile drawPile = new pile.DrawPile(cardsDeck);
		
		return drawPile;
	}
	
	public DeckInitializer() {
		this.drawPile = this.createDrawPile(this.createSpecialCards(), this.createNormalCards());
		this.discardPile = new pile.DiscardPile();
	}
	
	public pile.DrawPile getDrawPile() {
		return this.drawPile;
	}
	
	public pile.DiscardPile getDiscardPile() {
		return this.discardPile;
	}
}
