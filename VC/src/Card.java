
public class Card {
	
	private String suit;
	private int value, num, tiebreakerVal;
	
	public Card(String s, int n){
		
		suit = s;
		num = n;
		value = num;
		if( num < 3 )
			value+=13;
		if(suit.equals("Hearts"))
			tiebreakerVal = 4;
		else if(suit.equals("Diamonds"))
			tiebreakerVal = 3;
		else if(suit.equals("Clubs"))
			tiebreakerVal = 2;
		else if(suit.equals("Spades"))
			tiebreakerVal = 1;
		
	}
	
	public String toString(){
		if(num == 11)
			return "Jack of " + suit;
		else if (num == 12)
			return "Queen of " + suit;
		else if (num == 13)
			return "King of " + suit;
		return num + " of " + suit;	
	}
	
	public int compareTo(Card c){
			
		if(value != c.getValue()){
			return (value > c.getValue())?(1):(-11);
		}
		else if (tiebreakerVal != c.getTieBreakerVal()) {
			return (tiebreakerVal > c.getTieBreakerVal())?(1):(-1);
		}
		return 0; 
	
	}
	
	public int getValue(){
		
		return value;
		
	}
	
	public String getSuit(){
		
		return suit;
	}
	
	public int getTieBreakerVal(){
		
		return tiebreakerVal;
	}
}
