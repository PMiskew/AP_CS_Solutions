
public class DownloadInfo {

	private String title;
	private int downloads;
	/** Creates an instance with teh given unique title and sets that
	 *  number of times downloaded to 1.
	 *  @param title the unique title of the downloaded song. 
	 */
	public DownloadInfo(String title) {
		this.title = title;
		downloads = 1;
		
	}
	
	/** @return the title */
	public String getTitle() {
		/*Implementation added for testing*/
		return title;
	}
	
	/** Increments the number of times downladed by 1 */
	public void incrementTimesDownloaded() {
		/*Implementation added for testing*/
		downloads = downloads + 1;
	}
	
	public String toString() {
		return title+","+downloads;
	}
}

