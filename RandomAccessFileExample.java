package concepts.fileoperations;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;


public class RandomAccessFileExample {
	static void invoke() {
		try {
//			 RandomAccessFile file = new RandomAccessFile("test.txt", "r");  
			RandomAccessFile file = new RandomAccessFile("test.txt", "rws");
			file.writeInt(100); //0-3
			file.writeFloat(3434.90f);//4-7
			file.writeChars("java platform");//8-22
			file.writeLong(123123L);
			file.close();
			
			
			file=new RandomAccessFile("test.txt", "r");
			System.out.println(file.length());
			
			int dataint=file.readInt();
			System.out.println(dataint);
			
			file.seek(4);
			Float dataFloat=file.readFloat();
			System.out.println(dataFloat);
			
			file.seek(8);
			System.out.println(file.readLine());
//			byte [] obj =new byte[26];
//			int data = file.read(obj);
//			System.out.println(data);
//			for(int i=0;i<data;i++) {
//				System.out.println((char)obj[i]);
//				file.read();
//			}
//			 StringBuffer buffer = new StringBuffer();
//			 while(file.getFilePointer() < file.length()) {
//		         buffer.append(file.readLine()+System.lineSeparator());
//		      }
//		      String contents = buffer.toString();
//		      System.out.println("Contents of the file: \n"+contents);
//			

			file.seek(34);
			System.out.println("read long: "+file.readLong() );
			
			file.close();
			
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Other Exceptions: "+e.getMessage());
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		invoke();
	}

}
