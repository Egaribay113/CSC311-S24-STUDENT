

public class selectionSort {

	private int loopCount; 
	
	selectionSort(){
		
	}
	
	void sort(int originalArr[]) 
    { 
		int[] arr = new int[originalArr.length];
		
		for(int x = 0; x < originalArr.length; x++) {
			arr[x] = originalArr[x];
		}
        int n = arr.length; 
        int countLoop = 0; 
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n - 1; i++) { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i + 1; j < n; j++) { 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j;
                	countLoop++; 
            } 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
        System.out.println("Number of iterations: "+ countLoop); 
    } 
  
    // Prints the array 
    void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println();
	
    }
    
   	
    	
}
