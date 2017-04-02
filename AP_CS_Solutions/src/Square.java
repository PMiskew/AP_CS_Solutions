
public class Square {

	private boolean isBlack;
	private int num;
	
	/**	IMPLEMENTATON NOT SHOWN:	You must use this constructor in the question, but 
	 * 								the implementation is not shown 
	 * 
	 * 	Constructs one square of a crossword puzzle grid.
	 * 	Postcondition:
	 * 		- The square is black if and only if isBlack is true
	 * 		- The square has number num.
	 */
	public Square(boolean isBlack, int num) {
	
		//THEORY:  	For this question I had to include two fields which are now shown in the
		//			original code.  Notice that the field names and local variable names match. 
		//			This is okay as long as you remember that in order to access the fields you 
		//			have to use the this.isBlack.  Otherwise the compiler accesses hte local 
		//			variable version
		this.isBlack = isBlack;
		this.num = num;
	}
	
	/**
	 * NOT REQUIRED: The toString method has been written to help testing. 
	 */
	public String toString(){
		
		if (isBlack) return "X\t";
		if (num == 0) return "_\t";
		else return num+"\t";
		
	}

	//	There may be instance variables, constructors, and methods that are not shown.  
}
