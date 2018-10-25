import java.util.*;
public class Play {
	private ArrayList<Card> thePlay;
	private boolean isStraight, isBomb, isPair;
	
	public Play(){
		thePlay = new ArrayList<Card>();
		isStraight = false;
		isBomb = false;
		isPair = false;
	}
	public Play(ArrayList<Card> p){
		
		thePlay = p;
		isStraight = isStraight(p);
		isBomb = isBomb(p);
		isPair = isPair(p);
		
	}
	
	private boolean isBomb(ArrayList<Card> p){
		
		if(p.size() == 4){
			//System.out.println("isBomb: "+ (p.get(0).getValue() == p.get(1).getValue() && p.get(2).getValue() == p.get(1).getValue() && p.get(3).getValue()==p.get(2).getValue()));
			return (p.get(0).getValue() == p.get(1).getValue() && p.get(2).getValue() == p.get(1).getValue() && p.get(3).getValue()==p.get(2).getValue());
		}
		//System.out.println("isBomb: "+false);
		return false;
	}
	
	private boolean isStraight(ArrayList<Card> p){
		Collections.sort(p, new SortByCard());
		//System.out.println(p);
		if(p.size() > 2){
			
			for(int i=0; i < p.size() - 1; i++){
				
				if(p.get(i).getValue() != p.get(i+1).getValue() -1)
				{
					//System.out.println("isStraight: "+false);
					return false;
			
				}
			}
			//System.out.println("isStraight: "+true);
			return true;
		}
		//System.out.println("isStraight: "+false);
		return false;
					
	}
	
	private boolean isPair(ArrayList<Card> p){
		if(p.size() == 1)
			return true;
		int val = p.get(0).getValue();
		for(int i = 1; i < p.size(); i++){
			if(val!=p.get(i).getValue()){
			//	System.out.println("isPair: " +false);
				return false;
			}
		}
	  //System.out.println("isPair: " + true);
		return true;
		
	}
	
	
	public boolean isStraight(){
		return isStraight;
	}
	public boolean isBomb(){
		return isBomb;
	}
	public boolean isPair(){
		return isPair;
	}
	public ArrayList<Card> getPlay(){

		return thePlay;
	}
	
	/*
	 * Param - Play to be checked
	 * Returns whether or not Play is a valid play 
	 * i.e. either a single, pair, straight, or bomb
	 * 
	 */
	private boolean isPlay(){
		if(thePlay.size() < 2)
			return true;
		return (isStraight || isBomb || isPair);
		
	}
	/*
	 * Param user desired play
	 * Returns if play can be placed in relation to 
	 */
	public boolean isValid(Play p){
		if(p.isPlay())
		{
			if (thePlay.size() == 0)
				return true;
			
			if(p.isBomb())
			{
				if(isBomb)
					return compareBombs(p);
				return true;
			}
			
			if(p.isStraight())
			{
				if(isStraight && p.getPlay().size() == thePlay.size())
					return compareStraights(p);
				return false;
			}
			
			
		return comparePairs(p);
		}
		return false;
	}
	private boolean compareBombs(Play p){
		
		return thePlay.get(0).getValue() < p.getPlay().get(0).getValue();
		
	}
	
	private boolean compareStraights(Play p){
		
		return thePlay.get(thePlay.size()-1).getValue() < p.getPlay().get(p.getPlay().size()-1).getValue();
	}
	//for cards of same number, 1 card, 2 cards, 3 cards
	private boolean comparePairs(Play p){
		if(p.getPlay().size() == thePlay.size()) {
			ArrayList<Card> pPlay = p.getPlay();
			Collections.sort(pPlay, new SortByCard());
			Collections.sort(thePlay, new SortByCard());
			return thePlay.get(thePlay.size()-1).compareTo(pPlay.get(pPlay.size()-1)) < 0; 
		}
		return false; 
	}
	
	public String toString(){
		
		return thePlay.toString();
		
	}
	
}
