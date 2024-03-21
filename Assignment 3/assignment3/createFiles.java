import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
public class createFiles 
{
	public static void createDataFiles() throws IOException 
	{
		for(int i = 1; i <= 50; i++) {
	        String FileName = "dataFile_" + i + ".txt"; 
	        
	        FileWriter dataWriter = new FileWriter(FileName); //creates 50 files
	        
	        Random randomNumbers = new Random(); 
	        
	        for(int j = 0; j < i * 1000; j++) { // Increment by +1000 each file
	            int randomInt = randomNumbers.nextInt(1000 + (i-1) * 1000); 
	            
	            dataWriter.write(String.valueOf(randomInt)); // Convert integer to string 
	            dataWriter.write("\n"); // Write a newline character
	        } 
	        //System.out.println(dataWriter.write(String.valueOf(randomInt))));
	        dataWriter.close();
	    } 
	}
	
//	public static void main(String[] args) {
//        String directoryName = System.getProperty("user.dir");
//        System.out.println("Current directory: " + directoryName);
//    }
}
	
	
	
	
	

