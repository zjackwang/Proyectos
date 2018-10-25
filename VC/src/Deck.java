import java.util.*;

public class Deck {

	private ArrayList<Card> theDeck;
	private int numHands; 
	
	public Deck(){
		theDeck = new ArrayList<Card>();
		numHands = 0; 
		
		for(int i = 0; i < 4; i++){
			for(int j = 1; j < 14; j++){
				if(i == 0){
					theDeck.add(new Card("Hearts", j));
				}
				if(i == 1){
					theDeck.add(new Card("Diamonds", j));
				}
				if(i == 2){
					theDeck.add(new Card("Clubs", j));
				}
				if(i == 3){
					theDeck.add(new Card("Spades", j));
				}
			}
		}
		Collections.shuffle(theDeck);
	}
	
	//get four hands for game 
	public Hand getHand(){
		
		ArrayList<Card> myCards = new ArrayList<Card>();
		for(int i = 13*numHands; i < (13*numHands)+13; i++){ // gets cards 0 - 12, 13 - 25, 26 - 38, 39 - 51
			
			myCards.add(theDeck.get(i));
		}
		numHands++;
		
		return new Hand(myCards);
		
	}
}
