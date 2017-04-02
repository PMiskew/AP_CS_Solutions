/**
 * This is a solution to question 2 from the 2015 AP Computer Science
 * exam.  Note that some additional code has been added to allow for 
 * testing.  
 * @author PMiskew
 *
 */
public class HiddenWord {

	
	private String hiddenWord;
	
	/**
	 * Constructor copies passed argument into hiddenWord field.
	 * @param h
	 */
	public HiddenWord(String h){
		hiddenWord = h;
	}
	
	public String getHint(String guess) {
		
		//TECHNIQUE: String Construction
		/*
		 * This question depends on a technique called 
		 * String construction.  This is the process of
		 * starting with an empty string and adding things 
		 * to it using the process of concatenation. 
		 */
		
		String clue = "";
		
		for (int i = 0; i < guess.length(); i++) {
			
			if (guess.charAt(i) == hiddenWord.charAt(i)) 
				clue = clue + guess.charAt(i);
			else if (hiddenWord.contains(guess.substring(i,i+1)))
				clue = clue + "+";
			else 
				clue = clue + "*";
		}
		return clue;
	}
	/**
	 * USED FOR TESTING CODE. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		HiddenWord puzzle = new HiddenWord("HARPS");
		System.out.println(puzzle.getHint("AAAAA"));
		System.out.println(puzzle.getHint("Hello"));
		System.out.println(puzzle.getHint("HEART"));
		System.out.println(puzzle.getHint("HARMS"));
		System.out.println(puzzle.getHint("HARPS"));
	}

}
