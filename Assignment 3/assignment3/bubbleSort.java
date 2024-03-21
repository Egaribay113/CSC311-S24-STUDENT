


public class bubbleSort {
	
	int countLoop; 
	
	int bubbleSort(int originalArr[]) 
    { 
		
		int[] arr = new int[originalArr.length];
		
		for(int x = 0; x < originalArr.length; x++) {
			arr[x] = originalArr[x];
		}
		
		 int n = arr.length;
		 int countLoop = 0; 
	        for (int i = 0; i < n - 1; i++) 
	            for (int j = 0; j < n - i - 1; j++) 
	                if (arr[j] > arr[j + 1]) { 
	                    // swap temp and arr[i] 
	                    int temp = arr[j]; 
	                    arr[j] = arr[j + 1]; 
	                    arr[j + 1] = temp;
	                    countLoop++; 
	                } 
	        System.out.println("Number of iterations: "+countLoop); 

	        return countLoop; 
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
