import java.io.File;
public class DeleteFiles {

	public static void deleteTxtFiles(String directoryName) {
        File directory = new File(directoryName);
        File[] files = directory.listFiles();

        if (files != null) { // Check if files array is not null
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    if (file.delete()) {
                        System.out.println("Deleted file: " + file.getName());
                    } else {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("No files found in the specified directory.");
        }
    }

    public static void main(String[] args) {
        String directoryName = "/Users/soul/eclipse-workspace/Assignment 3"; 
        deleteTxtFiles(directoryName);
    }
	
	
}
