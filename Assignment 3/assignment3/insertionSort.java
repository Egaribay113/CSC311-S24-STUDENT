

public class insertionSort {

	
	
	int countLoop; 
	
	 void sort(int originalArr[])
	    {
		 
		 int[] arr = new int[originalArr.length];
			
			for(int x = 0; x < originalArr.length; x++) {
				arr[x] = originalArr[x];
			}
		 
	        int n = arr.length;
	        int countLoop = 0; 
	        for (int i = 1; i < n; ++i) {
	            int key = arr[i];
	            int j = i - 1;
	 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j = j - 1;
	            }
	            arr[j + 1] = key;
	            countLoop++; 
	        }
	        System.out.println("number of iterations: "+ countLoop); 
	    }
	 
	    /* A utility function to print array of size n*/
	    public void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i] + " ");
	 
	        System.out.println();
	    }
	 
	   
}
