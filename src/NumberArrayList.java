//Eric Garibay
//Egaribay19@toromail.csudh.edu
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
public class NumberArrayList {

	private int number;
	private int index;
	private int[] myArray;
	
	Scanner keyboard = new Scanner(System.in); 

	
	NumberArrayList(int size){
		
		myArray = new int[size]; 
		
	 
	}
	
	public int add (int number) { //will return an index or location of the new entry 
		
		int userInput = keyboard.nextInt(); 
		
			int[] myArray = new int[userInput];
			
				for(int i = 0; i < myArray.length; i++) {
					
					System.out.println("Enter the element at index "+ i); 
					
						myArray[i] = keyboard.nextInt(); 
						
							index = myArray[i]; 	
				}
		
							return index;    
	
	}	
	
	public int get(int index) {
		
		while(index < 0 || index >= myArray.length) {
			System.out.println(""); 
		}
				return myArray[index]; 
		
	}
	
	public int size(int size) {
		
			return size;
		
	}
	
	public int[] find(int number) {
		
		
		List<Integer> indices = new ArrayList<>();
		
			for(int i = 0; i < myArray.length; i++) {
				if(myArray[i] == number) {
					indices.add(i); 
			}
			
			 
		}
			int[] arrayOfIndices = new int[indices.size()];
				for(int i = 0; i< indices.size(); i++) {
					arrayOfIndices[i] = indices.get(i);
			}
		
						return arrayOfIndices; 
	}
	
	public int getLargest() {
		
		int largestNum = myArray[0]; 
		
			if(myArray.length == 0) {
				return -1;
		}
		
			for(int i = 1; i < myArray.length; i++) {
						if(myArray[i] > largestNum) {
							largestNum = myArray[i]; 
			}
		}
			return largestNum; 
			
	}
	
	public int getSmallest() {
		
		int smallestNum = myArray[0];
		
		if(myArray.length == 0) {
			return -1; 
		}
		
		for(int i = 0; i < myArray.length; i++) {
			if(myArray[i] < smallestNum) {
				smallestNum = myArray[i]; 
			}
		}
			return smallestNum; 
	}
	
	public int getAverage() {
		
		int average = 0; 
		if(myArray.length == 0) {
			return -1; 
		}
		
		for(int i = 0; i < myArray.length; i++) {
			int total = myArray[i];
			average = average + total; 
		}
		
		return (average/myArray.length); 
	}
	
	
}

	
		
	
	
	
	

