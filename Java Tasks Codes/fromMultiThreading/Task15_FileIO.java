package fromMultiThreading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task15_FileIO 
{ 
	public static void main(String[] args) {
		
		File f1 = new File("FileName01.txt"); // create new file reference
		FileOutputStream outfile = null;
		
		byte[] Text = {'I', ' ', 'L', 'O', 'V', 'E', ' ', 'I', 'N', 'D', 'I', 'A'} ;
		
		try {
			outfile = new FileOutputStream(f1,true); // creates the file if it doesn't exist
			outfile.write(Text);
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
			System.exit(-1);
		} finally {
			try {
				if (outfile != null) {
					outfile.close(); // close the stream
				}
			} catch (IOException e) {
				System.out.println("Error closing stream: " + e);
			}
		}
		
		System.out.println("Write Byte");
		System.out.println("Thank You...!!!");
	}


 
}  

