

public class heapSort {

	int countLoop; 
	
	void heapSort(int originalArr[]) {
		
		int[] array = new int[originalArr.length];
		
		for(int x = 0; x < originalArr.length; x++) {
			array[x] = originalArr[x];
		}
		
		 int n = array.length;
		 int countLoop = 0; 
	        // Build heap (rearrange array)
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(array, n, i);
	 
	        // One by one extract an element from heap
	        for (int i = n - 1; i >= 0; i--) {
	            // Move current root to end
	            int temp = array[0];
	            array[0] = array[i];
	            array[i] = temp;
	 
	            // call max heapify on the reduced heap
	            heapify(array, i, 0);
	            countLoop++; 
	        }
	        System.out.println("Number of iterations: "+ countLoop); 
	}
	
	// To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
		
   
	
	
}
