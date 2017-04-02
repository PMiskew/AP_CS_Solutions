import java.util.ArrayList;
import java.util.List;
/**
 * This is a solution to question 3 from the 2015 AP Computer Science
 * exam.  Note that some additional code has been added to allow for 
 * testing.  
 * @author PMiskew
 *
 */
//THIS ENTIRE FILE IS A SOLUTION TO PART A AND B.
public class SparseArray {

	/** The number of rows and columns in the sparse array. */
	private int numRows;
	private int numCols;
	
	/** The list of entries representing the non-zero elements of the sparse array. Entries are stored in the
	 *  list in no particular order. Each non-zero element is represented by exactly one entry in the list. 
	 */
	private List<SparseArrayEntry> entries;
	
	/** Constructs an empty SparseArray. */
	public SparseArray() {
		entries = new ArrayList<SparseArrayEntry>();
	}
	
	/*ADDED FOR QUESTION TESTING**/
	public void generateSparseArray(int[][] sparse) {
		
		for (int r = 0; r < sparse.length; r++) {
			for (int c = 0; c < sparse[r].length; c++) {
				if (sparse[r][c] != 0) {
					entries.add(new SparseArrayEntry(r,c,sparse[r][c]));
				}
			}
		}
		System.out.println(entries);
		
		
	}
	
	/** Returns the number of rows in the sparse array. */
	public int getNumRows() {
		return numRows;
	}
	
	/** Returns the number of columns in the sparse array. */
	public int getNumCols() {
		return numCols;
	}
	
	/** Returns the value of the element at row index row and column index col in the sparse array.
	 *  Precondition:	0 <= row < getNumRows()
	 *  				0 <= col < getNumCols() 			
	 */
	public int getValueAt(int row, int col){
		/* to be implemented in part (a) */
		//STANDARD FOR LOOP SOLUTION
		/*
		for (int i = 0; i < entries.size(); i++) {
			SparseArrayEntry s = entries.get(i);
			if (s.getRow() == row && s.getCol() == col) 
				return s.getValue();
		}
		//*/
		
		//FOR EACH SOLUTION
		
		for (SparseArrayEntry s: entries)
		 	if (s.getRow() == row && s.getCol() == col) 
				return s.getValue();
		 
		// */
		
		return 0;
		
		
	}
	
	/** Removes the column col from the sparse array.
	 *  Precondition: 0 <= col < getNumCols()
	 */
	public void removeColumn(int col) {
		/* to be implemented in part (b) */
		
		for (int i = entries.size() - 1; i >=0; i--) { 

			if (entries.get(i).getCol() == col) {
				entries.remove(i);
			}
			else if (entries.get(i).getCol() > col) {
				//TRICKY PART:  You need to make a whole new object to change the column entry as we are no provided
				//				modifier methods for the column field. 
				SparseArrayEntry t = entries.get(i); //copy reference to reduce code
				SparseArrayEntry newEntry = new SparseArrayEntry(t.getRow(),t.getCol() - 1,t.getValue()); //create a new entry
				entries.set(i,newEntry); //set new entry in position
			}
		}
		numCols = numCols - 1;  //Need to minus 1 on number of columns.
	}
	
	/* ADDED FOR QUESTIONS TESTING */
	public String toString() {
		return entries.toString();
	}
	public static void main(String[] args) {
		
		int[][] mat1 = {{ 0, 0, 0, 0, 0},
						{0, 5, 0, 0, 4},
						{ 1, 0, 0, 0, 0},
						{ 0,-9, 0, 0, 0},
						{ 0, 0, 0, 0, 0} };
		
		SparseArray sparse = new SparseArray();
		sparse.generateSparseArray(mat1);
		
		System.out.println("Value Test (3,3):\t" + sparse.getValueAt(3, 3));
		System.out.println("Value Test (1,1):\t" + sparse.getValueAt(1, 1));
		
		sparse.removeColumn(1);
		System.out.println(sparse);
		
		
	}
}
