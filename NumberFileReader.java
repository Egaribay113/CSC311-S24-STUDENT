//Eric Garibay
//egaribay19@toromail.csudh.edu
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class NumberFileReader {

	private int []array; 
	private String name;
	private String fileName; 
	
	NumberFileReader(String FileName) {
		
		this.fileName = FileName; 
	}
	
	public NumberFileReader(FileReader fileReader) {
		
	}

	public int[] read(String FileName) {
		
		 List<Integer> numbersList = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                numbersList.add(Integer.parseInt(line.trim()));
	            }
	        }
	        
	        array = new int[numbersList.size()];
	        for (int i = 0; i < numbersList.size(); i++) {
	            array[i] = numbersList.get(i);
	        }
	        return array;
	    } 
	}
	
	
	
	
	
	
	
	
	
	
	
}

