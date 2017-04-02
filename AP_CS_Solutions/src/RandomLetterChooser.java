//THEORY:  Because this class extends RandomStringChooser 
//				- It inherits all methods and fields. IT DOES NOT INHERIT CONSTRUCTORS
//				- We have to check the constructors in RandomStringChooser to ensure the super is correct
public class RandomLetterChooser extends RandomStringChooser {

	/**
	 * Constructor for RandomLetterChooser
	 * @param str
	 */
	public RandomLetterChooser(String str) {
		//THEORY:  	This only works because getSingleLetter is a static method.  If it was an instance method
		//			the object would have to be created before it could be call.  Since we construct objects 
		//			from generic to specific, that is from the Object class down, getSingleLetters woudl not
		//			exist if it was an instance method. 
		//CRITICAL: RandomString chooser DOES NOT have a default constructor.  That means we MUST write a super
		//			call here.  That is essentially what he question is asking. 
		super(getSingleLetters(str));
	}
	
	/**
	 * I have written this function so that the question can be coded.  It is not required for the exam. 
	 * @param str
	 * @return
	 */
	public static String[] getSingleLetters(String str){
		
		//WORKS:
		/*
		String[] arr = new String[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			//arr[i] = str.substring(i,i+1);
			//THEORY:	Remember you can cast a character to a string by using add a "" in the front. 
			arr[i] = ""+(str.charAt(i));
		}
		return arr;
		//*/
		
		//BETTER:
		//THEORY:   The split method in the string class is really useful as it will return a string broken up into an 
		//			array based on the passed value.  For example: 
		//				
		//				String sentence = "This is a sentence" 
		//				String[] words = sentence.split(" "); 
		//
		//			would generate the array words = {"This","is","a","sentence"}
		//
		//			If we want to break up a word character by character we use and empty string as the parameter. 
		return str.split("");
	}
	/*
	 * TESTER CODE
	 */
	public static void main(String[] args) {
		//String s = "words";
		//System.out.println(Arrays.toString(s.split("")));
			
		RandomLetterChooser letterChooser = new RandomLetterChooser("cat");
		
		for (int k = 0; k < 4; k++) {
			System.out.print(letterChooser.getNext());
		}
	}
}
