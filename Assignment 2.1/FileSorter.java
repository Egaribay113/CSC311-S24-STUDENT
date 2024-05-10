import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner; 
public class FileSorter {
	
	
	private String fileName;

	FileSorter() {
		 
	}

	public void fileSort() throws IOException {
		
		//int[] randomArray = {3,7,1,11,14,12,20,44,33,26,78};
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please enter your file name: ");
		
		String FileName = userInput.nextLine(); 
		
		NumberFileReader fr = new NumberFileReader(FileName);
		//NumberFileWriter fileWrite = new NumberFileWriter(FileName);
		
		//fr.read(FileName);
		
		int[] cloneArray = fr.read(FileName); //store returning array data numbers into an array.
		
			BubbleSorting bubbleSort = new BubbleSorting(cloneArray); 
		
			System.out.println("Contents in file:"+Arrays.toString(cloneArray)); //Array class returns values in array format.
		
		
			//fileWrite.write(cloneArray); 
		
			int[] cloneArray1 = bubbleSort.sortAsc(cloneArray);
			System.out.println("Sorted in ascending order:"+Arrays.toString(cloneArray1));
		
			int[] cloneArray2 = bubbleSort.sortDesc(cloneArray); 
			System.out.println("Sorted in descending order:"+Arrays.toString(cloneArray2));
		
			NumberFileWriter fw = new NumberFileWriter(FileName); 
			
			fw.write(cloneArray); 
		
		
	}
	
	
	
}
