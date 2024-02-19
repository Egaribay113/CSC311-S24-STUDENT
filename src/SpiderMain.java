import java.util.Scanner; 
public class SpiderMain {

	public static void main(String[]args)
	
	{
		//NumberArrayList myList = new NumberArrayList(500); 
		
		Scanner keyboard = new Scanner(System.in); 
		
			System.out.println("Please enter size of array");
			int userSize = keyboard.nextInt(); 
			NumberArrayList myList = new NumberArrayList(userSize); 
		
		System.out.println("Please enter elements within array");
		for(int i = 0; i < userSize; i++) {
			int userIndex = myList.add(userSize);
			System.out.println("element added within index of "+ userIndex);
		}
		
		System.out.println("Specify index to retrieve element ");
			int usersIndex = keyboard.nextInt(); 
			int usersElement = myList.get(usersIndex); 
		System.out.println("Element within index: "+ usersIndex + "element: "+ usersElement);
			//int usersElement = myList.get(usersIndex); 
		
		System.out.println("Please enter element you want to locate: ");
		  	int locateUserNum = keyboard.nextInt(); 
		  	int[] indicesArray = myList.find(locateUserNum);
		  	
		  	System.out.println("Located indices within array: "+ locateUserNum);
		  		for(int i = 0; i < indicesArray.length; i++) {
		  			System.out.println(indicesArray[i]);
		  		}
		  		
		  		int largestUserNum =  myList.getLargest();
		  		
		  		System.out.println("Largest number within array: "+ largestUserNum);
		  		
		  		int smallestUserNum = myList.getSmallest(); 
		  		
		  		System.out.println("Smallest number within array: "+ smallestUserNum);
		  		
		  		int averageNumOfUser = myList.getAverage();
		  		
		  		System.out.println("The overall average within array: "+ averageNumOfUser); 
		  		
		  	System.out.println("This is the size of your list: "+ myList.add(userSize));
		  	
		  	
		  	
		 
		
		
	
		
		
		
		
		
		
		
		
	}
}
