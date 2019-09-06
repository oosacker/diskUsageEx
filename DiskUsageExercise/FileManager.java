import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

public class FileManager {

	private long totalSize = 0;
	
	public FileManager() {

		Path p = Paths.get("C:\\");
		String path = p.toString();
		
		File file = new File(path);
		
		JFileChooser chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(file);
		
		chooser.setDialogTitle("Choose folder!!!");
	    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    int returnVal = chooser.showOpenDialog(null);
	    
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File newFile = chooser.getSelectedFile();
			//showFileList(newFile);
			showFileListFiltered(newFile, ".java");
		}
		
		else if(returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancel");
		}
		
		System.out.println("Total folder size: " +totalSize +" bytes");

	}
	
	/**
	 * Recursive method to read folder contents
	 * @param file
	 */
	public void showFileList(File file) {
		
		if(file.isDirectory()) {
			System.out.println("Folder: " +file.toString());
			System.out.println("----------------------------------------------");
		}
		
		else if(file.isFile()) {
			System.out.println("File: " +file.toString());
			System.out.println("Size: " +file.length() +" bytes");
			totalSize = totalSize + file.length();
			System.out.println("----------------------------------------------");
		}
		
		if(file.listFiles() == null) {
			return;
		}
		
		for(File tempFile : file.listFiles()) {
			showFileList(tempFile);
		}
		
	}
	
	/**
	 * Recursive method to read folder contents specifying file type
	 * @param file
	 */
	public void showFileListFiltered(File file, String fileExt) {
		
		if(file.isDirectory()) {
			System.out.println("Folder: " +file.toString());
			System.out.println("----------------------------------------------");
		}
		
		else if(file.isFile() && file.toString().endsWith(fileExt)) {
			System.out.println("File: " +file.toString());
			System.out.println("Size: " +file.length() +" bytes");
			totalSize = totalSize + file.length();
			System.out.println("----------------------------------------------");
		}
		
		if(file.listFiles() == null) {
			return;
		}
		
		for(File tempFile : file.listFiles()) {
			showFileListFiltered(tempFile, fileExt);
		}
		
	}
	
	

}
