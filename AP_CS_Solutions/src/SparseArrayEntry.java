/**
 * This is a solution to question 3 from the 2015 AP Computer Science
 * exam.  Note that some additional code has been added to allow for 
 * testing.  
 * @author PMiskew
 *
 */
//THIS ENTIRE FILE IS ONLY USED IN THE QUESTON, NOT MODIFIED
public class SparseArrayEntry {

	/** The row index and column index for this entry in the sparse array */
	private int row;
	private int col;
	
	/** The value of this entry in the sparse array */
	private int value;
	
	/** Constructs a SparseArrayEntry object that represents a sparse array element
	 * 	with row index r and column index c, containing value v.
	 * 
	 */
	public SparseArrayEntry(int r, int c, int v) {
		row = r;
		col = c;
		value = v;
		
	}
	
	/** Returns the row index of this sparse array element */
	public int getRow() {
		return row;
	}
	
	/** Returns the column index of this sparse array element */
	public int getCol() {
		return col;
	}
	
	/** Returns the value of this sparse array element */
	public int getValue() {
		return value;
	}
	
	/*ADDED FOR QUESTION TESTING**/
	public String toString() {
		
		return "\nrow:\t"+row+"\ncol:\t"+col+"\nvalue:\t"+value+"\n\n";
	}
	
	
}
