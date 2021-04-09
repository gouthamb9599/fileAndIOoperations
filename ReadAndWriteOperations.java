package concepts.fileoperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.RandomAccessFile;

public class ReadAndWriteOperations {
	File file =new File("ioOperations.txt");
	FileInputStream fis;
	FileOutputStream fos;

	public void readOperations() {
		
		try {
			fis = new FileInputStream(file);
			int data = 0;
			try {
				data = fis.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(data !=-1){
				System.out.print((char)data);
//				System.out.println((int)data);
				try {
					data=fis.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void writeOperations() {
		try{
			System.out.println("File Length: "+file.length());
			if(file.length()>0) {
			fos =new FileOutputStream(file,true);//to append add another parameter (boolean value:true) to the fileoutputstream
			}
			else {
				fos =new FileOutputStream(file);
			}
			try {
//				fos.write(65);
				 String s="Welcome to javapoint.";    
	             byte b[]=s.getBytes();//converting string into byte array    
	             fos.write(b); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ReadAndWriteOperations ros= new ReadAndWriteOperations();
		ros.writeOperations();
		ros.readOperations();
	}

}
