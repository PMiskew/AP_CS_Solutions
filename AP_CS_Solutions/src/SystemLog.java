import java.util.ArrayList;
import java.util.List;

public class SystemLog {

	
	private List<LogMessage> messageList;
	
	/**
	 * YOU DO NOT HAVE TO WRITE CONSTRUCTOR AS PART OF AP EXAM.  I DID THIS TO HELP WITH THE TEST CODE
	 * @param entry
	 */
	private SystemLog(List<LogMessage> entry) {
		
		//CRITICAL:  	Watch for these situations where a list is declared as a field, but is not initialized.  This goes 
		//				for arrays as well. 
		messageList = new ArrayList<LogMessage>();
		//THEORY:
		//KNOW THE DIFFERENCE AND KNOW WHAT THE QUESION IS ASKING. 
		
		//1. Give messageList the same reference:
		/*
		messageList = entry;
		//*/
		//2. 	Copy elements into messageList thus making a whole new copy of the elements.  This means that the 
		//		List of LogMessage objects passed to the constructor will not be affected by any changes to entry 
		//		and vice versa.
		
		for (int i = 0; i < entry.size(); i++) {
			messageList.add(entry.get(i));
		}
		
		
	}
	//************************************************AP PART C***************************************************************
	/** Removes from the system log all entries whose descriptions properly contain keyword,
	 *  and returns a list (possibly empty) containing the removed entries.
	 *  Postcondition:
	 *  	- Entries in the returned list properly contain keyword and 
	 *  	  are in the order in which they appeared in the system log.
	 *  	- The remaining entries in the system log do not properly contain keyword and
	 *  	  are in their original order.
	 *  	- The returned list is empty if no messages properly contain keyword
	 * @param args
	 */
	public List<LogMessage> removeMessages(String keyword) {
		
		List<LogMessage> newList = new ArrayList<LogMessage>();
		//SOLUTION 1:
		
		for (int i = messageList.size() - 1; i >= 0; i--) {
			
			if (messageList.get(i).containsWord(keyword)) {
				
				//CRITICAL: You must add message to start of list since it is 
				//			required they are kept in original order. 
				newList.add(0,messageList.remove(i));
								
			}
			
		}
		
		return newList;
		//*/
		/*
		for (int i = 0; i < messageList.size(); i++) {
			if (messageList.get(i).containsWord(keyword)) {
				newList.add(messageList.remove(i));  //This is doing two things at once.  removing the LogMessage from 
													 //message list and since the remove function returns the object that
													 //is being removed we can pass it right into the add method. 
				i = i - 1;	//Since we are moving through the list from start to end when we remove adn object all the
							//elements to the right of the object change indexes
		
			}
		}
		return newList;
		
		//*/
	}

	/**
	 * YOU DO NOT HAVE TO WRITE TOSTRING AS PART OF AP EXAM.  I DID THIS TO HELP WITH THE TEST CODE
	 * @param entry
	 */
	public String toString() {
		
		//TECHNIQUE: Use string construction in the toString then retunr the string when you are done building.  Also 
		//			 If you need to return multiple lines do that using the \n
		String str = "";
		for (int i = 0; i < messageList.size(); i++) {
			str = str + "\n" + messageList.get(i);
		}
		return str;
			
	
	}
	
	/**
	 * This is tester code for AP CS Free Response Question 2 Part C
	 * @param args
	 */
	public static void main(String[] args) {
	
		List<LogMessage> theLog = new ArrayList<LogMessage>();
		
		theLog.add(new LogMessage("CLIENT3:security alert - repeated login failures"));
		theLog.add(new LogMessage("Webserver:disk offline"));
		theLog.add(new LogMessage("SERVER1:file note found"));
		theLog.add(new LogMessage("SERVER2:read error on disk DSK1"));
		theLog.add(new LogMessage("SERVER1:write error on disk DSK2"));
		theLog.add(new LogMessage("Webserver:error on /dev/disk"));
		
		
		SystemLog sysLog = new SystemLog(theLog);
		System.out.println("\nORIGINAL LOG");
		
		System.out.println(sysLog);
		List<LogMessage> removedLog = sysLog.removeMessages("disk");
		System.out.println("\nNEW SYSTEM LOG");
		System.out.println(sysLog);
		
		SystemLog removedSysLog = new SystemLog(removedLog);
		System.out.println("\nREMOVED LOG");
		System.out.println(removedSysLog);
		
		
	}

}
