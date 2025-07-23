package fromMultiThreading;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task17_FileIo2 {



	public static void main(String args[]) {
		FileOutputStream outfile = null;
		Scanner scanner = new Scanner(System.in);
		//String s=args[0]; // to input string from command line Scanner sc=new Scanner(System.in); 
		String s = scanner.nextLine();
		byte b1[] = s.getBytes();
		try {
			outfile = new FileOutputStream("in.txt");
			outfile.write(b1);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(-1);
		}
		System.out.println("Write Byte");
		System.out.println("Thank You...!!!");
	}
}
