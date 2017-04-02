
public class SkyView {

	/** A rectangular array that holds the data representing a rectangular area of the sky */
	private double[][] view;
	
	/** Constructs a SkyView object from a 1-dimensional array of scan data.
	 *  @param numRows the number of rows represented in the view.
	 *  	   Precondition: numRows > 0
	 *  @param numCols the number of columns represented in the view. 
	 *  	   Precondition: numCols > 0
	 *  @param scanned the scan data recievd from the telescope, stored in telescope order
	 *  	   Precondition: scanned.length = numsRows * numCols
	 *  Postcondition: view has been created as a rectangular 2-dimensional array 
	 *  			   with numRows row and numCols columns and the values in 
	 *  			   scanned have been copied to view and ar ordered as
	 *  			   in the original rectangular area of the sky. 
	 *  
	 */
	public SkyView(int numRows, int numCols, double[] scanned) {
		/* to be implemented in part (a) */
		
		view = new double[numRows][numCols];
		
		int r = 0;
		int cu = 0;
		int cd = numCols - 1;
		for (int i = 0; i < scanned.length-numCols; i++) {
	
			if (cd == -1) {
				cd = numCols - 1;
				cu = 0;
				r = r + 2;
				i = i + numCols;
				
			}
	
			
			view[r][cu] = scanned[i];
			view[r+1][cd] = scanned[i+numCols];
	
			cd--;
			cu++;
			
				
			
		}
		
	}

	/** Returns the average of the values in a rectangular section of view.
	 *  @param startRow the first row index of the section. 
	 *  @param endRow the last row index of the section. 
	 *  @param startCol the first column index of the section. 
	 *  @param endCol the last column index of the section. 
	 *  Precondition 0 <= startRow <= endRow < view.length
	 *  Precondition 0 <= startCol <= endCol < view[0].length
	 *  @return the average of the values in the specified section of view
	 */
	public double getAverage(int startRow, int endRow, int startCol, int endCol) {
		
		double total = 0;
		int count = 0;
		
		for (int r = startRow; r <= endRow; r++){
			for (int c = startCol; c <= endCol; c++) {
				total = total + view[r][c];
				count = count + 1;
			 }
		}
		return total/count;
		
		
	}
	
	public void displayView() {
		
		for (int r = 0; r < view.length; r++) {
			for (int c = 0; c < view[r].length; c++) {
				System.out.print(view[r][c]+", ");
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		
		double[] scanned = {0.3,0.7,0.8,0.4,1.4,1.1,0.2,0.5,0.1,1.6,0.6,0.9};
		
		SkyView sky = new SkyView(4,3,scanned);
		
		sky.displayView();
		
		
		double average = sky.getAverage(1, 2, 0, 1);
		System.out.println(average);
	}
}
