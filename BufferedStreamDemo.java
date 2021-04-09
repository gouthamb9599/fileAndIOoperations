package concepts.fileoperations;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
// buffered i/o stream used to move(skip) and check the data in the file which is not possible in file i/o stream 
public class BufferedStreamDemo {
	BufferedInputStream bis;
	BufferedOutputStream bos;
	FileOutputStream fos;
	FileInputStream fis;
	File file = new File("bufferedStreamOperations.txt");
	
	public void readFromBuffer() {
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			try {
				System.out.println(file.length());
				System.out.println(bis.markSupported());
//				System.out.println(bis.mark(20));
				//mark 
				System.out.println(
			            "Char : "
			            + (char)bis.read());
			        System.out.println(
			            "Char : "
			            + (char)bis.read());
			        System.out.println(
			            "Char : "
			            + (char)bis.read());
			  
				bis.mark(0);
			    
			    
		        System.out.println(
		            "Char : "
		            + (char)bis.read());
		  
		        // Reset() is invoked
		        bis.reset();
//				bis.skip(5);//skip n bytes
				System.out.println("Data available:"+bis.available());
				int data= bis.read();
				while(data!=-1) {
					System.out.print((char)data);
					bis.mark(data);
					data=bis.read();
					
				}
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void writeToBuffer() {
		
		
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			String str= "Buffered output streams"+"\ndefault buffer size is 512 bytes";
			byte b [] =str.getBytes();
			bos.write(b);
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	public static void main(String[] args) {
		BufferedStreamDemo demo = new BufferedStreamDemo();
		demo.writeToBuffer();
		demo.readFromBuffer();
	}
}
