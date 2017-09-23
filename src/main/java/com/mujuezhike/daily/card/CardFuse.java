package com.mujuezhike.daily.card;

import java.util.Random;

public class CardFuse {

	public static void main(String[] args) {
		Card c1 = new Card("100000");
		System.out.println(c1.printCode());
		Card c2 = new Card("000000");
		System.out.println(c2.printCode());
		Card c3 = CardFuse.fuse(c1, c2);
		System.out.println(c3.printCode());
	}
	
	public static Card fuse(Card c1,Card c2){
		
	    int[] cc1 = c1.getCardCode();
	    int[] cc2 = c2.getCardCode();
	    
	    Random rd = new Random();
	   
	    String mx = "";
	    for(int i=0;i<6;i++){
	    	int[] ed = CrossEnums.findByCode(cc1[i], cc2[i]).getRcode();
	    	int m = rd.nextInt(ed.length);
	    	int cx = ed[m];
	    	mx += cx + "";
	    }
	    Card cmix = new Card(mx);
		return cmix;
		
	}

}
