package concepts.fileoperations;

//import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import java.io.InputStreamReader;
//import java.io.InputStream;

public class ByteClassArrayDemo {
	ByteArrayInputStream bis;
	ByteArrayOutputStream bos;
	FileOutputStream fos;
	FileInputStream fis;
	File file = new File("bufferedStreamOperations.txt");
	public void readFromByteArray() {
		try {
			fis = new FileInputStream(file);
			byte []byteArray = new byte[165]; 
			bis = new ByteArrayInputStream(byteArray);
			int data= fis.read(byteArray);//fis data fed into byteArray
			System.out.println(data);
			for(int i=0;i<byteArray.length;i++) {
//				System.out.print((char)data);
				System.out.print((char)byteArray[i]);
			}
			bis.close();
			System.out.println(file.length());
			}catch (Exception e) {
				
				e.printStackTrace();
			}
}
	
	
	public void writeToByteArray() {
		try {
			fos = new FileOutputStream(file);
			bos = new ByteArrayOutputStream();
			String str= "Buffered output streams"+"\ndefault buffer size is 512 bytes";
			byte b [] =str.getBytes();
			bos.write(b);//writing to the output stream
			bos.toByteArray();//converting the output steam data into byte array for passing it into file
			bos.writeTo(fos);//writing to the file
			bos.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
		
			e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		ByteClassArrayDemo demo = new ByteClassArrayDemo();
		demo.writeToByteArray();
		demo.readFromByteArray();
		
//		  try {
//			  System.out.println("Enter name");
//			  char cbuf[]= {'a','b','c'};
//			  int name= r.read(cbuf);
//			  System.out.println(name);
//		  }catch (Exception e) {
//			  e.getMessage();
//			// TODO: handle exception
//		}
		  
		//this entire snippet is replaced with Scanner class for improving char based data
//		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
//		System.out.println("Enter id:");
//		try {
//			int empid= Integer.parseInt(br.readLine());
//			System.out.println("EMP ID"+empid);
//			DataInputStream dis = new DataInputStream(System.in);
//			System.out.println("Enter NAME:");
//			String name=dis.readLine();
//			System.out.println("EMP NAME:"+name);
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}

