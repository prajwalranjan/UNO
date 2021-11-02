
public class NormalCard implements Card {
	private String cardColor;
	private String cardNumber;
	private String cardType = "Normal";
	
	NormalCard(String color, String number) {
		this.cardColor = color;
		this.cardNumber = number;
	}
	
	public void displayCard() {
		System.out.println("Card color: " + this.cardColor);
		System.out.println("Card number: " + this.cardNumber);
	}
	
	public String getCardColor() {
		return this.cardColor;
	}
	
	public String getCardDetails() {
		return this.cardNumber;
	}
	
	public String getCardType() {
		return this.cardType;
	}
}
