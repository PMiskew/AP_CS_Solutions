import java.util.Arrays;

/**
 * This is a solution to question 1 from the 2015 AP Computer Science
 * exam.  Note that some additional code has been added to allow for 
 * testing.  
 * @author PMiskew
 *
 */
public class AP2015Q1 {

	public static int arraySum(int[] arr) {
		
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++)
			sum = sum + arr[i];
	
		return sum;
	}
	
	public static int[] rowSum(int[][] arr2D){
		
		
		int[] result = new int[arr2D.length];
		
		//Critical Idea:	A 2D array is an array of arrays.  You can visualize
		//					each row as a new array.  That means given a 2D array
		//					like arr2D we can access a row by writing arr2D[r].
		//					This is the easiest way to pass the row to the method
		//					arraySum
		for (int r = 0; r < arr2D.length; r++) 
			result[r] = arraySum(arr2D[r]);
		
		return result;
		
	
		
	}
	
	public static boolean isDiverse(int[][] arr2D){
		
		int[] rowSumArr = rowSum(arr2D);
		
		for (int i = 0; i < rowSumArr.length - 1; i++)
			for (int j = i + 1; j < rowSumArr.length; j++) 
				if (rowSumArr[i] == rowSumArr[j])
					return false;
			
		return true;
	}
		
	/**
	 * USED FOR TESTING CODE. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] mat1 = {{ 1, 3, 2, 7, 3},
						{10,10, 4, 6, 2},
						{ 5, 3, 5, 9, 6},
						{ 7, 6, 4, 2, 1}};
		
		int[][] mat2 = {{ 1, 1, 5, 3, 4},
					    {12, 7, 6, 1, 9},
					    { 8,11,10, 2, 5},
					    { 3, 2, 3, 0, 6}};

		//Test rowSum and arraySum at once
		
		int[] summat1 = rowSum(mat1);
		int[] summat2 = rowSum(mat2);
		System.out.println(Arrays.toString(summat1));
		System.out.println(Arrays.toString(summat2));
		
		//Test isDiverse
		System.out.println(isDiverse(mat1));
		System.out.println(isDiverse(mat2));
		
		
	}

}
