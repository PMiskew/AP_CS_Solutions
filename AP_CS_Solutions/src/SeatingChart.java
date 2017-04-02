import java.util.ArrayList;
import java.util.List;

public class SeatingChart {

	/** seats[r][c] represents the Student in row r and column c in the classroom */
	private Student[][] seats;
	
	/** Creates a seating chart with the given number of rows and columns from the students in
	 *  studentList.  Empty seats in the seating chart are represented by null.
	 *  @param rows the number of rows of seats in the classroom
	 *  @param cols the number of columns of seats in the classroom
	 *  Precondition:	rows > 0; cols > 0;
	 *  				rows * cols >= studentList.size()
	 *  Postcondition:
	 *  	-	Students appear in the seating chart in the same order as they appear
	 *  		in studentList, starting at seat[0][0]/
	 *  	-	seats is filled column by column from studentList, followed by any 
	 *  		empty seats (represented by null).
	 *  	-	studentList is unchanged. 
	 *  
	 */
	public SeatingChart(List<Student> studentList, int rows, int cols) {
		/* to be implemented in part (a) */
		seats = new Student[rows][cols];
		int position = 0;
		for (int c = 0; c < seats[0].length; c++) {
			for (int r = 0; r < seats.length; r++) {
				if (position < studentList.size()) {
					seats[r][c] = studentList.get(position);
					position = position + 1;
				}
			}
		}
		
		
	}
	
	/** Removes students who have more than a given number of absence from the
	 *  seating chart, replacing those entries in the seating chart with null
	 *  and returns the number of students removed.
	 *  @param allowedAbsences an integer >= 0
	 *  @return number of students removed from seats
	 *  Postcondition:
	 *  	- All students with allowedAbsences or fewer are in their original position in seats. 
	 *  	- No students in seats has more than allowedAbsences absences.
	 *  	- Entries without students contain null. 
	 * 
	 */
	public int removeAbsentStudents(int allowedAbsences) {
		/* to be implemented in part (b) */
		int count = 0;
		
		for (int r = 0; r < seats.length; r++) {
			for (int c = 0; c < seats[r].length; c++) {
				if (seats[r][c] != null && seats[r][c].getAbsenceCount() > allowedAbsences) {
					count = count + 1;
					seats[r][c] = null;
				}
			}
		}
		return 0;
	}
	
	/**
	 * INCLUDED FOR TESTING
	 */
	
	public String toString(){
	
		String seatingPlan = "";
		
		for (int r = 0; r < seats.length; r++){
			for (int c = 0; c < seats[r].length; c++) {
				if (seats[r][c] != null)
					seatingPlan = seatingPlan + seats[r][c].getName()+","+seats[r][c].getAbsenceCount()+"\t|\t";
				else
					seatingPlan = seatingPlan + "null\t|\t";
				
			}
			seatingPlan = seatingPlan + "\n";
		}
		return seatingPlan;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> roster = new ArrayList<Student>();
		roster.add(new Student("K",3));
		roster.add(new Student("L",1));
		roster.add(new Student("P",4));
		roster.add(new Student("L",1));
		roster.add(new Student("H",5));
		roster.add(new Student("R",9));
		roster.add(new Student("G",2));
		roster.add(new Student("F",6));
		roster.add(new Student("D",1));
		roster.add(new Student("D",3));
		
		SeatingChart seatingChart = new SeatingChart(roster,3,4);
		System.out.println(seatingChart);
		seatingChart.removeAbsentStudents(4);
		System.out.println("");
		System.out.println(seatingChart);
		
		
		
		
		
		
		
		
	}

}
