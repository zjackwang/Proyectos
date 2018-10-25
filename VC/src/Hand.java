import java.util.*;
public class Hand {
	
	private ArrayList<Card> theHand; 
	
	//gets hand from deck.getHand()
	public Hand(ArrayList<Card> list){
		
		theHand=list;
	}
	//returns card from hand 
	public Card getCard(int i){
		
		return theHand.get(i);
	}
	
	public String toString(){
		
		String display = "This is your hand: \n";
		for(int i = 0; i < theHand.size(); i++){
			
			display += i + ". " + theHand.get(i) + "\n"; 
		}
		
		return display;
	}
	//returns play made 
	public Play makePlay(ArrayList<Integer> cardNums){
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int i = 0; i<cardNums.size(); i++){
			cards.add(theHand.get(cardNums.get(i)));
		}
		return new Play(cards);
	}
	//returns automated play 
	public Play makePlay(){
		ArrayList<Card> cards = new ArrayList<Card>();
		int numCards = (int)(Math.random()*6)+1;
		Collections.shuffle(theHand);
		for(int i = 0; i<numCards; i++){
			cards.add(theHand.get(i));
		}
		
		return new Play(cards);
		
	}
	public boolean hasAceSpades(){
		
		for(int i = 0; i < theHand.size(); i++){
			if(theHand.get(i).compareTo(new Card("Spades", 3)) == 0)
				return true;
		}
		return false;
		
	}
	
	public void removePlay(Play p){
		
		for(int i = 0; i < p.getPlay().size(); i++){
			theHand.remove(p.getPlay().get(i));
			
		}
	}
	public boolean isWin(){
			
			return theHand.size() == 0;
		}

	public int size(){
		
		return theHand.size();
	}
}
