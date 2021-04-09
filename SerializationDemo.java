package demo.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int productID;
	String productName;
	transient int productStock;
	float productPrice;
	
	public Product(int productID, String productName, int productStock, float productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productStock = productStock;
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productStock=" + productStock
				+ ", productPrice=" + productPrice + "]";
	}
}


public class SerializationDemo {

	File file= new File("product.data");
	FileOutputStream fos;
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public void serialize() {
		Product product = new Product(100, "Mobile", 500,12000.00f);
		System.out.println(product.toString());
		try {
			fos = new FileOutputStream(file);// FileNotFoundException
			oos = new ObjectOutputStream(fos);//IOException
			oos.writeObject(product);
			System.out.println("Successfully written a object into a file");
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}	
		
	}
	public void deserialize() {
		try {
			fis= new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Product dataobj=(Product)ois.readObject();
			System.out.println(dataobj.productStock);//transient if you don't want to store in object permenantly
			//read the object and convert into files
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		SerializationDemo serial = new SerializationDemo();
		serial.serialize();
		serial.deserialize();
	}

}
