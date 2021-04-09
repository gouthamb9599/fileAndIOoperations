package concepts.fileoperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class StreamTokenizerDemo {
	//stream tokenizer function
		static void printStreamTokenizer(StreamTokenizer st) throws IOException{
			int token =0; 
			while((token = st.nextToken()) != StreamTokenizer.TT_EOF) { 
				//TT_EOF end of file 
				if(st.ttype == StreamTokenizer.TT_NUMBER) { 
					//TT_NUMBER number to display it <StreamTokenizerObject>.nval 
					System.out.println("Number: "+st.nval);
				} else if(st.ttype == StreamTokenizer.TT_WORD) {
					//TT_WORD word to display it <StreamTokenizerObject>.val
					System.out.println("Word: "+st.sval); 
				}else {
					System.out.println("Ordinary Char: "+(char)token); 
				}
			} 
		}
	 
	public static void main(String[] args) {
		FileReader fileReader = null;
//		   try {
//			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//			StreamTokenizer str = new StreamTokenizer(r);
//			System.out.println("Enter ID");
//			String empid= r.readLine();
//			printStreamTokenizer(str);
//			r.close();
//		} catch (NumberFormatException | IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
		try {
			fileReader = new FileReader("ioOperations.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		  StreamTokenizer st = new StreamTokenizer(fileReader);
			
		  //ordinary char 
		  try {
				st.ordinaryChar('A');
				printStreamTokenizer(st);
				fileReader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Using  resetSyntax method
			try {
				fileReader = new FileReader("ioOperations.txt");
				st = new StreamTokenizer(fileReader);
				System.out.println("\nAfter Using resetSyntax() method \n");
				st.resetSyntax();
				printStreamTokenizer(st);
				fileReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
