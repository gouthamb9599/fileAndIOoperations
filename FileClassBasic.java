package concepts.fileoperations;

import java.io.*;
public class FileClassBasic {

	static void fileOperations() {
		//directory creation
		File directory = new File("C:\\Users\\goutham.balaji\\eclipse-workspace\\FileConcepts\\src\\concepts\\filesset");
		
		
		boolean dirCreated = directory.mkdir();
		//adding new files to the directory
		File file1 = new File("C:\\Users\\goutham.balaji\\eclipse-workspace\\FileConcepts\\src\\concepts\\filesset\\myfile.txt");
		File file2 = new File("C:\\Users\\goutham.balaji\\eclipse-workspace\\FileConcepts\\src\\concepts\\filesset\\myfile2.txt");
		File file3 = new File("C:\\Users\\goutham.balaji\\eclipse-workspace\\FileConcepts\\src\\concepts\\filesset\\myfile3.txt");
		try {
			file1.createNewFile();
			file2.createNewFile();
			file3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Directory creation status(multiple file storage): "+dirCreated);
		if(directory.isDirectory()) {
			String files[]=directory.list();
			System.out.println("Contents in the directory");
			for (String s:files) {
				System.out.println(s);
			}
		}
		
		File fileBasic = new File("C:\\Users\\goutham.balaji\\eclipse-workspace\\FileConcepts\\src\\concepts\\files\\myfile.txt");
		try {
			fileBasic.createNewFile();
			System.out.println("Can Read: "+fileBasic.canRead());
			System.out.println("Can Write: "+fileBasic.canWrite());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File Exists: "+fileBasic.exists());
		System.out.println("Is a File: "+fileBasic.isFile());
		System.out.println("File Length: "+fileBasic.length());
		System.out.println(fileBasic.getAbsolutePath());
		
		File directoryforRename = new File("C:\\Users\\goutham.balaji\\eclipse-workspace\\FileConcepts\\src\\concepts\\filesrenamed");
		boolean dirRenamedCreated = directoryforRename.mkdir();
		System.out.println(dirRenamedCreated);
		//renaming a file and storing it in a different location
		boolean rename_success = fileBasic.renameTo(new File("C:\\Users\\goutham.balaji\\eclipse-workspace\\FileConcepts\\src\\concepts\\filesrenamed\\renamed-file.txt"));
		System.out.println("rename status: "+rename_success);
//		deleting a file
		boolean delete_success = fileBasic.delete();
		System.out.println("deletion status: "+delete_success);
	}
	public static void main(String[] args) {
		fileOperations();
	}
}
