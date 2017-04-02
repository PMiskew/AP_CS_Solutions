
/**
 * This is a solution to question 4 from the 2015 AP Computer Science
 * exam.  Note that some additional code has been added to allow for 
 * testing.  
 * @author PMiskew
 *
 */
//THIS ENTIRE FILE IS SOLUTION TO PART A
public interface NumberGroup {
	/*	Theory: Interfaces
	 * 
	 *  - Interfaces are a way of connection objects that do not necessarily enforce the "is a" relationship
	 *  - Interfaces contain no code. 
	 *  - Interfaces only contain abstract method headers.
	 *  	- Since all methods are abstract the modifier "abstract" is no needed	
	 * 	- All classes that implement an interface, MUST have an implementation of all methods. 
	 *  - Interfaces can contain static constants.  
	 *  - You CANNOT instantiate an Interface
	 *  - You CAN create an interface reference type. 
	 *  	- This is what allows you organize objects that are not connected via the hierarchy. 
	 *  
	 */
	public boolean contains(int value);
	
}