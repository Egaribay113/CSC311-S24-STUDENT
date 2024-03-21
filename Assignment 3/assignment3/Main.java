import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Main {

	public static void main(String[] args) throws IOException 
		{
		 
			createFiles creatingFiles = new createFiles(); 
			
			creatingFiles.createDataFiles();
		
			
			
			
			
			bubbleSort bubbleSorting = new bubbleSort();
			
			//bubbleSorting.bubbleSort(listsOfData);
			
			
			readDataFiles();
			
	       
			// Call the method readDataFiles
	        
	        
	        // Print the contents of each data set
	        
	}
	
	
	
	public static void readDataFiles() throws FileNotFoundException {
		 
        
		 ArrayList<int[]> listsOfData = new ArrayList<>(); //contains 50 arrays
	        // Loop through each file
	        for (int i = 1; i <= 50; i++) {

	        	
	        	
	        Scanner data = new Scanner(new File("dataFile_" + i + ".txt")); 
	        
	        //ArrayList<String> listsS = new ArrayList<String>(); 
	        ArrayList<Integer> listsI = new ArrayList<Integer>();
	        
	        while(data.hasNextLine()) {
	        		listsI.add(data.nextInt());
	        	
	        
	        	if(data.nextLine() == null) {
	        		break;
	        	}
	        		//System.out.println(listsI);
	        		
	        	}
	        		
	        		int[] intArray = new int[listsI.size()];
	        		for(int j = 0; j < listsI.size(); j++) {
	        			intArray[j] = listsI.get(j); 
	        		}
	        		listsOfData.add(intArray); 
	        		data.close();
	        	
	        	}
	        bubbleSort bubbleSorting = new bubbleSort();
	        selectionSort selectionSorting = new selectionSort();
	        insertionSort insertionSorting = new insertionSort();
	        mergeSort	mergeSorting = new mergeSort(); 
	        heapSort heapSorting = new heapSort();
	        
	        
	        
	        
//	        System.out.println("testing bubble sort:");
//	        for(int k = 0; k < listsOfData.size(); k++ ) {
//	        	System.out.print((k+1)+ ") ");
//				bubbleSorting.bubbleSort(listsOfData.get(k));
//			}
	        
//	        System.out.println("testing selection sort:");
//			for(int k = 0; k < listsOfData.size(); k++ ) {
//				System.out.print((k+1)+ ") ");
//				selectionSorting.sort(listsOfData.get(k));
//			}
			
			System.out.println("testing merge sort:");		//NEEDS FIXING
			for(int k = 0; k < listsOfData.size(); k++ ) {
				int size = listsOfData.get(k).length;
				int l = listsOfData.get(k)[0];
				int r = listsOfData.get(k)[size-1];
				System.out.print((k+1)+ ") ");
				mergeSorting.sort(listsOfData.get(k), l, r);
				System.out.println("Number of iterations: "+ mergeSorting.getCountLoop());
			}
			
//			System.out.println("testing heap sort:");
//			for(int k = 0; k < listsOfData.size(); k++ ) {
//				System.out.print((k+1)+ ") ");
//				heapSorting.heapSort(listsOfData.get(k));
//			}
			
//			System.out.println("testing insertion sort:");
//			for(int k = 0; k < listsOfData.size(); k++ ) {
//				System.out.print((k+1)+ ") ");
//				insertionSorting.sort(listsOfData.get(k));
//			}
			
			
			
			
			
			
			
			//bubbleSorting.bubbleSort(listsOfData.get(1)); //zero grabs the first data set
	        
//			int[] arrayData = listsOfData.get(1); //gets specific array
//    		
//    		for(int x = 0; x < arrayData.length; x++) {
//    			System.out.println(arrayData[x]);
//    		}
    		
	      }
}
	

	



