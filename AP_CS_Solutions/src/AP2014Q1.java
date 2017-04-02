import java.util.ArrayList;
import java.util.List;

public class AP2014Q1 {

	public static String scrableWord(String word) {
				
		String result = "";
		
		for (int i = 0; i < word.length(); i++){
			
			if (i != word.length() - 1 && word.charAt(i) == 'A') {
				result = result + word.charAt(i + 1) + word.charAt(i);
				i++;
			}
			else {
				result = result + word.charAt(i);
			}
			
		}
		return result;
	}
	
	public static void scrambleOrRemove(List<String> wordList) {
		
		for (int i = wordList.size() - 1; i >= 0; i--){
			
			String scrabled = scrableWord(wordList.get(i));
			
			if (scrabled.equals(wordList.get(i)))
				wordList.remove(i);
			else
				wordList.set(i,scrabled);
		}
			
		
	}
		

	public static void main(String[] args) {
		System.out.println(scrableWord("TAN"));
		System.out.println(scrableWord("ABRACADABRA"));
		System.out.println(scrableWord("WHOA"));
		System.out.println(scrableWord("AARDVARK"));
		System.out.println(scrableWord("EGGS"));
		System.out.println(scrableWord("A"));
		System.out.println(scrableWord(""));
		
		List<String> list = new ArrayList<String>();
		list.add("TAN");
		list.add("ABRACADABRA");
		list.add("WHOA");
		list.add("APPLE");
		list.add("EGGS");
		scrambleOrRemove(list);
		System.out.println(list);
		
	}

}
