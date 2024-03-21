

public class mergeSort {

	
	    private int countLoop; // Declare the loop counter variable
	    
	    // Constructor
	    public mergeSort() {
	        countLoop = 0; // Initialize the loop counter variable
	    }
	    
	    // Merges two subarrays of arr[]
	    // First subarray is arr[l..m]
	    // Second subarray is arr[m+1..r]
	    void merge(int array[], int l, int m, int r) {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;

	        // Create temp arrays
	        int L[] = new int[n1];
	        int R[] = new int[n2];

	        // Copy data to temp arrays
	        for (int i = 0; i < n1; ++i)
	            L[i] = array[l + i];
	        for (int j = 0; j < n2; ++j)
	            R[j] = array[m + 1 + j];

	        // Merge the temp arrays
	        int i = 0, j = 0;
	        int k = l;

	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
	                array[k] = L[i];
	                i++;
	            } else {
	                array[k] = R[j];
	                j++;
	            }
	            k++;
	            countLoop++; // Increment loop counter
	        }

	        // Copy remaining elements of L[] if any
	        while (i < n1) {
	            array[k] = L[i];
	            i++;
	            k++;
	            countLoop++; // Increment loop counter
	        }

	        // Copy remaining elements of R[] if any
	        while (j < n2) {
	            array[k] = R[j];
	            j++;
	            k++;
	            countLoop++; // Increment loop counter
	        }
	    }

	    // Main function that sorts arr[l..r] using merge()
	    void sort(int originalArray[], int l, int r) {
	    	
	    	int[] array = new int[originalArray.length];
			
			for(int x = 0; x < originalArray.length; x++) {
				array[x] = originalArray[x];
			}
	    	
	    	
	        if (l < r) {
	            // Find the middle point
	            int m = (l + r) / 2;

	            // Sort first and second halves
	            sort(array, l, m);
	            sort(array, m + 1, r);

	            // Merge the sorted halves
	            merge(array, l, m, r);
	        }
	    }

	    // A utility function to print array of size n
	    static void printArray(int array[]) {
	        int n = array.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(array[i] + " ");
	        System.out.println();
	    }

	    // Getter method to retrieve the count of loop iterations
	    public int getCountLoop() {
	        return countLoop;
	    }
	    
	    
	    
	}

	
	
