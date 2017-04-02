import java.util.Arrays;

public class TokenPass {

	private int[] board;
	private int currentPlayer;
	
	/** Creates the board array to be of size PlayerCount and fills it with 
	 *  random integer values from 1 to 10, inclusive.  Initalizes currentPlayer to a 
	 *  random integer value in teh range between 0 and playerCount - 1, inclusive. 
	 *  @param playerCount the number of players. 
	 *  
	 */
	public TokenPass(int playerCount) {
		
		board = new int[playerCount];
		
		for (int i = 0; i < board.length; i++) 
			board[i] = (int)(Math.random()*10) + 1;
		
		currentPlayer = (int)(Math.random()*playerCount);
		
		
		
	}
	
	/** Distributes te tokens from th currnt player's position one at a time to each player in
	 *  the game. Distribution begins with te next position and continues until all the tokens 
	 *  have been distributed.  If there are still tokens to be distributed when the player at 
	 *  the highest position is reached, the next token will be distributed to the player at 
	 *  position 0.
	 *  Preconditions: the current player has at least one token. 
	 *  Postcondition: the current player has not changed.
	 */
	public void distributeCurrentPlayerTokens() {
		
		
		int tokens = board[currentPlayer];
		board[currentPlayer] = 0;
		int location = currentPlayer + 1;
		
		while (tokens > 0) {
		
			//if (location >= board.length)
			//	location = 0;
			
			board[location] = board[location] + 1;
			tokens = tokens - 1;
			//location = location + 1;
			
			//Alternate
			location = (location + 1)%board.length;
			
			
			
		}
		
	}
	
	public String toString() {
		return Arrays.toString(board)+" Turn: "+currentPlayer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TokenPass game = new TokenPass(10);
		System.out.println(game);
		game.distributeCurrentPlayerTokens();
		System.out.println(game);
		
	}

}
