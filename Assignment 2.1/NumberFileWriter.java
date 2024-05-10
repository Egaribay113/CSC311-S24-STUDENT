import java.io.FileWriter;
import java.io.IOException;
import java.util.Random; 
import java.util.Scanner; 
//Eric Garibay
//egaribay19@toromail.csudh.edu
public class NumberFileWriter {

	private int[] arrayOfIntegers; 
	private String name; 
	
	NumberFileWriter(String fileName)
	{
		this.name = fileName; 
		
		
	}
	
	public void write(int[]arrayOfIntegers) throws IOException {
		
		//String FileName = "datafile.txt"; //modify to any file name
		 
	      FileWriter dataWriter = new FileWriter(name); //creates file
	        
	        		
	        		for(int i = 0; i < arrayOfIntegers.length; i++) {
	        			
	        			dataWriter.write(Integer.toString(arrayOfIntegers[i]));
	        			dataWriter.write("\n"); 
	        			
	        		}
	        			dataWriter.close();
	     
	        	  
	        
	        
	        
		
		
		
		
		
		
	}
	
	
	
	
	
}
