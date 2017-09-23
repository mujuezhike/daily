package com.mujuezhike.daily.card;

public class Card {

	private int[] cardCode;
	
	private String cardCodeStr;
	
	private String cardName;
	
	public Card(){
		
	}
	
	public Card(String cardCodeStr){
		
		this.setCardCodeStr(cardCodeStr);
		
		int[] itscardCode = new int[6];
		itscardCode[0] = Integer.parseInt(cardCodeStr.substring(0, 1));
		itscardCode[1] = Integer.parseInt(cardCodeStr.substring(1, 2));
		itscardCode[2] = Integer.parseInt(cardCodeStr.substring(2, 3));
		itscardCode[3] = Integer.parseInt(cardCodeStr.substring(3, 4));
		itscardCode[4] = Integer.parseInt(cardCodeStr.substring(4, 5));
		itscardCode[5] = Integer.parseInt(cardCodeStr.substring(5, 6));
		
		this.setCardCode(itscardCode);
		
	}

	public String getCardCodeStr() {
		return cardCodeStr;
	}

	public void setCardCodeStr(String cardCodeStr) {
		this.cardCodeStr = cardCodeStr;
	}

	public int[] getCardCode() {
		return cardCode;
	}

	public void setCardCode(int[] cardCode) {
		this.cardCode = cardCode;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public String printCode(){
		
		String r = "";
		for(int p=0;p<6;p++){
		
			CardEnums cm = CardEnums.findByCode(cardCode[p]);
			r += "["+cm.getMessage()+"]";
			
		}
		
		return r;
	}
}
