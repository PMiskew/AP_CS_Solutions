

public class LogMessage extends Object {

	//CRITICAL: EVERYTHING IS PRIVATE
	private String machineId;
	private String description;
	

	/**
	 * This is a solution to AP Free Response 2016 #2a
	 * 
	 * precondition: message is a valid log message. */
	public LogMessage(String message){
		
		//Solution 1:
				
		//TECHNIQUE:  	The built in split method is a nice way to quickly convert a string into an array 
		// 				based on a specific character as a separator.  
		String[] words = message.split(":");
		//example message = "001:error on disk"
		
		//words = {"001","error on disk"}
		
		machineId = words[0];
		description = words[1];
		//*/
		//Solution 2:
		//int colon = message.indexOf(":");
		//machineId = message.substring(0, colon);
		//TECHNIQUE:  	Remember that substring is an OVERLOADED method.  Passing it a single parameter will
		//				generate the string including all letters from the index to the end of the string. 
		//description = message.substring(colon+1);
			
	}
//*************************************************************************************************************
	/** 
	 *	This is a solution to AP Free Response 2016 #2b
	 * 	
	 * 	Returns true if the description in the this log message properly contains keyword;
	 * 			false otherwise. 
	 */
	public boolean containsWord(String keyword){
		
		//SOLUTION 1:	This solution works, but is more involved as a number of cases need to be evaluated. 
		//		
		/*
		//Check 1: 	The description and keyword match. 
		if (description.equals(keyword)) return true;
		
		//Check 2: 	The description size is less than or equal to the keyword length return false
		//			we know that description isn't the keyword since check 1 passes. Accounts for
		//			possible index out of bounds errors in check 3 and 4
		if (description.length() <= keyword.length()) return false;
		
		//Check 3:	Is the keyword the first word in description followed by space
		if (description.substring(0, keyword.length() + 1).equals(keyword+" ")) return true;
		
		//Check 4:	Is the keyword at the end with a space infront of it.
		if (description.substring(description.length()-(keyword.length() + 1)).equals(" "+keyword)) return true;
		
		//Check 5:  Is the keyword anywhere else in th message with a space infront and a space behind. 
		if (description.contains(" "+keyword+" ")) return true;
	
		
		return false;
	
		//*/
		
		//TECHNIQUE:   	To avoid having to deal with the special cases, that is the situations where the 
		//				keyword is at the front or end of the string, testing a modified string simplifies 
		//				the code.  These solution are a nice approach, but be sure not to actually modify 
		//				the description variable. 
		//SOLUTION 2:
		
		//return (" " + description+ " ").contains(" " + keyword + " ");
		//*/		
		
		//SOLUTION 3
		//This is a much simplier way to complete this question. 
		return (" " + description+ " ").indexOf(" " + keyword + " ") >= 0;
		//*/
	}
	
	public String getMachineId(){ return machineId; }
	public String getDescription() { return description; }


	/**
	 * YOU DO NOT HAVE TO WRITE TOSTRING AS PART OF AP EXAM.  I DID THIS TO HELP WITH THE TEST CODE
	 * @param entry
	 */

	// There may be instance variables, constructors, and methods that are not shown. 
	
	public String toString(){
		return "MONKEY";
	}
	/**
	 * This is tester code for AP CS Free Response Question 2 Part A and B
	 * @param args
	 */
	public static void main(String[] args) {
		
		LogMessage lm = new LogMessage("000:fun");
		System.out.println(lm);
		/*
		
		LogMessage lm1 = new LogMessage("001:disk");	
		LogMessage lm2 = new LogMessage("002:error on disk");
		LogMessage lm3 = new LogMessage("003:error on /dev/disk disk");
		LogMessage lm4 = new LogMessage("004:error on disk DSK1");
			
		
		System.out.println("\nLM1 Test");
		System.out.println(lm1.machineId);
		System.out.println(lm1.description);
		System.out.println(lm1.containsWord("disk")+" EXPECTED TRUE");
		
		System.out.println("\nLM2 Test");
		System.out.println(lm2.machineId);
		System.out.println(lm2.description);
		System.out.println(lm2.containsWord("disk")+" EXPECTED TRUE");
	
		System.out.println("\nLM3 Test");
		System.out.println(lm3.machineId);
		System.out.println(lm3.description);
		System.out.println(lm3.containsWord("disk")+" EXPECTED TRUE");
	
		System.out.println("\nLM4 Test");
		System.out.println(lm4.machineId);
		System.out.println(lm4.description);
		System.out.println(lm4.containsWord("disk")+" EXPECTED TRUE");
	
	
		LogMessage lm5 = new LogMessage("005:DISK");	
		LogMessage lm6 = new LogMessage("006:error on disk3");
		LogMessage lm7 = new LogMessage("007:error on /dev/disk");
		LogMessage lm8 = new LogMessage("008:diskette");
			
		
		System.out.println("\nLM5 Test");
		System.out.println(lm5.machineId);
		System.out.println(lm5.description);
		System.out.println(lm5.containsWord("disk")+" EXPECTED FALSE");
		
		System.out.println("\nLM6 Test");
		System.out.println(lm6.machineId);
		System.out.println(lm6.description);
		System.out.println(lm6.containsWord("disk")+" EXPECTED FALSE");
	
		System.out.println("\nLM7 Test");
		System.out.println(lm7.machineId);
		System.out.println(lm7.description);
		System.out.println(lm7.containsWord("disk")+" EXPECTED FALSE");
	
		System.out.println("\nLM8 Test");
		System.out.println(lm8.machineId);
		System.out.println(lm8.description);
		System.out.println(lm8.containsWord("disk")+" EXPECTED FALSE");
		//*/
	}
}
	
	

