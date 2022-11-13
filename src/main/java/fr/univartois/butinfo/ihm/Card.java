package fr.univartois.butinfo.ihm;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;



public class Card {

	private final  BooleanProperty card;
	private final BooleanProperty pinned;
	private final IntegerProperty paire;
	
	public Card(boolean card, boolean pinned,int paire) {
   	 this.card = new SimpleBooleanProperty(card);
   	 this.pinned=new SimpleBooleanProperty(pinned);
   	 this.paire=new SimpleIntegerProperty(paire);
   }
	public void startGame() {
	        controller.initCount();
	  }
	public void  incNbRevealedPairs() {
		
		
	}

		
}
