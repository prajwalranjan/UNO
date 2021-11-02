
public class SpecialCard implements Card {
	private String cardColor;
	private String cardAttribute;
	private String cardType = "Special";
	
	SpecialCard(String color, String attribute) {
		this.cardColor = color;
		this.cardAttribute = attribute;
	}
	
	public void displayCard() {
		System.out.println("Card color: " + this.cardColor);
		System.out.println("Card attribute: " + this.cardAttribute);
	}
	
	public String getCardColor() {
		return this.cardColor;
	}
	
	public String getCardDetails() {
		return this.cardAttribute;
	}
	
	public String getCardType() {
		return this.cardType;
	}
}
