import java.util.ArrayList;
import java.util.List;

public class AP2016Q4 {


	/**
	 * This is a solution to AP 2016 Free Response 4a
	 * @param wordList
	 * @return
	 */
	public static int totalLetters(List<String> wordList) {
		
		
		int total = 0;
		
		//Solution 1: For loops
		/*
		for (int i = 0; i < wordList.size(); i++) {
			total = total + wordList.get(i).length();
		}
		//*/
		
		//Solution 2: For Each Loop
		for (String a: wordList){
				total = total + a.length();
		}
		return total;
		
	}
	
	/**
	 * This is a solution to AP 2016 Free Response 4b
	 * @param wordList
	 * @param formattedLen
	 * @return
	 */
	public static int basicGapWidth(List<String> wordList, int formattedLen) {
		
		//CRITICAL:  Use method already completed
		int total = totalLetters(wordList);  //Use totalLetters method to count letters in wordList
		
		int remain = formattedLen - total;  //Calculate remaining space available. 
		
		//COMMOR ERROR: Be sure to include brackets to avoid order of operations logic error. 
		int basicGap = remain/(wordList.size() - 1); 
				
		return basicGap;
	}
	
	/**
	 * This method is not required as part of the question.  The method is provided
	 * without implementation and the user is expected to use it to recieve full
	 * credit for the problem. 
	 * @param wordList
	 * @param formattedLen
	 * @return
	 */
	public static int leftoverSpace(List<String> wordList, int formattedLen) {
		

		//CRITICAL:  Use method already completed
		int total = totalLetters(wordList);	//Use totalLetters method to count letters. 

		//CRITICAL:  Use method already completed
		int basicGap = basicGapWidth(wordList, formattedLen);  //Use basicGapWidth to find basicGap
		
		int leftover = formattedLen - total - (basicGap*(wordList.size()-1));  //Calculate leftover
		return leftover;  //return leftover
				
	}
	
	/**
	 * This is a solution to AP Free Response 2016 #4c
	 * @param wordList
	 * @param formattedLen
	 * @return
	 */
	public static String format(List<String> wordList, int formattedLen) {
	
		String result = "";
				
		//CRITICAL:  Use method already completed
		int basicGap = basicGapWidth(wordList, formattedLen);
		
		String basicGapText = ""; //Used to store basic gap string
		//TECHNIQUE: 	Creates basicGapText string:  By doing this once in advance it 
		//				makes the program more efficient and easier to read.  
		for (int i = 0; i < basicGap; i++)
			basicGapText = basicGapText + " ";	
		
		
		int leftover = leftoverSpace(wordList,formattedLen);
		
		//Loop through each element in word list and adding the word
		for (int i = 0; i < wordList.size(); i++) {

			//The basicGapText is added at the end of all entries, except for the 
			//last word in wordList. 
			if (i != wordList.size() - 1)
				result = result + wordList.get(i) + basicGapText;
			else
				result = result + wordList.get(i);
				
			//LOGIC:	The leftover will always be less than basicGapWidth.  Therefore
			//			after each string is added with its basic gap, check if there is
			//			any left over and add a single space if there is left over remaining
			//			subtract one from leftover each time. 
			if (leftover != 0) {
				result = result + " ";
				leftover = leftover - 1;
			}
		}
	
		
		return result; //return result. 
	}
	
	/**
	 * This main method has been included to test the solutions.  It only consists of the 
	 * test cases provided in teh question. 
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		List<String> wordList1 = new ArrayList<String>();
		wordList1.add("AP");
		wordList1.add("COMP");
		wordList1.add("SCI");
		wordList1.add("ROCKS");
		System.out.println("Total number of letters in words: "+totalLetters(wordList1));
		System.out.println("Basic gap width: "+basicGapWidth(wordList1,20));
		System.out.println("Leftover spaces: "+leftoverSpace(wordList1,20));
		System.out.println(format(wordList1,20));
		
		System.out.println("************************************************");
		List<String> wordList2 = new ArrayList<String>();
		wordList2.add("GREEN");
		wordList2.add("EGGS");
		wordList2.add("AND");
		wordList2.add("HAM");
		System.out.println("Total number of letters in words: "+totalLetters(wordList2));
		System.out.println("Basic gap width: "+basicGapWidth(wordList2,20));
		System.out.println("Leftover spaces: "+leftoverSpace(wordList2,20));
		System.out.println(format(wordList2,20));
		
		System.out.println("************************************************");
		List<String> wordList3 = new ArrayList<String>();
		wordList3.add("BEACH");
		wordList3.add("BALL");
		System.out.println("Total number of letters in words: "+totalLetters(wordList3));
		System.out.println("Basic gap width: "+basicGapWidth(wordList3,20));
		System.out.println("Leftover spaces: "+leftoverSpace(wordList3,20));
		System.out.println(format(wordList3,20));
	}

}
