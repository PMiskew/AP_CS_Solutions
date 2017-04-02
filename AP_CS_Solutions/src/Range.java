/**
 * This is a solution to question 4 from the 2015 AP Computer Science
 * exam.  Note that some additional code has been added to allow for 
 * testing.  
 * @author PMiskew
 *
 */
//THIS ENTIRE FILE IS A SOLUTION TO PART B.
public class Range implements NumberGroup {

	private int low;
	private int high;
	
	public Range(int low, int high) {
		
		this.low = low;
		this.high = high;
		
		
	}
	
	public boolean contains(int value) {
	
		return value >= low && value <= high;
		
	}
	
}
