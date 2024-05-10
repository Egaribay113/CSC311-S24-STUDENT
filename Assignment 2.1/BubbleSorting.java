//Eric Garibay
//egaribay19@toromail.csudh.edu
public class BubbleSorting {

	private int[] array; 
	private int loopCounter; 
	
	BubbleSorting(int[]myArray){
		
		array = myArray; 
	}
	
	
	public int[] sortAsc(int[] myArray) {
	    int loopCounter = 0;
	    boolean swapped;
	    //System.out.println("Ascending order");
	    do {
	        swapped = false; //Theres no swapping before the loop
	        for (int i = 0; i < myArray.length - 1; i++) {
	            if (myArray[i] > myArray[i + 1]) {
	                int temp = myArray[i];
	                myArray[i] = myArray[i + 1];
	                myArray[i + 1] = temp;
	                swapped = true; //true if it swaps element during loop iterations
	            }
	            loopCounter++;
	        }
	    } while (swapped); //Continues until no swaps occur
	    System.out.println("Ascending order loops: "+ loopCounter);
	    return myArray;
	}
		
		
	
	
	public int[] sortDesc(int[]myArray) {
		
		int loopCounter = 0;
	    boolean swapped;
	    do {
	        swapped = false; //Theres no swapping before the loop
	        for (int i = 0; i < myArray.length - 1; i++) {
	            if (myArray[i] < myArray[i + 1]) { //swapped to less than
	                int temp = myArray[i];
	                myArray[i] = myArray[i + 1];
	                myArray[i + 1] = temp;
	                swapped = true; //true if it swaps element during loop iterations
	            }
	            loopCounter++;
	        }
	    } while (swapped); //Continues until no swaps occur
	    System.out.println("Descending order loops: "+ loopCounter);
	    return myArray;
		    
		    
 		
		
	}		
		
	
	public int loopCycles() {
		
		
		
		return loopCounter; 
		
	}

}

