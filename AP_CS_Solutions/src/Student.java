
public class Student {

	private String name;
	private int absences;
	
	public Student(String n, int a) {
		/* Not provided on Exam. 
		 * Added for coded response */
		name = n;
		absences = a;
	}
	/** Returns the name of this Student */
	public String getName() {
		/* implementation not shown in exam*/ 
		return name;
	}
	
	/** Returns the number of times this Student has missed class */
	public int getAbsenceCount(){
		/* implementation not shown in exam */
		return absences;
		
	}
}
