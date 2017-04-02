import java.util.ArrayList;
import java.util.List;
/**
 * This is a solution to question 4 from the 2015 AP Computer Science
 * exam.  Note that some additional code has been added to allow for 
 * testing.  
 * @author PMiskew
 *
 */
// THIS FILE IS A SOLUTION TO PART C. PART C ONLY REQUIRES THAT
// YOU WRITE THE CONTAINS FUNCTION.  NOTE THAT ADDITIONAL CODE 
// HAS BEEN ADDED TO ALLOW FOR TESTING. 
public class MultipleGroups {

	private List<NumberGroup> groupList;
	
	/* ADDED FOR QUESTION TESTING */
	public MultipleGroups(List<Range> ranges) {
		groupList = new ArrayList<NumberGroup>();
		
		for (int i = 0; i < ranges.size(); i++)
			groupList.add(ranges.get(i));
		
	}
	
	/** Returns true if at least one of the number groups in this multiple group contains num;
	 * 			false otherwise.
	 * @param num
	 * @return
	 */
	// THIS QUESION IS PART C
	public boolean contains(int num) {
		
		for (int i = 0; i < groupList.size();i++)
			if (groupList.get(i).contains(num))
				return true;

		return false;
		
	}
	
	/**
	 * This is a testing function
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Range> ranges = new ArrayList<Range>();
		Range range1 = new Range(5,8);
		ranges.add(range1);
		
		Range range2 = new Range(10,12);
		ranges.add(range2);
		
		Range range3 = new Range(1,6);
		ranges.add(range3);
		
		MultipleGroups multiple1 = new MultipleGroups(ranges);
		
		System.out.println(multiple1.contains(2));
		System.out.println(multiple1.contains(9));
		System.out.println(multiple1.contains(6));

	}

}
