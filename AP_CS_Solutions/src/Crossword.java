
public class Crossword {
	/**	Each element is a Square object with a color (black or white) and a number.
	 * 	puzzle[r][c] represents the square in row r, column c.
	 * 	There is at least ne row in the puzzle. 
	 */
	private Square[][] puzzle;
	
	/**	
	 * This is a solution to AP Free Response 2016 #3b
	 * Constructs a crossword puzzle grid.
	 * 	Precondition: There is at least one row in blackSquares.
	 * 	Postcondition:
	 * 		-	The crossword puzzle grid has the same dimensions as blackSquares
	 * 		-	The Square object at row r, column c in the crossword puzzle grid is black
	 * 			if and only if blackSquares[r][c] is true. 
	 * 		-	The squares in the puzzle are labeled according to the crossword labeling rule. 
	 */
	public Crossword(boolean[][] blackSquares) {
		
		int rows = blackSquares.length;
		int cols = blackSquares[0].length;
		
		int ctr = 1;
		
		//CRITICAL:	The field only declares the 2D array puzzle.  It must be constructed.  
		puzzle = new Square[rows][cols];
		
		//TECHNIQUE:	The below nested loop is the standard form to traverse a 2D array moving
		//				across the rows.  Using r and c is recommended as it is easier to visualize
		//				and prepares students for learning about matricies in mathematics, which
		//				are notated [row][column].  
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				
				if (toBeLabeled(r,c,blackSquares)) {
					//CRITICAL:	The program MUST construct each object in the 2D array.
					puzzle[r][c] = new Square(false,ctr);  //number required isBlack is false and assign ctr. 
					ctr = ctr + 1; //increment ctr to get next number. 
				}
				else{
					puzzle[r][c] = new Square(blackSquares[r][c],0);  //No number assign num to 0
				}
			}
		}
		
		
	}
	
	/**
	 * This is a solution to AP Free Response 2016 #3a
	 * Returns true if the square at row r, column c should be labeled with a positive number;
	 * 			false otherwise. 
	 * 	The square at row r, column c is black if and only if blackSquares[r][c] is true. 
	 *  Precondition: r and c are valid indexes in blackSquares.
	 */
	public boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
		
		//Solution 1: Good
		
		/*
		//Case 1: If the square is black return false always.
		if (blackSquares[r][c] == true) return false;
		
		//Case 2: If r and c are both greater than zero check if either is a black square 
		if (r > 0 && c > 0) 
			return (blackSquares[r - 1][c] || blackSquares[r][c - 1]);
		
		//Case 3: If r is 0 we only check (All non black squares on top row have numbers)
		if (r == 0)
			return true;
		
		//Case 4: This is only reached is c = 0 so we return true. 
		return true;
		//*/
		
		/*
		//Solution 2: Better
		 *CRITICAL:	This approach leverages short circuiting in conditional statements.  
		 *			This is an optimization technique and is often used to avoid runtime errors. 
		 *			
		 *			Given:
		 *				if (A and B) {
		 *					//CODE
		 *				}
		 *
		 *			B will only be evaluated if A is true since.  This is particularly useful 
		 *			when dealing with string checks 
		 *			
		 *			Example:
		 * 				String str = <Some string>
		 * 				if (str.length() > 0 && str[0] == 'P') {
		 * 					//CODE
		 * 				}
		 * 
		 * 			str[0] will cause an index out of bounds error if str is empty.  If str is 
		 * 			empty str.lenght > 0 will evaluate to false meaning str[0] == 'P' will not
		 * 			be tested.
		 * 
		 *  		Given:
		 *  			if (A or B) {
		 *  				//CODE
		 *  			}
		 *  		
		 *  		B will not be evaluated if A is true since B being true or false has no 
		 *  		impact. 
		 */
		return !blackSquares[r][c] && (r == 0 || blackSquares[r-1][c] || c == 0 || blackSquares[r][c-1]);
		//*/
				
	}
	
	
	public String toString(){
		
		//TECHNIQUE:	Using tring construction in a toString method allows more complex strings
		//				to be generated and returned.
		String board = "";
		
		for (int r = 0; r < puzzle.length; r++) {
			for (int c = 0; c < puzzle[r].length; c++) {
				board = board + puzzle[r][c].toString();
			}
			//TECHNIQUE:	To add a new line to a string being constructed use the escape code
			//				\n
			board = board + "\n";
		}
			
		return board;
		
	}

	/*
	 * The main method has been writen for testing purposes. 
	 */
	public static void main(String[] args) {
		
		boolean[][] blackSquares = {
			{true,	false,	false,	true,	true,	true,	false,	false,	false},
			{false,	false,	false,	false,	true,	false,	false,	false,	false},
			{false,	false,	false,	false,	false,	false,	true,	true,	true},
			{false,	false,	true,	false,	false,	false,	true,	false,	false},
			{true,	true,	true,	false,	false,	false,	false,	false,	false},
			{false,	false,	false,	false,	true,	false,	false,	false,	false},
			{false,	false,	false,	true,	true,	true,	false,	false,	true},
			};
		
		for (int r = 0; r < blackSquares.length; r++) {
			for (int c = 0; c < blackSquares[r].length; c++) {
				if (blackSquares[r][c] == false)
					System.out.print(" _ ");
				else 
					System.out.print(" X ");
				
			}
			System.out.println("");
		}
			
		Crossword game = new Crossword(blackSquares);
		System.out.println("\n\n");
		System.out.println(game);
			
			
			
			
			
	}
}
