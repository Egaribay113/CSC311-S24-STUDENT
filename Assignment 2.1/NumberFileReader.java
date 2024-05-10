//Eric Garibay
//egaribay19@toromail.csudh.edu
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
	
	/**
	 * reads the contents of file, stores them into a list then converts the list into an array to then return an array
	 * of values. 
	 * @param FileName
	 * @return returns an array
	 */
	public int[] read(String FileName) {
		
		 List<Integer> numbersList = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                numbersList.add(Integer.parseInt(line.trim()));
	            }
	        } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        array = new int[numbersList.size()];
	        for (int i = 0; i < numbersList.size(); i++) {
	            array[i] = numbersList.get(i);
	        }
	        return array;
	    } 
	}
	
	
	
	
	
	
	
	
	
	
	


