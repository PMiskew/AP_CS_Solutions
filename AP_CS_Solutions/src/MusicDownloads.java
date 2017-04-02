import java.util.ArrayList;
import java.util.List;

public class MusicDownloads {

	/** The list of downloaded information.
	 *  Guaranteed not to be null and not to contain duplicate titles. 
	 */
	private List<DownloadInfo> downloadList;
	
	/** Creates the list of downloaded informatio. */
	public MusicDownloads() {
		downloadList = new ArrayList<DownloadInfo>();
	}
	
	/** Returns a reference to the DownloadInfo object with the requested title if it exists. 
	 * @param title the requested title
	 * @return 	a reference to the DownloadInfo object with the 
	 * 			title that matches the parameter title if it exists in the list;
	 * 			null otherwise.
	 * Postcondition:	
	 * 	- no changes were made to downloadList.  
	 */
	public DownloadInfo getDownloadInfo(String title) {
		
		/* to be implemented in part (a) */
		
		for (int i = 0; i < downloadList.size(); i++) {
			if (downloadList.get(i).getTitle().equals(title)) {
				/*Theory:
				 *	Watch what the question is asking.  This question is specifically asking 
				 *	for a reference to the download object.  A slightly modified question, which
				 *	you will commonly see on the AP exam is if this question asked you to return a
				 *	copy of the download object.  This is a very important distinction and is heavily
				 *  tested on the multiple choice section of the exam. 
				 */
				return downloadList.get(i);
			}
		
		}
		
		return null;
		
	}
	
	/** Updates downloadList with information from titles.
	 *  @param titles a list of song titles. 
	 *  Postcondition:
	 *  	-	there are no duplicate titles in downloadList. 
	 *  	-	no entries were removed from downloadList.
	 *  	-	all songs in titles are represented in downloadList.
	 *  	-	for each existing entry in downloadList, the download count is increased by
	 *  		the number of times its title appears in titles.  
	 *  	-	the order of the existing entries in downloadList is not changed. 
	 *  	-	the first time an object with a title from titles is added to downloadList, it
	 *  		is added to the end of the list. 
	 *  	-	new entries in downloadList appear in the same order 
	 *  		in which they first appear in titles. 
	 *  	- 	for each new entry in downloadList, the download count is equal to
	 *  		the number of tiems its title appeared in titles. 
	 *    
	 */
	public void updateDownloads(List<String> titles) {
		/* to be implemented in part (b) */
		
		for (int i = 0; i < titles.size(); i++) { //This loop looks at each of the titles in list
			
			boolean newEntry = true; //assume it must be added. 
			for (int j = 0; j < downloadList.size(); j++) {  //This loop goes through downloadList looking for specific entry.
				
				if (downloadList.get(j).getTitle().equals(titles.get(i))) { 
					downloadList.get(j).incrementTimesDownloaded(); //It has been found we need to increment download count. 
					newEntry = false;  //It has been found we don't need to add it to the end of downloadList
					break; //It has been found we can stop searching. 
				}
				
			}
			if (newEntry){ //If the entry was not found we need to add it to the end of downloadList.
				downloadList.add(new DownloadInfo(titles.get(i)));
			}
		}
		
	}
	
	public String toString() {
		return downloadList.toString();
	}
	public static void main(String[] args) {
		
		
		List<String> titles1 = new ArrayList<String>();
		titles1.add("Hey Jude");
		titles1.add("Hey Jude");
		titles1.add("Hey Jude");
		titles1.add("Hey Jude");
		titles1.add("Hey Jude");
		
		titles1.add("Soul Sisters");
		titles1.add("Soul Sisters");
		titles1.add("Soul Sisters");
		
		titles1.add("Aqualung");
		titles1.add("Aqualung");
		titles1.add("Aqualung");
		titles1.add("Aqualung");
		titles1.add("Aqualung");	
		titles1.add("Aqualung");
		titles1.add("Aqualung");
		titles1.add("Aqualung");
		titles1.add("Aqualung");
		titles1.add("Aqualung");	
		
		MusicDownloads musicDownloads = new MusicDownloads();
		musicDownloads.updateDownloads(titles1);
		System.out.println(musicDownloads);
	
		DownloadInfo dl = musicDownloads.getDownloadInfo("Hey Jude");
		System.out.println(dl);
	}
}
