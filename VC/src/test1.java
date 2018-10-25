import TerminalIO.*;
import java.util.*;
public class test1 {

	
	public static void main(String[] args){
		KeyboardReader kb = new KeyboardReader();
		Deck gameDeck = new Deck();
		ArrayList<Hand> fourHands = new ArrayList<Hand>();
		for(int i = 0; i < 4; i++){
			fourHands.add(gameDeck.getHand());
		}
		 //declare inside loop
		int firstPlayer = 0;
		for(int j = 0; j < fourHands.size(); j++){
			if(fourHands.get(j).hasAceSpades())
				firstPlayer = j;
		}
		
		kb.readLine("Hello and welcome to the VC card game... you can either select to play\n"
				+"solo against three (primitive) computers or \nbe social and play with three other humans. (Press Enter)");
		int gameType = kb.readInt("Enter\n1 for PC\n2 for Humans\n"); //invalid input later	
		int rounds = 0;
		boolean hasWon = false;
		
		game:
		while(!hasWon){
			if(gameType == 1)
			{
				rounds++;
				if(rounds == 1)
					System.out.println("You are playing against three computers... Good luck!\n");
				System.out.println("Round "+(rounds)+" is going to begin\n");
				int passes = 0;
				Play thePlay = new Play();
				int player = firstPlayer;
				round:
				while(passes != 3)
				{	
					
					
					for(int n = 0; n < 4; n++){
						if(n == 0)
							System.out.println("\nYou have "+fourHands.get(n).size() +" cards left");
						else
							System.out.println("Player " + (n) + " has " +fourHands.get(n).size() + " cards left.");
					}
					
					
					
					for (int k = 0; k < 4; k++)
					{	
						System.out.println("\nThis is the current play: \n"+thePlay);
						System.out.println("\nThere are " + passes + " pass(es) made\n");
						if(player == 0)
						{
							if(k ==0 && firstPlayer == 0 && rounds == 1)
								System.out.println("You have the three of spades... you get to go first!\n");
							else if(firstPlayer == 0 && k == 0)
								System.out.println("You won the last round, you get to go first\n");
							else
								System.out.println("It is your turn...\n");
							Play myPlay = new Play();
							boolean isPass = false;
							
							makingMove:
							do{
								ArrayList<Integer> myMove = new ArrayList<Integer>();
								int num = 0, moveNum = -3;
								while (num != -1){
									System.out.println(fourHands.get(0));
									num = kb.readInt("Please enter in your play by selecting each card once through the number designated on the far left.\n"
											+"Enter -1 to finish move or -2 to pass\n");
									
									if(num == -2){
										System.out.println("You have passed \n");
										isPass = true;
										passes++;
										if(passes == 3){
											System.out.println("There have been three passes\nPlayer "+firstPlayer+ " has won the round.\n");
											break round;
										}
										break makingMove;
									}
									if(num == -1 && myMove.size() > 0){
										System.out.println("You have finished making your move\n");
										break;
									}
									if(num == moveNum){
										System.out.println("Sorry, that card has already been selected for your move\n");
									}
									else if(num < 0 || num > 12)
										System.out.println("Invalid input\n");
									else 
									{	
										myMove.add(num);
										moveNum = num;
									}
								}
								if(myMove.size() > 0 && !isPass)
								{
									myPlay=fourHands.get(0).makePlay(myMove);
									passes=0;
									if(!thePlay.isValid(myPlay)){
										System.out.println("Sorry, that move is not possible\n");
									}
								}
								//else
									//break;
							}while(!thePlay.isValid(myPlay));
							
							if(!isPass)
							{
								thePlay = myPlay;
								fourHands.get(0).removePlay(myPlay);
								firstPlayer = 0;
								System.out.println("You have played:\n"+myPlay);
								if( fourHands.get(0).isWin())
								{
									System.out.println("CONGRATS! YOU HAVE WON THE GAME!!!!");
									hasWon=!hasWon;
									break game;
								}
						
							}
						//	else 
							//	passes++;
						}
						else
						{
							if(k == 0 && player == firstPlayer && rounds == 1)
								System.out.println("Player "+player+" has the three of spades... they get to go first!\n");
							else if(k ==0 && player == firstPlayer)
								System.out.println("Player "+player+" has won the last round, they get to go first\n");
							else
								System.out.println("It is player " + player+"'s turn\n");
							Play pcPlay = new Play();
							boolean isPass = false;
							int numTries = 0;
							do{
								numTries++;
								pcPlay = fourHands.get(player).makePlay();
								if(numTries > 1000)
								{
									isPass = !isPass;
									passes++;
									System.out.println("Player " +player+ " has passed\n");
									if(passes == 3){
										System.out.println("There have been three passes\nPlayer "+firstPlayer+ "has won the round.\n");
										break round;
									}
									break;
								}
							}while(!thePlay.isValid(pcPlay));
							
							if(!isPass)
							{
								thePlay = pcPlay;
								fourHands.get(player).removePlay(pcPlay);
								passes=0;
								firstPlayer=player;
								System.out.println("Player " + player + " has played:\n"+pcPlay);
								if(fourHands.get(player).isWin())
								{
									System.out.println("Player "+player+" has won the game!\nBetter luck next time.");
									hasWon=!hasWon;
									break game;
								}
							}
						//	else
							//	passes++;
						}
						player++;
						player%=4;
						
					}
				}
				
				
				
				
			}
			else if(gameType == 2)
			{
				rounds++;
				if(rounds == 1)
					System.out.println("This is a match between four humans... Good luck!\n");
				System.out.println("Round "+(rounds)+" is going to begin\n");
				int passes = 0;
				Play thePlay = new Play();
				int player = firstPlayer;
				round:
				while(passes != 3)
				{	
					
					
					for(int n = 0; n < 4; n++){
							System.out.println("Player " + (n) + " has " +fourHands.get(n).size() + " cards left.");
					}
					
					
					
					for (int k = 0; k < 4; k++)
					{	
						System.out.println("\nThis is the current play: \n"+thePlay);
						System.out.println("\nThere are " + passes + " pass(es) made\n");
						//if(player == 0){
						
							if(k ==0 && player == firstPlayer && rounds == 1)
								System.out.println("Player "+player+" has the three of spades... they get to go first!\n");
							else if(k ==0 && player == firstPlayer)
								System.out.println("Player "+player+" won the last round, they get to go first\n");
							else
								System.out.println("It is player "+player+"'s turn...\n");
							Play myPlay = new Play();
							boolean isPass = false;
							
							makingMove:
							do{
								ArrayList<Integer> myMove = new ArrayList<Integer>();
								int num = 0, moveNum = -3;
								while (num != -1){
									System.out.println(fourHands.get(player));
									num = kb.readInt("Please enter in your play by selecting each card once through the number designated on the far left.\n"
											+"Enter -1 to finish move or -2 to pass\n");
									
									if(num == -2){
										System.out.println("Player "+player+" has passed \n");
										isPass = true;
										passes++;
										if(passes == 3){
											System.out.println("There have been three passes\nPlayer "+firstPlayer+ " has won the round.\n");
											break round;
										}
										break makingMove;
									}
									if(num == -1 && myMove.size() > 0){
										System.out.println("You have finished making your move\n");
										break;
									}
									if(num == moveNum){
										System.out.println("Sorry, that card has already been selected for your move\n");
									}
									else if(num < 0 || num > 12)
										System.out.println("Invalid input\n");
									else 
									{	
										myMove.add(num);
										moveNum = num;
									}
								}
								if(!isPass && myMove.size() > 0)
								{
									myPlay=fourHands.get(player).makePlay(myMove);
									passes=0;
									if(!thePlay.isValid(myPlay)){
										System.out.println("Sorry, that move is not possible\n");
									}
								}
								//else
									//break;
							}while(!thePlay.isValid(myPlay));
							
							if(!isPass)
							{
								thePlay = myPlay;
								fourHands.get(player).removePlay(myPlay);
								firstPlayer = player;
								System.out.println("Player "+player+" has played:\n"+myPlay);
								if( fourHands.get(player).isWin())
								{
									System.out.println("CONGRATS! PLAYER" +player+" HAS WON THE GAME!!!!");
									hasWon=!hasWon;
									break game;
								}
						
							}
						//	else 
							//	passes++;
						//}
						player++;
						player%=4;
					}
				}
			}
			else 
				System.out.println("Input error, restart game");
			
			
			
			
		}
		
		
	}
}
