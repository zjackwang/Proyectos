import java.util.ArrayList;

import TerminalIO.*;
public class test2 {
	
	public static void main(String[] args){
		KeyboardReader kb = new KeyboardReader();
		Deck gameDeck = new Deck();
		
		Hand myHand = gameDeck.getHand();
		Play defPlay = new Play();
		System.out.println(myHand);
		
		
		
		
		Play pcPlay = new Play();
		boolean isPass = false;
		int numTries = 0;
		do{
			numTries++;
			pcPlay = myHand.makePlay();
			if(numTries > 1000)
			{
				isPass = !isPass;
				//passes++;
				//if(passes == 3)
				//	break round;
				break;
			}
		}while(!defPlay.isValid(pcPlay));
		System.out.println(pcPlay);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*ArrayList<Integer> myMove = new ArrayList<Integer>();
		int num = 0;
		while (num != -1){
			System.out.println(myHand);
			num = kb.readInt("Please enter in your play by selecting each card once through the number designated on the far left.\n"
					+"Enter -1 to finish move or -2 to pass\n");
			if(num == -2){
				System.out.println("You have passed \n");
				break;
			}
			if(num == -1){
				System.out.println("You have finished making your move\n");
				break;
			}
			if(num < 0)
				System.out.println("Invalid input\n");
			else 
				myMove.add(num);
		}
		Play tempPlay = myHand.makePlay(myMove);
		/*System.out.println(tempPlay.isStraight(tempPlay.getPlay()));
		System.out.println(defPlay.isValid(tempPlay));
		*/
	}
}
